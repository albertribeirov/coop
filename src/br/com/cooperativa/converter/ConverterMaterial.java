package br.com.cooperativa.converter;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.service.MaterialService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ConverterMaterial implements Converter {

    @Inject
    MaterialService materialService;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) throws ConverterException {
        if (value == null || "".equals(value) || "Selecione...".equals(value)) {
            return null;
        } else {
            Integer id = Integer.parseInt(value);
            return materialService.consultarMaterialPorId(id);
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) throws ConverterException {
        if (object == null || "".equals(object)) {
            return null;
        } else {
            Material material = (Material) object;
            return material.getId().toString();
        }
    }
}

