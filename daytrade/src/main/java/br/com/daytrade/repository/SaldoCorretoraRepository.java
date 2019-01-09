package br.com.daytrade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.daytrade.domain.SaldoCorretora;

public interface SaldoCorretoraRepository extends CrudRepository<SaldoCorretora, Long> {
    
    @Query("FROM SaldoCorretora c WHERE c.corretora.id = :idCorretora AND c.pregao BETWEEN :dataInicio AND :dataFim ORDER BY c.pregao ASC")
    List<SaldoCorretora> buscaSaldo(@Param("dataInicio") Date dataInicio
                                    , @Param("dataFim") Date dataFim
                                    , @Param("idCorretora") Integer idCorretora);
    
}
