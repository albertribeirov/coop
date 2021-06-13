package br.com.cooperativa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipo_material")
public class TipoMaterial implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo")
    private Integer codigo;

    @OneToMany(mappedBy = "tipoMaterial", fetch = FetchType.EAGER)
    private List<Material> material;

    @Column(name = "nome")
    private String nome;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return nome;
    }

    public void setTipo(String nome) {
        this.nome = nome;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }
}
