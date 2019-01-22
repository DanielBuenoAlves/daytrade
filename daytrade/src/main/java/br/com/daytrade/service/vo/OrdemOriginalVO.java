package br.com.daytrade.service.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdemOriginalVO {
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date pregao;
    
    private String agressao;
    
    private Integer quantidade;
    
    private Integer corretora;

    public Date getPregao() {
        return pregao;
    }

    public void setPregao(Date pregao) {
        this.pregao = pregao;
    }

    public String getAgressao() {
        return agressao;
    }

    public void setAgressao(String agressao) {
        this.agressao = agressao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCorretora() {
        return corretora;
    }

    public void setCorretora(Integer corretora) {
        this.corretora = corretora;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrdemOriginalVO [pregao=").append(pregao).append(", agressao=").append(agressao)
                .append(", quantidade=").append(quantidade).append(", corretora=").append(corretora).append("]");
        return builder.toString();
    }    
    
}
