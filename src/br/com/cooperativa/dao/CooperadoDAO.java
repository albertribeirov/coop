package br.com.cooperativa.dao;

import br.com.cooperativa.model.Cooperado;

import javax.persistence.Query;
import java.util.List;

public class CooperadoDAO extends DAO {
    @SuppressWarnings("unchecked")
    public List<Cooperado> listarCooperados() {
        return criarQuery("SELECT c FROM Cooperado c").getResultList();
    }

    public boolean existeCooperadoComNome(String nome) {
        String query = "SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome ";
        Query q = criarQuery(query);
        q.setParameter("nome", nome);
        return q.getResultList().isEmpty();
    }

    public boolean existeCooperadoComCpf(String cpf) {
        String query = "SELECT COUNT(c) FROM Cooperado c WHERE c.cpf = :cpf ";
        Query q = criarQuery(query);
        q.setParameter("cpf", cpf);
        return q.getResultList().isEmpty();
    }

    public Cooperado buscarCooperadoPorNome(String nome) {
        String query = "SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome ";
        Query q = criarQuery(query);
        q.setParameter("nome", nome);
        return (Cooperado) q.getResultList().get(0);
    }

    public boolean buscarCooperadoPorNomeAndId(String nome, Integer id) {
        String query = "SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome AND c.id = :id ";
        Query q = criarQuery(query);
        q.setParameter("nome", nome);
        q.setParameter("id", id);
        long count = (Long) q.getResultList().get(0);
        return count > 0;
    }

    public Cooperado buscarCooperadoPorCpf(String cpf) {
        String query = "SELECT COUNT(c) FROM Cooperado c WHERE c.cpf = :cpf";
        Query q = criarQuery(query);
        q.setParameter("cpf", cpf);
        return (Cooperado) q.getResultList().get(0);
    }
}
