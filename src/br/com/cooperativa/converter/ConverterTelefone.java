package br.com.cooperativa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterTelefone")
public class ConverterTelefone implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String telefone) {
        if (telefone.trim().equals("")) {
            return null;
        } else {
            telefone = telefone.replace("(", "");
            telefone = telefone.replace(")", "");
            telefone = telefone.replace("-", "");
            return telefone;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {

        String telefone = (String) object;
        if (!"".equals(telefone)) {
            String ddd = "(" + telefone.substring(0, 2) + ") ";
            String resposta = "";

            if (telefone.length() == 10) {

                String primeiraParte = telefone.substring(2, 6);
                String segundaParte = telefone.substring(6, 10);

                resposta = ddd + primeiraParte + "-" + segundaParte;

            } else if (telefone.length() == 11) {

                String trecho = telefone.substring(2, 3);
                String primeiraParte = telefone.substring(3, 7);
                String segundaParte = telefone.substring(7, 11);

                resposta = ddd + trecho + "-" + primeiraParte + "-" + segundaParte;
            }

            return resposta;
        } else {
            return null;
        }
    }
}