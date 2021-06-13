package br.com.cooperativa.dao;

import br.com.cooperativa.model.MovimentacaoEstoque;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unchecked")
public class MovimentacaoEstoqueDAO extends DAO {

    public List<MovimentacaoEstoque> listarMovimentacoesEstoque() {
        String consulta = "SELECT tme FROM TipoMovimentacaoEstoque tme";
        return criarQuery(consulta).getResultList();
    }

    public List<MovimentacaoEstoque> consultarMovimentacaoEstoquePorTipoMovimentacao(int tipoMovimentacaoEstoque) {
        String consulta = "SELECT tme FROM TipoMovimentacaoEstoque tme WHERE tme.tipoMovimentacaoEstoque = :tme";
        return criarQuery(consulta).setParameter("tme", tipoMovimentacaoEstoque).getResultList();
    }

    public List<MovimentacaoEstoque> consultarMovimentacaoEstoquePorData(LocalDate dataMovimentacao) {
        String consulta = "SELECT tme FROM TipoMovimentacaoEstoque tme WHERE tme.dataMovimentacao = :dataMovimentacao";
        return criarQuery(consulta).setParameter("dataMovimentacao", dataMovimentacao).getResultList();
    }
}
