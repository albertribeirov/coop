package br.com.cooperativa.dao;

import br.com.cooperativa.model.Endereco;

import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
public class EnderecoDAO extends DAO {
    @SuppressWarnings("unchecked")
    public List<Endereco> listarEnderecos() {
        return criarQuery("SELECT e FROM Endereco e").getResultList();
    }

    public boolean existeEnderecoComRuaAndNumero(String ruaComNumero) {
        Query query = criarQuery("SELECT COUNT(e) FROM Endereco e WHERE e.ruaComNumero = :ruaComNumero")
                .setParameter("ruaComNumero", ruaComNumero);
        return !(query.getResultList().size() > 0);
    }

    public List<Endereco> buscarEnderecoPorRuaAndNumero(String ruaComNumero) {
        Query query = criarQuery("SELECT e FROM Endereco e WHERE e.ruaComNumero = :ruaComNumero")
                .setParameter("ruaComNumero", ruaComNumero);
        return (List<Endereco>) query.getResultList();
    }

    public List<Endereco> buscarEnderecoPorCEP(String cep) {
        Query query = criarQuery("SELECT e FROM Endereco e WHERE e.cep = :cep")
                .setParameter("cep", cep);
        return (List<Endereco>) query.getResultList();
    }
}
