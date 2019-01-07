package br.com.daytrade.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daytrade.service.FrequenciaService;
import br.com.daytrade.service.vo.FrequenciaVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrequenciaServiceTest {

    @Autowired
    private FrequenciaService frequenciaService;
    
    @Test
    public void init() {
        
        FrequenciaVO vo = this.frequenciaService.frequenciaAtual();
        
        System.out.println(vo);
        
    }
    
}
