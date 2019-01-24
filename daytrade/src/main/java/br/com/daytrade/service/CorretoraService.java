package br.com.daytrade.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.Corretora;
import br.com.daytrade.domain.SaldoCorretora;
import br.com.daytrade.repository.CorretoraRepository;
import br.com.daytrade.repository.SaldoCorretoraRepository;

@Service
public class CorretoraService {
    
    @Autowired
    private CorretoraRepository corretoraRepository;
    
    private SaldoCorretoraRepository saldoCorretoraRepository;
    
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
    
    public void carregarSaldo(String dataPregao, InputStream arquivo) {
        
        String s[] = dataPregao.split("/");
        LocalDate localDate = LocalDate.parse(s[2]+"-"+s[1]+"-"+s[0]);
        Date data = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        Map<String, Integer> map = this.buscaTodosMem();
        
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(arquivo, "ISO-8859-1"))){
            
            String linha = reader.readLine();
            
            while(linha != null) {
                //System.out.println(line);                
                String[] val = linha.split(";");
                
                SaldoCorretora saldoCorretora = new SaldoCorretora();
                
                saldoCorretora.setPregao(data);
                saldoCorretora.setCorretora(new Corretora(map.get(val[0].toString())));
                saldoCorretora.setVolFinanceiro(new BigDecimal(val[1].replace(".", "")));
                saldoCorretora.setVolQuantidade(new BigDecimal(val[2].replace(".", "")));
                saldoCorretora.setMedia(new BigDecimal(val[3].replace(".", "").replace(",", ".")));
                                
                //System.out.println(saldoCorretora);
                this.saldoCorretoraRepository.save(saldoCorretora);
                
                linha = reader.readLine();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }               
        
    }
    
}
