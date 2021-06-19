package br.com.cooperativa.rn;

import br.com.cooperativa.TipoMovimentacaoEstoque;
import br.com.cooperativa.dao.EstoqueDAO;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.MovimentacaoEstoque;

import javax.persistence.EntityManager;
import java.util.List;

public class RNInserirQuantidadeMaterialEmEstoque {

    private static RNInserirQuantidadeMaterialEmEstoque regraDeNegocio = new RNInserirQuantidadeMaterialEmEstoque();

    public static RNInserirQuantidadeMaterialEmEstoque getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNInserirQuantidadeMaterialEmEstoque();
        }
        return regraDeNegocio;
    }

    public void inserir(Estoque estoque, EntityManager entityManager) throws Exception {
        Estoque estoqueFromDb;

        List<Estoque> estoques = entityManager
                .createQuery(EstoqueDAO.consultaEstoquePorIdMaterialAndIdTipoMaterial)
                .setParameter("idMaterial", estoque.getMaterial().getId())
                .setParameter("idTipoMaterial", estoque.getTipoMaterial().getId())
                .getResultList();

        if (estoques.isEmpty()) {
            entityManager.persist(estoque);
        } else {
            estoqueFromDb = estoques.get(0);
            estoqueFromDb.setQuantidadeEmKg(estoqueFromDb.getQuantidadeEmKg() + estoque.getQuantidadeEmKg());
            entityManager.merge(estoqueFromDb);
        }

        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque(
                estoque.getQuantidadeEmKg(),
                TipoMovimentacaoEstoque.ENTRADA,
                estoque.getTipoMaterial(),
                estoque.getMaterial()
        );

        entityManager.persist(movimentacaoEstoque);
    }
}
