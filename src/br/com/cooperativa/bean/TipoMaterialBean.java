package br.com.cooperativa.bean;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.service.TipoMaterialService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            if (tipoMaterial.getId() == null) {
                tipoMaterialService.inserir(tipoMaterial);
            } else {
                tipoMaterialService.atualizar(tipoMaterial);
            }

            tipoMaterial = null;
            addMessage(FacesMessage.SEVERITY_INFO, SUCESSO, "Tipo de Material salvo!");
            return redirect(Constantes.TIPO_MATERIAL_CADASTRAR);

        } catch (Exception exception) {
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, exception.getMessage());
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, "Tipo de Material não salvo!");
            handleException(exception);
            return null;
        }
    }

    public List<TipoMaterial> listarCooperados(String query) {
        return tiposMaterial.stream().filter(
                tipoMaterial -> tipoMaterial.getNome().toUpperCase().startsWith(query.toUpperCase()))
                .collect(Collectors.toList());
    }

    public String alterar(Integer id) {
        try {
            tipoMaterial = tipoMaterialService.findById(id);
            addMessage(FacesMessage.SEVERITY_INFO, SUCESSO, "Tipo de Material alterado!");
            return redirect(Constantes.TIPO_MATERIAL_CADASTRAR);

        } catch (Exception exception) {
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, exception.getMessage());
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, "Tipo de Material não alterado!");
            handleException(exception);
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
            return redirect(Constantes.TIPO_MATERIAL_CADASTRAR);

        } catch (Exception e) {
            handleException(e);
        }

        this.tipoMaterial = null;
        return null;
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
