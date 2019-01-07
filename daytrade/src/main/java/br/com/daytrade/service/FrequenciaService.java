package br.com.daytrade.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.Frequencia;
import br.com.daytrade.repository.FrequenciaRepository;
import br.com.daytrade.service.vo.FrequenciaVO;

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
        
    
    public FrequenciaVO frequenciaAtual() {
        //FIXME:Corrigir para buscar a data do ultimo pregão!
        List<Frequencia> frequencias = this.buscaPorDias(25);
        int cont = 0;
        
        BigDecimal ultimos3 = new BigDecimal(0);
        BigDecimal ultimos5 = new BigDecimal(0);
        BigDecimal ultimos7 = new BigDecimal(0);
        
        for(Frequencia fre : frequencias) {
            
            //Ultimos 3
            if(cont < 3) {
                ultimos3 = ultimos3.add(fre.getMedia());
            } 
            if(cont < 5) {
                ultimos5 = ultimos5.add(fre.getMedia());
            }
            if(cont < 7) {
                ultimos7 = ultimos7.add(fre.getMedia());
            }
                        
            cont++;
        }
        

        FrequenciaVO vo = new FrequenciaVO(frequencias.get(0).getPregao(), frequencias.get(6).getPregao());
        
        vo.setUltimos3Pregoes(ultimos3.divide(new BigDecimal(3), 2, RoundingMode.HALF_UP));
        vo.setUltimos5Pregoes(ultimos5.divide(new BigDecimal(5), 2, RoundingMode.HALF_UP));
        vo.setUltimos7Pregoes(ultimos7.divide(new BigDecimal(7), 2, RoundingMode.HALF_UP));
        
        return vo;
        
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
