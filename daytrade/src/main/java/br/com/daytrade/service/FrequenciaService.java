package br.com.daytrade.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.Frequencia;
import br.com.daytrade.repository.FrequenciaRepository;

@Service
public class FrequenciaService {
    
    @Autowired
    private FrequenciaRepository frequenciaRepository;
    
    public List<Frequencia> buscaPorDias(int qtdDias){
        
        LocalDate data = LocalDate.now().minusDays(qtdDias);
        
        Date dataPesquisa = Date.from(data.atStartOfDay()
                                .atZone(ZoneId.systemDefault())
                                .toInstant());
        
        return (List<Frequencia>) this.frequenciaRepository.buscaPorDias(dataPesquisa);
    }
        
    
    public void frequenciaAtual() {
        
        List<Frequencia> frequencias = this.buscaPorDias(15);
        int cont = 0;
        
        BigDecimal ultimos3 = new BigDecimal(0);
        BigDecimal ultimos5 = null;
        
        for(Frequencia fre : frequencias) {
            
            //Ultimos 3
            if(cont < 3) {
                ultimos3 = ultimos3.add(fre.getMedia());
            } else if(cont > 3 && cont < 5) {
                ultimos5 = ultimos5.add(fre.getMedia());
            }
                        
            cont++;
        }
        
    }
    
    
    public void cadastrar(Frequencia frequencia) {
        
        //Calcula a média da frequencia (máxima - minima) - 10%        
        frequencia.setMedia(
                this.percentual(frequencia.getMaxima().subtract(frequencia.getMinima())
                                , new BigDecimal(10)));
        
        this.frequenciaRepository.save(frequencia);        
    }            
    
    private BigDecimal percentual(BigDecimal base, BigDecimal percentual) {        
        return base.multiply(percentual).divide(new BigDecimal(100));
    }
        
}
