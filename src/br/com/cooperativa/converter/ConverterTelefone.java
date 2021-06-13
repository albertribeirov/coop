package br.com.cooperativa.converter;

import br.com.cooperativa.model.Telefone;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Objects;

@FacesConverter("converterTelefone")
public class ConverterTelefone implements Converter {

    /**
     * <b>Método que remove a máscara do telefone.</b>
     *
     * @param facesContext
     * @param uIcomponent
     * @param telefone
     * @return Object
     */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String telefone) {
        if (telefone.trim().equals("")) {
            return null;
        } else {
            telefone = telefone.replace("(", "");
            telefone = telefone.replace(")", "");
            telefone = telefone.replace("-", "");
            return new Telefone(telefone);
        }
    }

    /**
     * <b>Método que retorna a String do telefone.</b>
     *
     * @param facesContext
     * @param uIcomponent
     * @param object
     * @return String
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {

        Telefone telefone = (Telefone) object;
        if (Objects.nonNull(telefone) && Objects.nonNull(telefone.getNumero())) {
            String numero = telefone.getNumero();
            String ddd = "(" + numero.substring(0, 2) + ") ";
            String resposta = "";

            if (numero.length() == 10) {

                String primeiraParte = numero.substring(2, 6);
                String segundaParte = numero.substring(6, 10);

                resposta = ddd + primeiraParte + "-" + segundaParte;

            } else if (numero.length() == 11) {

                String trecho = numero.substring(2, 3);
                String primeiraParte = numero.substring(3, 7);
                String segundaParte = numero.substring(7, 11);

                resposta = ddd + trecho + "-" + primeiraParte + "-" + segundaParte;
            }

            return resposta;
        } else {
            return null;
        }
    }
}