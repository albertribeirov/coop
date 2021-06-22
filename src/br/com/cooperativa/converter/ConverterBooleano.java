package br.com.cooperativa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterBooleano")
public class ConverterBooleano implements Converter {

	/**
	 * <b>Mãtodo que converte "True" para "Sim" e "False" para "Não".</b>
	 */
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String booleano) {
		return booleano;
	}

	/**
	 * <b>Mãtodo que retorna o booleano como Sim ou Não.</b>
	 */
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {
		Boolean valor = (Boolean) object;
		String status;

		if (valor == Boolean.TRUE) {
			status = "Sim";
		} else {
			status = "Não";
		}
		return status;
	}
}