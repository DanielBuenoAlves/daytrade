package br.com.daytrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.daytrade.domain.Corretora;

public interface CorretoraRepository extends CrudRepository<Corretora, Integer> {
    
    @Query("FROM Corretora c ORDER BY c.nome")
    List<Corretora> buscaTodos();
    
    
}
