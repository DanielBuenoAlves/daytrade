package br.com.daytrade.test.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daytrade.domain.Frequencia;
import br.com.daytrade.repository.FrequenciaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrequenciaRepositoryTest {
    
    @Autowired
    private FrequenciaRepository freqRepository;
    
    @Test
    public void buscaTodosTest() {
        
        Iterable<Frequencia> frequencias = this.freqRepository.findAll();
        
        int count = 0;
        for(Frequencia p : frequencias){
            System.out.println(p);
            count++;
        }   //3000,00
        assertEquals(count, 1);
        
    }
}
