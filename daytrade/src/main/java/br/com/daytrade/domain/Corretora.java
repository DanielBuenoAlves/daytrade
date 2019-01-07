package br.com.daytrade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Corretora")
public class Corretora {

    @Id
    @Column(name="id")
    private Integer id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="cor_primaria")
    private String corPrimaria;
    
    @Column(name="cor_secundaria")
    private String corSecundaria;
    
    public Corretora(Integer id) {
        this.id = id;
    }
    
    public Corretora() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorPrimaria() {
        return corPrimaria;
    }

    public void setCorPrimaria(String corPrimaria) {
        this.corPrimaria = corPrimaria;
    }

    public String getCorSecundaria() {
        return corSecundaria;
    }

    public void setCorSecundaria(String corSecundaria) {
        this.corSecundaria = corSecundaria;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Corretora [id=").append(id).append(", nome=").append(nome).append(", corPrimaria=")
                .append(corPrimaria).append(", corSecundaria=").append(corSecundaria).append("]");
        return builder.toString();
    }       
    
}
