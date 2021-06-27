package br.com.cooperativa.bean;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.service.MaterialService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class MaterialBean extends AbstractBean {

    @Inject
    private MaterialService materialService;

    private Material material;

    private TipoMaterial tipoMaterial;

    private List<Material> materiais;

    public String salvar() {
        try {
            if (material.getId() == null) {
                materialService.inserir(material);
            } else {
                materialService.atualizar(material);
            }

            material = null;
            addMessage(FacesMessage.SEVERITY_INFO, SUCESSO, "Material salvo!");
            return redirect(Constantes.MATERIAL_CADASTRAR);

        } catch (Exception exception) {
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, exception.getMessage());
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, "Material não salvo!");
            handleException(exception);
            return null;
        }
    }

    public String alterar(Integer id) {
        try {
            material = materialService.consultarMaterialPorId(id);
            addMessage(FacesMessage.SEVERITY_INFO, SUCESSO, "Material carregado!");

        } catch (Exception exception) {
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, exception.getMessage());
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, "Material não carregado!");
            handleException(exception);
        }
        return null;
    }

    public String cancelar() {
        material = null;
        tipoMaterial = null;
        materiais = materialService.listarMateriais();
        return redirect(Constantes.MATERIAL_CADASTRAR);
    }

    public String excluir(Integer id) {
        try {
            materialService.excluir(id);
        } catch (Exception exception) {
            handleException(exception);
        }

        this.material = null;
        materiais = materialService.listarMateriais();
        return redirect(Constantes.MATERIAL_CADASTRAR);
    }

    public Material getMaterial() {
        if (material == null) {
            material = new Material();
        }

        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getMateriais() {
        if (materiais == null) {
            materiais = materialService.listarMateriais();
        }
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
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

    public List<Material> listarMateriaisPorTipoMaterial(Integer idTipoMaterial) {
        return materialService.consultarMaterialPorIdTipoMaterial(idTipoMaterial);
    }

    public void listarMateriaisPorTipoMaterialEvent(ValueChangeEvent event) {
        TipoMaterial tipoMaterial = (TipoMaterial) event.getNewValue();
        materiais = materialService.consultarMaterialPorIdTipoMaterial(tipoMaterial.getId());
    }
}
