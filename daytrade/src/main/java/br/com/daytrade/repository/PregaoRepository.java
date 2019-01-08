package br.com.daytrade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.daytrade.domain.Pregao;

public interface PregaoRepository extends CrudRepository<Pregao, Integer> {
        
    @Query("FROM Pregao p WHERE p.data >= :dataInicio ORDER BY p.data DESC")
    List<Pregao> buscaPorDias(@Param("dataInicio") Date dataInicio);

}