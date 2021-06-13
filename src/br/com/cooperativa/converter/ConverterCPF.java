package br.com.cooperativa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterCPF")
public class ConverterCPF implements Converter {

	/**
	 * <b>Método que remove a máscara do CPF.</b>
	 *
	 * @param facesContext
	 * @param uIcomponent
	 * @param cpf
	 * @return Object
	 */
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String cpf) {
		if (cpf.trim().equals("")) {
			return null;
		} else {
			cpf = cpf.replace("-", "");
			cpf = cpf.replace(".", "");
			return cpf;
		}
	}

	/**
	 * <b>Método que retorna a String do CPF.</b>
	 *
	 * @param facesContext
	 * @param uIcomponent
	 * @param object
	 * @return String
	 */
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {
		String cpf = (String) object;

		cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);

		return cpf;
	}
}