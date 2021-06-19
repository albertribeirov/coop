package br.com.cooperativa.ejb;


import br.com.cooperativa.model.Material;
import br.com.cooperativa.rn.RNInserirMaterialAndEstoqueInicialZerado;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ControladorEstoqueMaterialBean implements ControladorEstoqueMaterial {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void inserirMaterialAndEstoqueInicialZerado(Material material) {
        RNInserirMaterialAndEstoqueInicialZerado.getInstance().inserir(material, entityManager);
    }


}
