package br.com.daytrade.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.Corretora;
import br.com.daytrade.repository.CorretoraRepository;

@Service
public class CorretoraService {
    
    @Autowired
    private CorretoraRepository corretoraRepository;
    
    private Map<String, Integer> corretorasMap = new HashMap<String, Integer>();
    
    @PostConstruct
    public void init() {
        List<Corretora> corretoras = this.corretoraRepository.buscaTodos();        
        for(Corretora cor : corretoras) {
            this.corretorasMap.put(cor.getNome(), cor.getId());
        }
    }
        
    public List<Corretora> buscaTodos(){                
        return this.corretoraRepository.buscaTodos();
    }
    
    public Map<String, Integer> buscaTodosMem(){                               
        return this.corretorasMap;
    }
    
    
}
