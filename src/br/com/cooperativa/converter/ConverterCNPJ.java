package br.com.cooperativa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterCNPJ")
public class ConverterCNPJ implements Converter {

	/**
	 * <b>Método que remove a máscara do CNPJ.</b>
	 *
	 * @param facesContext
	 * @param uIcomponent
	 * @param cnpj
	 * @return Object
	 */
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String cnpj) {
		if (cnpj.trim().equals("")) {
			return null;
		} else {
			cnpj = cnpj.replace("-", "");
			cnpj = cnpj.replace(".", "");
			cnpj = cnpj.replace("/", "");
			return cnpj;
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
		String cnpj = (String) object;

		cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
				+ cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);

		return cnpj;
	}
}