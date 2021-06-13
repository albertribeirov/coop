package br.com.cooperativa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 11, nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "cooperado_id")
    private Cooperado cooperado;

    public Telefone() {
    }

    public Telefone(String numero) {
        this.numero = numero;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCooperado(Cooperado cooperado) {
        this.cooperado = cooperado;
    }

    public Cooperado getCooperado() {
        return cooperado;
    }
}
