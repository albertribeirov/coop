package br.com.cooperativa.bean;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.service.EstoqueService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@RequestScoped
public class EstoqueBean extends AbstractBean {

    @Inject
    private EstoqueService estoqueService;

    private Estoque estoque;

    private List<Estoque> listaEstoque;

    public String salvar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if (estoque.getId() == null) {
                estoqueService.inserir(estoque);
            } else {
                estoqueService.atualizar(estoque);
            }

            estoque = null;
            return redirect(Constantes.ESTOQUE_CADASTRAR);

        } catch (Exception e) {
            addMessageToRequest(e.getMessage());
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Estoque não salvo!"));
            return null;
        }
    }

    public String alterar(Integer id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            estoque = estoqueService.consultarEstoquePorId(id);
            fc.addMessage(MESSAGE, new FacesMessage(SUCESSO, "Estoque carregado!"));

        } catch (Exception e) {
            handleException(e);
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Estoque não carregado!"));
        }
        return null;
    }

    public String excluir(Integer id) {
        try {
            estoqueService.excluir(id);
        } catch (Exception e) {
            handleException(e);
        }

        this.estoque = null;
        return redirect(Constantes.CLIENTE_CADASTRAR);
    }

    public String cancelar() {
        estoque = null;
        listaEstoque = null;
        listaEstoque = estoqueService.listarEstoque();
        return redirect(Constantes.ESTOQUE_CADASTRAR);
    }

    public Estoque getEstoque() {
        if (estoque == null) {
            estoque = new Estoque();
        }
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Estoque> getListaEstoque() {
        if (Objects.isNull(listaEstoque)) {
            listaEstoque = new ArrayList<>();
        }
        return listaEstoque;
    }

    public void setListaEstoque(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }
}
