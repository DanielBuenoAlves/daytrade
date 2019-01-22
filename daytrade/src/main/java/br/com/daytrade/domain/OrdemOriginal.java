package br.com.daytrade.domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Ordem_Original")
public class OrdemOriginal {
    
    @Id @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="pregao")
    private Date pregao;
    
    @Column(name="hora")
    private Time hora;
    
    @ManyToOne
    @JoinColumn(name="corretora")
    private Corretora corretora;
    
    @Column(name="quantidade")
    private Integer quantidade;
    
    @Column(name="valor")
    private BigDecimal valor;
    
    @Column(name="agressor")
    private char agressor;

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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }        

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public char getAgressor() {
        return agressor;
    }

    public void setAgressor(char agressor) {
        this.agressor = agressor;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrdemOriginal [id=").append(id).append(", pregao=").append(pregao).append(", hora=")
                .append(hora).append(", corretora=").append(corretora).append(", quantidade=").append(quantidade)
                .append(", valor=").append(valor).append(", agressor=").append(agressor).append("]");
        return builder.toString();
    }    
    
}
