package br.com.daytrade.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Frequencia")
public class Frequencia {
        
    @Id
    @Column(name="pregao")
    private Date pregao;
    
    @Column(name="abertura")
    private BigDecimal abertura;
    
    @Column(name="maxima")
    private BigDecimal maxima;
    
    @Column(name="minima")
    private BigDecimal minima;
    
    @Column(name="fechamento")
    private BigDecimal fechamento;
    
    @Column(name="media")
    private BigDecimal media;

    public Date getPregao() {
        return pregao;
    }

    public void setPregao(Date pregao) {
        this.pregao = pregao;
    }

    public BigDecimal getAbertura() {
        return abertura;
    }

    public void setAbertura(BigDecimal abertura) {
        this.abertura = abertura;
    }

    public BigDecimal getMaxima() {
        return maxima;
    }

    public void setMaxima(BigDecimal maxima) {
        this.maxima = maxima;
    }

    public BigDecimal getMinima() {
        return minima;
    }

    public void setMinima(BigDecimal minima) {
        this.minima = minima;
    }

    public BigDecimal getFechamento() {
        return fechamento;
    }

    public void setFechamento(BigDecimal fechamento) {
        this.fechamento = fechamento;
    }        

    public BigDecimal getMedia() {
        return media;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Frequencia [pregao=").append(pregao).append(", abertura=").append(abertura).append(", maxima=")
                .append(maxima).append(", minima=").append(minima).append(", fechamento=").append(fechamento)
                .append(", media=").append(media).append("]");
        return builder.toString();
    }    
    
}
