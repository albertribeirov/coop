package br.com.cooperativa.dao;

import br.com.cooperativa.model.Cooperado;

import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
public class CooperadoDAO extends DAO {
    @SuppressWarnings("unchecked")
    public List<Cooperado> listarCooperados() {
        return criarQuery("SELECT c FROM Cooperado c").getResultList();
    }

    public boolean existeCooperadoComNome(String nome) {
        Query query = criarQuery("SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome")
                .setParameter(NOME, nome);
        return !(query.getResultList().size() > 0);
    }

    public boolean existeCooperadoComCpf(String cpf) {
        Query query = criarQuery("SELECT COUNT(c) FROM Cooperado c WHERE c.cpf = :cpf")
                .setParameter(CPF, cpf);
        return !(query.getResultList().size() > 0);
    }

    public Cooperado buscarCooperadoPorNome(String nome) {
        Query query = criarQuery("SELECT c FROM Cooperado c WHERE c.nomeCompleto = :nome")
                .setParameter(NOME, nome);
        return (Cooperado) query.getSingleResult();
    }

    public List<Cooperado> buscarCooperadoPorCpf(String cpf) {
        Query query = criarQuery("SELECT c FROM Cooperado c WHERE c.cpf = :cpf")
                .setParameter(CPF, cpf);
        return (List<Cooperado>) query.getResultList();

    }
}
