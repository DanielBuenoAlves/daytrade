package br.com.daytrade.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.daytrade.domain.SaldoCorretora;

public interface SaldoCorretoraRepository extends CrudRepository<SaldoCorretora, Long> {
    
}
