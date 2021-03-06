package br.com.cooperativa.bean;

import br.com.cooperativa.ejb.ControladorEstoqueMaterial;
import br.com.cooperativa.util.Constantes;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

@Named("loginBean")
@RequestScoped
public class LoginBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    @EJB
    private ControladorEstoqueMaterial controladorEstoqueMaterial;

    private String name;
    private String password;

    public String login() {
        if ("albert".equals(name) && "senha".equals(password)) {
            return redirect(Constantes.COOPERADO_CADASTRAR);

        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, ERRO, "Login inválido!");
            return null;
        }
    }

    public String cadastrar() {
        return Constantes.COOPERADO_CADASTRAR;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
