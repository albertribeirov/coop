package br.com.cooperativa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "rua_com_numero", unique = true, nullable = false, length = 60)
    private String ruaComNumero;

    @Column(nullable = false, length = 30)
    private String bairro;

    @Column(nullable = false, length = 30)
    private String cidade;

    @Column(length = 8)
    private String cep;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getRuaComNumero() {
        return ruaComNumero;
    }

    public void setRuaComNumero(String nomeDaRua) {
        this.ruaComNumero = nomeDaRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        if (!id.equals(endereco.id)) return false;
        if (!ruaComNumero.equals(endereco.ruaComNumero)) return false;
        if (!bairro.equals(endereco.bairro)) return false;
        if (!cidade.equals(endereco.cidade)) return false;
        return Objects.equals(cep, endereco.cep);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + ruaComNumero.hashCode();
        result = 31 * result + bairro.hashCode();
        result = 31 * result + cidade.hashCode();
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        return result;
    }
}