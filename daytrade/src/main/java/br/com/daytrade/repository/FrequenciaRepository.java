package br.com.daytrade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.daytrade.domain.Frequencia;

public interface FrequenciaRepository extends CrudRepository<Frequencia, Integer> {
        
    @Query("FROM Frequencia f WHERE f.pregao >= :dataInicio ORDER BY f.pregao DESC")
    List<Frequencia> buscaPorDias(@Param("dataInicio") Date dataInicio);

}