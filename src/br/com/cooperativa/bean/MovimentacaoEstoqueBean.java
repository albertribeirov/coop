package br.com.cooperativa.bean;

import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.service.LogService;
import br.com.cooperativa.service.MovimentacaoEstoqueService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Named
@RequestScoped
public class MovimentacaoEstoqueBean extends AbstractBean {

    @Inject
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Inject
    private LogService logService;

    private LocalDate dataEntradaMaterial;
    private MovimentacaoEstoque movimentacaoEstoque;
    private List<MovimentacaoEstoque> movimentacoesEstoque;

    public List<MovimentacaoEstoque> consultarMovimentacoesComFiltro() {
        try {
            movimentacoesEstoque = movimentacaoEstoqueService.consultarMovimentacoesPorMaterialAndTipoMaterialAndTipoMovimentacao(movimentacaoEstoque);
            addMessage(FacesMessage.SEVERITY_INFO, SUCESSO, "Movimentacões do estoque carregadas!");
            return movimentacoesEstoque;
        } catch (Exception exception) {
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, "Erro ao consultar as movimentacões do estoque.");
            handleException(exception);
            return Collections.emptyList();
        }
    }

    public String salvar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if (movimentacaoEstoque.getId() == null) {
                movimentacaoEstoqueService.inserir(movimentacaoEstoque);
            } else {
                movimentacaoEstoqueService.atualizar(movimentacaoEstoque);
            }

            movimentacaoEstoque = null;
            return redirect(Constantes.MOVIMENTACAO_ESTOQUE);

        } catch (Exception exception) {
            addMessageToRequest(exception.getMessage());
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "movimentacaoEstoque não salvo!"));
            handleException(exception);
            return null;
        }
    }

    public String alterar(Integer id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            movimentacaoEstoque = movimentacaoEstoqueService.findById(id);
            fc.addMessage(MESSAGE, new FacesMessage(SUCESSO, "Estoque carregado!"));

        } catch (Exception exception) {
            handleException(exception);
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Estoque não carregado!"));
        }
        return null;
    }

    public String excluir(Integer id) {
        try {
            movimentacaoEstoqueService.excluir(id);
        } catch (Exception exception) {
            handleException(exception);
        }

        this.movimentacoesEstoque = null;
        return redirect(Constantes.MOVIMENTACAO_ESTOQUE);
    }

    public String cancelar() {
        movimentacaoEstoque = null;
        movimentacoesEstoque = movimentacaoEstoqueService.listarMovimentacaoEstoques();
        return redirect(Constantes.MOVIMENTACAO_ESTOQUE);
    }

    public List<MovimentacaoEstoque> consultarMovimentacoesPorMaterialAndTipoMaterialAndTipoMovimentacao() {
        movimentacoesEstoque = movimentacaoEstoqueService.consultarMovimentacoesPorMaterialAndTipoMaterialAndTipoMovimentacao(movimentacaoEstoque);
        return movimentacoesEstoque;
    }

    public LocalDate getDataEntradaMaterial() {
        return dataEntradaMaterial;
    }

    public void setDataEntradaMaterial(LocalDate dataEntradaMaterial) {
        this.dataEntradaMaterial = dataEntradaMaterial;
    }

    public MovimentacaoEstoque getMovimentacaoEstoque() {
        if (Objects.isNull(movimentacaoEstoque)) {
            movimentacaoEstoque = new MovimentacaoEstoque();
        }
        return movimentacaoEstoque;
    }

    public void setMovimentacaoEstoque(MovimentacaoEstoque movimentacaoEstoque) {
        this.movimentacaoEstoque = movimentacaoEstoque;
    }

    public List<MovimentacaoEstoque> getMovimentacoesEstoque() {
        if (Objects.isNull(movimentacoesEstoque)) {
            movimentacoesEstoque = movimentacaoEstoqueService.listarMovimentacaoEstoques();
        }
        return movimentacoesEstoque;
    }

    public void setMovimentacoesEstoque(List<MovimentacaoEstoque> movimentacoesEstoque) {
        this.movimentacoesEstoque = movimentacoesEstoque;
    }
}