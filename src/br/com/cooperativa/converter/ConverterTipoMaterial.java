package br.com.cooperativa.converter;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.service.TipoMaterialService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ConverterTipoMaterial implements Converter {

    @Inject
    TipoMaterialService tipoMaterialService;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) throws ConverterException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (value == null || value.equals("") || "Selecione...".equals(value)) {
            facesContext.addMessage("message", new FacesMessage("Erro", "Material não carregado!"));
            return null;
        } else {
            Integer id = Integer.parseInt(value);
            return tipoMaterialService.consultarTipoMaterialPorId(id);
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) throws ConverterException {
        if (object == null || "".equals(object)) {
            return null;
        } else {
            TipoMaterial tipoMaterial = (TipoMaterial) object;
            return tipoMaterial.getId().toString();
        }
    }
}

