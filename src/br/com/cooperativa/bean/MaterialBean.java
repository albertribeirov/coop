package br.com.cooperativa.bean;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.service.MaterialService;
import br.com.cooperativa.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    /**
     * Salva um Material
     */
    public String salvar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if (material.getId() == null) {
                materialService.inserir(material);
            } else {
                materialService.atualizar(material);
            }

            material = null;
            return redirect(Constantes.MATERIAL_CADASTRAR);

        } catch (Exception e) {
            addMessageToRequest(e.getMessage());
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Material não salvo!"));
            return null;
        }
    }

//    public List<Material> listarCooperados(String query) {
//        return cooperados.stream().filter(c -> c.getNomeCompleto().toUpperCase().startsWith(query.toUpperCase())).collect(Collectors.toList());
//    }

    /**
     * Altera um Material
     */
    public String alterar(Integer id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            material = materialService.consultarMaterialPorId(id);
            fc.addMessage(MESSAGE, new FacesMessage(SUCESSO, "Material carregado!"));

        } catch (Exception e) {
            handleException(e);
            fc.addMessage(MESSAGE, new FacesMessage(ERRO, "Material não carregado!"));
        }
        return null;
    }

    /*
     * Cancela a alteração
     */
    public String cancelar() {
        material = null;
        materiais = materialService.listarMateriais();
        return null;
    }

    /*
     * Exclui um cooperado
     */
    public String excluir(Integer id) {
        try {
            materialService.excluir(id);
        } catch (Exception e) {
            handleException(e);
        }

        this.material = null;
        return redirect(Constantes.CLIENTE_CADASTRAR);
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
}
