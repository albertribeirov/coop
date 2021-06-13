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
        String consulta = "SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome";
        Query query = criarQuery(consulta).setParameter(NOME, nome);
        return query.getResultList().isEmpty();
    }

    public boolean existeCooperadoComCpf(String cpf) {
        String consulta = "SELECT COUNT(c) FROM Cooperado c WHERE c.cpf = :cpf";
        Query query = criarQuery(consulta).setParameter(CPF, cpf);
        return query.getResultList().isEmpty();
    }

    public Cooperado buscarCooperadoPorNome(String nome) {
        String consulta = "SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome";
        Query query = criarQuery(consulta).setParameter(NOME, nome);
        return (Cooperado) query.getResultList().get(0);
    }

    public boolean buscarCooperadoPorNomeAndId(String nome, Integer id) {
        String consulta = "SELECT COUNT(c) FROM Cooperado c WHERE c.nomeCompleto = :nome AND c.id = :id";
        Query query = criarQuery(consulta);
        query.setParameter(NOME, nome).setParameter(ID, id);
        long count = (Long) query.getResultList().get(0);
        return count > 0;
    }

    public Cooperado buscarCooperadoPorCpf(String cpf) {
        String consulta = "SELECT COUNT(c) FROM Cooperado c WHERE c.cpf = :cpf";
        Query query = criarQuery(consulta).setParameter(CPF, cpf);
        return (Cooperado) query.getResultList().get(0);
    }
}
