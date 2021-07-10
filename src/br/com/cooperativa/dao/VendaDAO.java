package br.com.cooperativa.dao;

import br.com.cooperativa.model.Venda;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class VendaDAO extends DAO {

    public static final String SELECT_FROM_VENDA = "SELECT v FROM Venda v";
    public static final String TIPO_MOVIMENTACAO_ESTOQUE = "tipoVenda";
    public static final String DATA_VENDA = "dataVenda";
    public static final String ID_CLIENTE = "idCliente";
    public static final String NOTA_FISCAL = "notaFiscal";
    public static final String TOTAL_VENDA = "totalVenda";

    public List<Venda> listarVendas() {
        return criarQuery(SELECT_FROM_VENDA).getResultList();
    }

    public List<Venda> consultarVendas(Venda venda) {
        String sqlConnector = "";
        StringBuilder consulta = new StringBuilder(SELECT_FROM_VENDA);
        boolean hasWhere = false;

        if (Objects.nonNull(venda.getId())
                || Objects.nonNull(venda.getCliente())
                || Objects.nonNull(venda.getTipoMovimentacaoEstoque())
                || Objects.nonNull(venda.getTotalVenda())
                || Objects.nonNull(venda.getDataVenda())) {
            hasWhere = true;
        }

        if (hasWhere) {
            consulta.append(WHERE);
            concatenarClausulaWhere(venda.getNotaFiscal(), sqlConnector, consulta, " v.notaFiscal = :notaFiscal ");
            concatenarClausulaWhere(venda.getCliente(), sqlConnector, consulta, " v.cliente.id = :idCliente ");
            concatenarClausulaWhere(venda.getTipoMovimentacaoEstoque(), sqlConnector, consulta, " v.tipoMovimentacaoEstoque. = :tipoMovimentacaoEstoque ");
            concatenarClausulaWhere(venda.getTotalVenda(), sqlConnector, consulta, " v.totalVenda = :totalVenda ");
            concatenarClausulaWhere(venda.getDataVenda(), sqlConnector, consulta, " v.dataVenda = :dataVenda ");
        }

        consulta.append(" ORDER BY me.dataVenda DESC ");

        Query query = criarQuery(consulta.toString());

        if (hasWhere) {
            trocarParametroPorValor(venda.getNotaFiscal(), NOTA_FISCAL, query);
            trocarParametroPorValor(venda.getCliente(), ID_CLIENTE, query);
            trocarParametroPorValor(venda.getTipoMovimentacaoEstoque(), TIPO_MOVIMENTACAO_ESTOQUE, query);
            trocarParametroPorValor(venda.getTotalVenda(), TOTAL_VENDA, query);
            trocarParametroPorValor(venda.getDataVenda(), DATA_VENDA, query);
        }

        return query.getResultList();
    }
}
