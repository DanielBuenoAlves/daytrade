package br.com.daytrade.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.SaldoCorretora;
import br.com.daytrade.repository.SaldoCorretoraRepository;

@Service
public class SaldoCorretoraService {
    
    @Autowired
    private SaldoCorretoraRepository scRepository;
    
    public List<SaldoCorretora> busca(Date dataInicio, Date dataFim, Integer idCorretora){
        
        return this.scRepository.buscaSaldo(dataInicio, dataFim, idCorretora);
        
    }
}
