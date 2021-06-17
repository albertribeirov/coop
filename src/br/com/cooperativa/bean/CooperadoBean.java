package br.com.cooperativa.bean;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.model.Telefone;
import br.com.cooperativa.service.CooperadoService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named("cooperadoBean")
@RequestScoped
public class CooperadoBean extends AbstractBean {

    @Inject
    private CooperadoService cooperadoService;

    private Cooperado cooperado;

    private Endereco endereco;

    private List<Telefone> telefones;

    private Telefone telefone;

    private List<Cooperado> cooperados;

    /*
     * Listar cooperados
     */
    public List<Cooperado> getCooperados() {
        if (cooperados == null) {
            cooperados = cooperadoService.listarCooperados();
        }
        return cooperados;
    }

    public List<Cooperado> listarCooperados(String query) {
        return cooperados.stream().filter(c -> c.getNomeCompleto().toUpperCase().startsWith(query.toUpperCase())).collect(Collectors.toList());
    }

    /*
     * Altera um cooperado
     */
    public String alterar(Integer id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            cooperado = cooperadoService.findById(id);
            fc.addMessage(MESSAGE, new FacesMessage(SUCESSO, "Cooperado carregado!"));

        } catch (Exception e) {
            handleException(e);
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Cooperado não carregado!"));
        }
        return null;
    }

    /*
     * Cancela a alteração
     */
    public String cancelar() {
        cooperado = null;
        cooperados = cooperadoService.listarCooperados();
        return null;
    }

    /*
     * Exclui um cooperado
     */
    public String excluir(Integer id) {
        try {
            cooperadoService.excluir(id);
        } catch (Exception e) {
            handleException(e);
        }

        this.cooperado = null;
        return redirect(Constantes.COOPERADO_CADASTRAR);
    }

    /*
     * Salva um cooperado
     */
    public String salvar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if (cooperado.getId() == null) {
                cooperadoService.inserir(cooperado);
            } else {
                cooperadoService.atualizar(cooperado);
            }

            cooperado = null;
            return redirect(Constantes.COOPERADO_CADASTRAR);

        } catch (Exception e) {
            addMessageToRequest(e.getMessage());
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Cooperado não salvo!"));
            return null;
        }
    }

    /*
     * Cadastrar um novo cooperado
     */
    public String novoCooperado() {
        return Constantes.CLIENTE_NOVO;
    }

    /*
     * Obter cooperado
     */
    public Cooperado getCooperado() {
        if (cooperado == null) {
            cooperado = new Cooperado();
        }
        return cooperado;
    }

    public void setCooperado(Cooperado cooperado) {
        this.cooperado = cooperado;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Telefone getTelefone() {
        if (telefone == null) {
            telefone = new Telefone();
        }
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        if (endereco == null) {
            endereco = new Endereco();
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}