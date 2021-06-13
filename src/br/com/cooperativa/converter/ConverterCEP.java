package br.com.cooperativa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterCEP")
public class ConverterCEP implements Converter {

	 /**
     * <b>Método que remove a máscara do CEP.</b>
     *
     * @param facesContext
     * @param uIcomponent
     * @param cep
     * @return Object
     */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String cep) {
        if (cep.trim().equals("")) {
            return null;
        } else {
            cep = cep.replace(".", "");
            cep = cep.replace("-", "");
            return cep;
        }
    }

    /**
     * <b>Método que retorna a String do CEP.</b>
     *
     * @param facesContext
     * @param uIcomponent
     * @param object
     * @return String
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {
        return object.toString();
    }
}