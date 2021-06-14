package br.com.projetoav2.repository;

import br.com.projetoav2.model.Livro;
import org.springframework.data.repository.CrudRepository;

//para acessar o banco de dados

public interface LivroRepository extends CrudRepository <Livro, Long>{
    
}
