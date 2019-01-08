package br.com.daytrade.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daytrade.domain.Pregao;
import br.com.daytrade.repository.PregaoRepository;
import br.com.daytrade.service.vo.FrequenciaVO;

@Service
public class PregaoService {
    
    @Autowired
    private PregaoRepository pregaoRepository;
    
    public List<Pregao> buscaPorDias(int qtdDias){
        
        LocalDate data = LocalDate.now().minusDays(qtdDias);
        
        Date dataPesquisa = Date.from(data.atStartOfDay()
                                .atZone(ZoneId.systemDefault())
                                .toInstant());
        
        return (List<Pregao>) this.pregaoRepository.buscaPorDias(dataPesquisa);
    }
        
    
    public FrequenciaVO frequenciaAtual() {
        //FIXME:Corrigir para buscar a data do ultimo pregão!
        List<Pregao> pregoes = this.buscaPorDias(20);
        int cont = 0;
        
        BigDecimal ultimos3 = new BigDecimal(0);
        BigDecimal ultimos5 = new BigDecimal(0);
        BigDecimal ultimos7 = new BigDecimal(0);
        
        for(Pregao pre : pregoes) {
            
            //Ultimos 3
            if(cont < 3) {
                ultimos3 = ultimos3.add(pre.getMedia());
            } 
            if(cont < 5) {
                ultimos5 = ultimos5.add(pre.getMedia());
            }
            if(cont < 7) {
                ultimos7 = ultimos7.add(pre.getMedia());
            }
                        
            cont++;
        }
        

        FrequenciaVO vo = new FrequenciaVO(pregoes.get(0).getData(), pregoes.get(6).getData());
        
        vo.setUltimos3Pregoes(ultimos3.divide(new BigDecimal(3), 2, RoundingMode.HALF_UP));
        vo.setUltimos5Pregoes(ultimos5.divide(new BigDecimal(5), 2, RoundingMode.HALF_UP));
        vo.setUltimos7Pregoes(ultimos7.divide(new BigDecimal(7), 2, RoundingMode.HALF_UP));
        
        return vo;
        
    }
    
    
    public void cadastrar(Pregao pregao) {
        
        //Calcula a média da frequencia (máxima - minima) - 10%        
        pregao.setMedia(
                this.percentual(pregao.getMaxima().subtract(pregao.getMinima())
                                , new BigDecimal(10)));
        
        this.pregaoRepository.save(pregao);        
    }            
    
    private BigDecimal percentual(BigDecimal base, BigDecimal percentual) {        
        return base.multiply(percentual).divide(new BigDecimal(100));
    }
        
}
