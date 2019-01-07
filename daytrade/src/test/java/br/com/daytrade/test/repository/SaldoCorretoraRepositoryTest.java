package br.com.daytrade.test.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daytrade.domain.Corretora;
import br.com.daytrade.domain.SaldoCorretora;
import br.com.daytrade.repository.SaldoCorretoraRepository;
import br.com.daytrade.service.CorretoraService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaldoCorretoraRepositoryTest {
    
    @Autowired 
    private CorretoraService corretoraService;
    
    @Autowired
    private SaldoCorretoraRepository saldoCorretoraRepository;
    
    @Test
    public void insereTest() {
        
        LocalDate localDate = LocalDate.parse("2019-01-02");
        Date data = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        String arquivo = "D:\\ambiente-de-trabalho\\@\\day_trade\\workspace\\banco-de-dados\\SaldoCorretora_02_01_2019.csv";
        
        Map<String, Integer> map = this.corretoraService.buscaTodosMem();
        
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(arquivo), "ISO-8859-1"))){
            
            String line = reader.readLine();
            
            while(line != null) {
                //System.out.println(line);                
                String[] val = line.split(";");
                
                SaldoCorretora saldoCorretora = new SaldoCorretora();
                
                saldoCorretora.setPregao(data);
                saldoCorretora.setCorretora(new Corretora(map.get(val[0].toString())));
                saldoCorretora.setVolFinanceiro(new BigDecimal(val[1].replace(".", "")));
                saldoCorretora.setVolQuantidade(new BigDecimal(val[2].replace(".", "")));
                saldoCorretora.setMedia(new BigDecimal(val[3].replace(".", "").replace(",", ".")));
                                
                //System.out.println(saldoCorretora);
                this.saldoCorretoraRepository.save(saldoCorretora);
                
                line = reader.readLine();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }                
    }  
   
}