package br.com.daytrade.test.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daytrade.domain.Pregao;
import br.com.daytrade.repository.PregaoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrequenciaRepositoryTest {
    
    @Autowired
    private PregaoRepository freqRepository;
    
    @Test
    public void buscaTodosTest() {
        
        Iterable<Pregao> frequencias = this.freqRepository.findAll();
        
        int count = 0;
        for(Pregao p : frequencias){
            System.out.println(p);
            count++;
        }   //3000,00
        assertEquals(count, 1);
        
    }
}
