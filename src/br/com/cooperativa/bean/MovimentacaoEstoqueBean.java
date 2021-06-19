package br.com.cooperativa.bean;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.service.MovimentacaoEstoqueService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;

@Named
@RequestScoped
public class MovimentacaoEstoqueBean extends AbstractBean {

    @Inject
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    private Material material;
    private Integer quantidadeEmKg;
    private LocalDate dataEntradaMaterial;




}
