package br.com.cooperativa.bean;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.service.HomeBeanService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeBean extends AbstractBean {

    @Inject
    private HomeBeanService homeBeanService;

    private Estoque estoque;
}
