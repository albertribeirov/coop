package br.com.cooperativa.ejb;


import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.rn.RNInserirMaterialAndEstoqueInicialZerado;
import br.com.cooperativa.rn.RNInserirQuantidadeMaterialEmEstoque;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ControladorEstoqueMaterialBean implements ControladorEstoqueMaterial {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void inserirMaterialAndEstoqueInicialZerado(Material material) throws Exception {
        RNInserirMaterialAndEstoqueInicialZerado.getInstance().inserir(material, entityManager);
    }

    public void persistir() {

        TipoMaterial plastico = new TipoMaterial("Plástico");
        TipoMaterial metal = new TipoMaterial("Metal");
        TipoMaterial vidro = new TipoMaterial( "Vidro");
        TipoMaterial papelPapelao = new TipoMaterial( "Papel/Papelão");
        TipoMaterial aluminio = new TipoMaterial( "Alumínio");
        TipoMaterial garrafaPet = new TipoMaterial( "Garrafa PET");

        List<TipoMaterial> tipoMaterialList = List.of(plastico, metal, vidro, papelPapelao, aluminio, garrafaPet);

        tipoMaterialList.forEach(entityManager::persist);

        List<Material> plasticos = List.of(
                new Material("Plástico tipo A", plastico),
                new Material("Plástico fino (folha)", plastico),
                new Material("PEAD", plastico),
                new Material("Tampinhas PP", plastico),
                new Material("PP", plastico),
                new Material("PVC", plastico),
                new Material("PLAST. (catemba)", plastico),
                new Material("Grade", plastico),
                new Material("Mineral", plastico),
                new Material("PP cadeiras", plastico),
                new Material("Plástico duro (outros)", plastico)
        );

        plasticos.forEach(entityManager::persist);

        List<Material> metais = List.of(
                new Material("Alumínio", metal),
                new Material("Sucata de ferro", metal),
                new Material("Outros ferros", metal),
                new Material("Cobre com capa/sujo", metal),
                new Material("Cobre misto", metal),
                new Material("Cobre queimado", metal),
                new Material("Metal/Alumisto", metal),
                new Material("Bateria", metal),
                new Material("Motor de geladeira", metal),
                new Material("Reator", metal),
                new Material("Bloco", metal)
        );

        metais.forEach(entityManager::persist);

        List<Material> vidros = List.of(
                new Material("Caco branco", vidro),
                new Material("Caco escuro", vidro),
                new Material("Vidros diversos (contagem)", vidro),
                new Material("Vodka", vidro),
                new Material("L51", vidro),
                new Material("Cerveja", vidro)
        );

        vidros.forEach(entityManager::persist);

        List<Material> papeisPapelao = List.of(
                new Material("Papelão", papelPapelao),
                new Material("Papel branco", papelPapelao),
                new Material("Jornal", papelPapelao),
                new Material("Papel revista", papelPapelao),
                new Material("Papel misto", papelPapelao)
        );

        papeisPapelao.forEach(entityManager::persist);

        List<Material> aluminios = List.of(
                new Material("Alumínio latinha", aluminio),
                new Material("Alumínio duro", aluminio),
                new Material("Alumínio panela", aluminio),
                new Material("Alumínio perfil", aluminio),
                new Material("Alumínio tubinho", aluminio),
                new Material("Inox", aluminio),
                new Material("Persiana", aluminio),
                new Material("Alumínios variados", aluminio)
        );

        aluminios.forEach(entityManager::persist);

        List<Material> garrafasPET = List.of(
                new Material("PET branca", garrafaPet),
                new Material("PET incolor tipo C", garrafaPet),
                new Material("PET verde tipo A", garrafaPet),
                new Material("PET verde tipo B", garrafaPet),
                new Material("PET azul tipo B", garrafaPet)
        );

        garrafasPET.forEach(entityManager::persist);
    }

    @Override
    public void inserirQuantidadeMaterialEmEstoque(Estoque estoque) throws Exception {
        RNInserirQuantidadeMaterialEmEstoque.getInstance().inserir(estoque, entityManager);
    }
}
