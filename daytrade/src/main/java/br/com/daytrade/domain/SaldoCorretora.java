package br.com.daytrade.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Saldo_Corretora")
public class SaldoCorretora {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="pregao")
    private Date pregao;
    
    @ManyToOne
    @JoinColumn(name="corretora")
    private Corretora corretora;
    
    @Column(name="volume_financeiro")
    private BigDecimal volFinanceiro;
    
    @Column(name="volume_quantidade")
    private BigDecimal volQuantidade;
    
    @Column(name="media")
    private BigDecimal media;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPregao() {
        return pregao;
    }

    public void setPregao(Date pregao) {
        this.pregao = pregao;
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }

    public BigDecimal getVolFinanceiro() {
        return volFinanceiro;
    }

    public void setVolFinanceiro(BigDecimal volFinanceiro) {
        this.volFinanceiro = volFinanceiro;
    }

    public BigDecimal getVolQuantidade() {
        return volQuantidade;
    }

    public void setVolQuantidade(BigDecimal volQuantidade) {
        this.volQuantidade = volQuantidade;
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
        builder.append("SaldoCorretora [id=").append(id).append(", pregao=").append(pregao).append(", corretora=")
                .append(corretora).append(", volFinanceiro=").append(volFinanceiro).append(", volQuantidade=")
                .append(volQuantidade).append(", media=").append(media).append("]");
        return builder.toString();
    }    
    
}
