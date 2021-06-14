package br.com.projetoav2.controller;

import br.com.projetoav2.model.Livro;
import br.com.projetoav2.repository.LivroRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/gerenciarLivros")
    public String listarLivros(Model model) {
        model.addAttribute("listaLivros", livroRepository.findAll());
        return "gerenciar_livros";
    }

    @GetMapping("/novoLivro")
    public String novoLivro (Model model) {
        model.addAttribute("livro", new Livro());
        return "editar_livro";
    }
    
    @PostMapping("/salvarLivro")
    public String salvarLivro(Livro livro, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_livro";
        }
        livroRepository.save(livro);
        return "redirect:/gerenciarLivros";
    }
@GetMapping("/excluirLivro/{id}")
    public String excluirLivro(@PathVariable("id") long idLivro) {
       livroRepository.deleteById(idLivro);
        return "redirect:/gerenciarLivros";
    }
    
    @GetMapping("/editarLivro/{id}")
    public String editarLivro(@PathVariable("id") long idLivro, Model model) {
        Optional<Livro> livro = livroRepository.findById(idLivro);
        model.addAttribute("livro", livro.get());
        return "editar_livro";
    }
}
