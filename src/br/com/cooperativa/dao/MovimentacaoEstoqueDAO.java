package br.com.cooperativa.dao;

import br.com.cooperativa.model.MovimentacaoEstoque;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class MovimentacaoEstoqueDAO extends DAO {

    public static final String SELECT_FROM_MOVIMENTACAO = "SELECT me FROM MovimentacaoEstoque me";
    public static final String TIPO_MOVIMENTACAO_ESTOQUE = "tipoMovimentacaoEstoque";
    public static final String DATA_MOVIMENTACAO = "dataMovimentacao";
    public static final String ID_MATERIAL = "idMaterial";
    public static final String ID_TIPO_MATERIAL = "idTipoMaterial";

    public List<MovimentacaoEstoque> listarMovimentacoesEstoque() {
        return criarQuery(SELECT_FROM_MOVIMENTACAO).getResultList();
    }

    public List<MovimentacaoEstoque> consultarMovimentacaoEstoquePorTipoMovimentacao(int tipoMovimentacaoEstoque) {
        return criarQuery(SELECT_FROM_MOVIMENTACAO + WHERE + " me.tipoMovimentacaoEstoque = :tipoMovimentacaoEstoque")
                .setParameter(TIPO_MOVIMENTACAO_ESTOQUE, tipoMovimentacaoEstoque)
                .getResultList();
    }

    public List<MovimentacaoEstoque> consultarMovimentacaoEstoquePorData(LocalDate dataMovimentacao) {
        return criarQuery(SELECT_FROM_MOVIMENTACAO + WHERE + " me.dataMovimentacao = :dataMovimentacao")
                .setParameter(DATA_MOVIMENTACAO, dataMovimentacao)
                .getResultList();
    }

    public List<MovimentacaoEstoque> consultarMovimentacoesPorMaterialAndTipoMaterialAndTipoMovimentacao(MovimentacaoEstoque movimentacaoEstoque) {
        String sqlConnector = "";
        StringBuilder consulta = new StringBuilder(SELECT_FROM_MOVIMENTACAO);

        if (Objects.nonNull(movimentacaoEstoque.getMaterial())
                || Objects.nonNull(movimentacaoEstoque.getTipoMaterial())
                || Objects.nonNull(movimentacaoEstoque.getTipoMovimentacaoEstoque())
                || Objects.nonNull(movimentacaoEstoque.getDataMovimentacao())) {
            consulta.append(WHERE);
        }

        if (Objects.nonNull(movimentacaoEstoque.getMaterial())) {
            consulta.append(sqlConnector).append(" me.material.id = :idMaterial ");
            sqlConnector = AND;
        }

        if (Objects.nonNull(movimentacaoEstoque.getTipoMaterial())) {
            consulta.append(sqlConnector).append(" me.tipoMaterial.id = :idTipoMaterial ");
            sqlConnector = AND;
        }

        if (Objects.nonNull(movimentacaoEstoque.getTipoMovimentacaoEstoque())) {
            consulta.append(sqlConnector).append(" me.tipoMovimentacaoEstoque = :tipoMovimentacaoEstoque ");
            sqlConnector = AND;
        }

        if (Objects.nonNull(movimentacaoEstoque.getDataMovimentacao())) {
            consulta.append(sqlConnector).append(" me.dataMovimentacao = :dataMovimentacao ");
        }

        consulta.append(" ORDER BY me.dataMovimentacao DESC ");

        Query query = criarQuery(consulta.toString());

        if (Objects.nonNull(movimentacaoEstoque.getMaterial())) {
            query.setParameter(ID_MATERIAL, movimentacaoEstoque.getMaterial().getId());
        }

        if (Objects.nonNull(movimentacaoEstoque.getTipoMaterial())) {
            query.setParameter(ID_TIPO_MATERIAL, movimentacaoEstoque.getTipoMaterial().getId());
        }

        if (Objects.nonNull(movimentacaoEstoque.getTipoMovimentacaoEstoque())) {
            query.setParameter(TIPO_MOVIMENTACAO_ESTOQUE, movimentacaoEstoque.getTipoMovimentacaoEstoque().getValor());
        }

        if (Objects.nonNull(movimentacaoEstoque.getDataMovimentacao())) {
            query.setParameter(DATA_MOVIMENTACAO, movimentacaoEstoque.getDataMovimentacao());
        }

        return query.getResultList();
    }
}
