package br.com.daytrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.Corretora;
import br.com.daytrade.repository.CorretoraRepository;

@Service
public class CorretoraService {
    
    @Autowired
    private CorretoraRepository corretoraRepository;
    
    
    public List<Corretora> buscaTodos(){
        
        
        return this.corretoraRepository.buscaTodos();
    }
    
    
}
