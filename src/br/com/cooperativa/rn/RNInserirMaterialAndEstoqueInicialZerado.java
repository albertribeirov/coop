package br.com.cooperativa.rn;

import br.com.cooperativa.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.MovimentacaoEstoque;

import javax.persistence.EntityManager;

public class RNInserirMaterialAndEstoqueInicialZerado {

    private static RNInserirMaterialAndEstoqueInicialZerado regraDeNegocio = new RNInserirMaterialAndEstoqueInicialZerado();

    public static RNInserirMaterialAndEstoqueInicialZerado getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNInserirMaterialAndEstoqueInicialZerado();
        }
        return regraDeNegocio;
    }

    public void inserir(Material material, EntityManager entityManager) throws Exception {

        Estoque estoque = new Estoque(0, material);
        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque(0, TipoMovimentacaoEstoque.ENTRADA, material.getTipoMaterial(), material);

        entityManager.persist(material);
        entityManager.persist(movimentacaoEstoque);
        entityManager.persist(estoque);
    }
}
