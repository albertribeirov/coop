package br.com.cooperativa.bean;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.service.TipoMaterialService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class TipoMaterialBean extends AbstractBean {

    @Inject
    private TipoMaterialService tipoMaterialService;

    private TipoMaterial tipoMaterial;

    private List<TipoMaterial> tiposMaterial;

    public List<TipoMaterial> listarTiposMaterial() {
        if (tiposMaterial == null) {
            tiposMaterial = tipoMaterialService.listarTiposMaterial();
        }
        return tiposMaterial;
    }

    public String salvar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if (tipoMaterial.getId() == null) {
                tipoMaterialService.inserir(tipoMaterial);
            } else {
                tipoMaterialService.atualizar(tipoMaterial);
            }

            tipoMaterial = null;
            return redirect(Constantes.TIPO_MATERIAL_CADASTRAR);

        } catch (Exception exception) {
            addMessageToRequest(exception.getMessage());
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "TipoMaterial não salvo!"));
            return null;
        }
    }

//    public List<TipoMaterial> listarCooperados(String query) {
//        return cooperados.stream().filter(c -> c.getNomeCompleto().toUpperCase().startsWith(query.toUpperCase())).collect(Collectors.toList());
//    }

    public String alterar(Integer id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            tipoMaterial = tipoMaterialService.findById(id);
            fc.addMessage(MESSAGE, new FacesMessage(SUCESSO, "TipoMaterial carregado!"));

        } catch (Exception exception) {
            handleException(exception);
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "TipoMaterial não carregado!"));
        }
        return null;
    }

    public String cancelar() {
        tipoMaterial = null;
        tiposMaterial = tipoMaterialService.listarTiposMaterial();
        return null;
    }

    public String excluir(Integer id) {
        try {
            tipoMaterialService.excluir(id);
        } catch (Exception e) {
            handleException(e);
        }

        this.tipoMaterial = null;
        return redirect(Constantes.CLIENTE_CADASTRAR);
    }

    public TipoMaterial getTipoMaterial() {
        if (tipoMaterial == null) {
            tipoMaterial = new TipoMaterial();
        }
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public List<TipoMaterial> getTiposMaterial() {
        if (tiposMaterial == null) {
            tiposMaterial = tipoMaterialService.listarTiposMaterial();
        }
        return tiposMaterial;
    }

    public void setTiposMaterial(List<TipoMaterial> tiposMaterial) {
        this.tiposMaterial = tiposMaterial;
    }
}
