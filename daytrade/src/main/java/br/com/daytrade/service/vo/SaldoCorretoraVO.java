package br.com.daytrade.service.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SaldoCorretoraVO {
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;
    
    private Integer idCorretora;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getIdCorretora() {
        return idCorretora;
    }

    public void setIdCorretora(Integer idCorretora) {
        this.idCorretora = idCorretora;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SaldoCorretoraVO [dataInicio=").append(dataInicio).append(", dataFim=").append(dataFim)
                .append(", idCorretora=").append(idCorretora).append("]");
        return builder.toString();
    }
    
}
