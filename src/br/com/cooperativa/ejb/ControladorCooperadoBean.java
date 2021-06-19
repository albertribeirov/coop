package br.com.cooperativa.ejb;

import br.com.cooperativa.model.Cooperado;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ControladorCooperadoBean implements ControladorCooperado {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cooperado inserirCooperado(Cooperado cooperado) {
        entityManager.persist(cooperado);
        return cooperado;
    }


    @Override
    public Cooperado alterarCooperado(Cooperado cooperado) {
        entityManager.merge(cooperado);
        return cooperado;
    }
}
