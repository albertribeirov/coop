package br.com.cooperativa.model;

import br.com.cooperativa.TipoMovimentacaoEstoque;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer quantidade;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_movimentacao", nullable = false)
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_material")
    private TipoMaterial tipoMaterial;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_material")
    private Material material;

    @Column(name = "data_movimentacao", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate dataMovimentacao;

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public MovimentacaoEstoque() {

    }

    public MovimentacaoEstoque(Integer quantidade, TipoMovimentacaoEstoque tipoMovimentacaoEstoque, TipoMaterial tipoMaterial, Material material) {
        this.quantidade = quantidade;
        this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
        this.tipoMaterial = tipoMaterial;
        this.material = material;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public TipoMovimentacaoEstoque getTipoMovimentacaoEstoque() {
        return tipoMovimentacaoEstoque;
    }

    public void setTipoMovimentacaoEstoque(TipoMovimentacaoEstoque tipoMovimentacaoEstoque) {
        this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "MovimentacaoEstoque{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", tipoMovimentacaoEstoque=" + tipoMovimentacaoEstoque +
                ", tipoMaterial=" + tipoMaterial.getNome() +
                ", material=" + material.getNome() +
                ", dataMovimentacao=" + dataMovimentacao +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
