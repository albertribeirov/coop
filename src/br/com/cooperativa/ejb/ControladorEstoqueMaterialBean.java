package br.com.cooperativa.ejb;


import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.rn.RNInserirMaterialAndEstoqueInicialZerado;
import br.com.cooperativa.rn.RNInserirQuantidadeMaterialEmEstoque;
import br.com.cooperativa.rn.RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo;

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
    public void inserirMaterialAndEstoqueInicialZerado(Material material) throws Exception {
        RNInserirMaterialAndEstoqueInicialZerado.getInstance().inserir(material, entityManager);
    }

    @Override
    public void inserirQuantidadeMaterialEmEstoque(Estoque estoque) throws Exception {
        RNInserirQuantidadeMaterialEmEstoque.getInstance().inserir(estoque, entityManager);
    }

    @Override
    public void removerMovimentacaoEstoque(Integer id) throws ValidationException {
        RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo.getInstance().executar(id, entityManager);
    }
}
