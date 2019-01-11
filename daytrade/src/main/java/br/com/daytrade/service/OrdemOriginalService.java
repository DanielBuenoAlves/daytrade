package br.com.daytrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.repository.OrdermOriginalRepository;

@Service
public class OrdemOriginalService {
    
    @Autowired
    private OrdermOriginalRepository ordemOriRepository;
    
    
    
}
