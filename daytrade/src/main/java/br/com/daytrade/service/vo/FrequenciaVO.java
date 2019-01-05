package br.com.daytrade.service.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FrequenciaVO {
    
    private Date dataInicial;
    
    private Date dataFinal;
    
    private BigDecimal ultimos3Pregoes;
    
    private BigDecimal ultimos5Pregoes;
    
    private BigDecimal ultimos7Pregoes;
    
    public FrequenciaVO() {
        
    }

    public FrequenciaVO(Date dataInicial, Date dataFinal) {
        super();
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public BigDecimal getUltimos3Pregoes() {
        return ultimos3Pregoes;
    }

    public void setUltimos3Pregoes(BigDecimal ultimos3Pregoes) {
        this.ultimos3Pregoes = ultimos3Pregoes;
    }

    public BigDecimal getUltimos5Pregoes() {
        return ultimos5Pregoes;
    }

    public void setUltimos5Pregoes(BigDecimal ultimos5Pregoes) {
        this.ultimos5Pregoes = ultimos5Pregoes;
    }

    public BigDecimal getUltimos7Pregoes() {
        return ultimos7Pregoes;
    }

    public void setUltimos7Pregoes(BigDecimal ultimos7Pregoes) {
        this.ultimos7Pregoes = ultimos7Pregoes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FrequenciaVO [dataInicial=").append(dataInicial).append(", dataFinal=").append(dataFinal)
                .append(", ultimos3Pregoes=").append(ultimos3Pregoes).append(", ultimos5Pregoes=")
                .append(ultimos5Pregoes).append(", ultimos7Pregoes=").append(ultimos7Pregoes).append("]");
        return builder.toString();
    }       
    
}
