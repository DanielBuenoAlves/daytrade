package br.com.daytrade.test.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daytrade.domain.Corretora;
import br.com.daytrade.repository.CorretoraRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CorretoraRepositoryTest {
    
    @Autowired
    private CorretoraRepository corretoraRepository;
   
    
    @Test
    public void buscaTodosTest() {
        
        List<Corretora> corretoras = this.corretoraRepository.buscaTodos();
        
        for(Corretora cor : corretoras) {
            System.out.println(cor);
        }
        
    }
}
