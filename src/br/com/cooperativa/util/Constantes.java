package br.com.cooperativa.util;

public abstract class Constantes {
    private Constantes() {

    }

    public static final String JSF = ".jsf";
    public static final String SUCESSO = "success";

    public static final String HOME_COOPERATIVA = "homeCooperativa";
    public static final String HOME_COOPERATIVA_JSF = "homeCooperativa" + JSF;

    public static final String TIPO_MATERIAL_CADASTRAR = "cadastrarTipoMaterial";
    public static final String TIPO_MATERIAL_CADASTRAR_JSF = "cadastrarTipoMaterial" + JSF;

    public static final String MATERIAL_CADASTRAR = "cadastrarMaterial";
    public static final String MATERIAL_CADASTRAR_JSF = "cadastrarMaterial" + JSF;

    public static final String MOVIMENTACAO_ESTOQUE = "movimentacaoEstoque";
    public static final String MOVIMENTACAO_ESTOQUE_JSF = "movimentacaoEstoque" + JSF;

    public static final String COOPERADO_CADASTRAR = "cadastrarCooperado";
    public static final String COOPERADO_CADASTRAR_JSF = "cadastrarCooperado" + JSF;

    public static final String ESTOQUE_CADASTRAR = "cadastrarEstoque";
    public static final String ESTOQUE_CADASTRAR_JSF = "cadastrarEstoque" + JSF;

    public static final String CLIENTE_CADASTRAR = "cadastrarCliente";
    public static final String CLIENTE_CADASTRAR_JSF = CLIENTE_CADASTRAR + JSF;

    public static final String MORADOR_CADASTRAR = "moradorCadastrar";
    public static final String MORADOR_CADASTRAR_JSF = MORADOR_CADASTRAR + JSF;

    public static final String ENTRADA_ESTOQUE_CADASTRAR = "entradaEstoque";
    public static final String ENTRADA_ESTOQUE_CADASTRAR_JSF = ENTRADA_ESTOQUE_CADASTRAR + JSF;

    public static final String MOVIMENTACAO_ESTOQUE_CADASTRAR = "movimentacaoEstoque";
    public static final String MOVIMENTACAO_ESTOQUE_CADASTRAR_JSF = ENTRADA_ESTOQUE_CADASTRAR + JSF;


    /*
     * Mensagens de erro do TipoMaterial
     */

    public static final String MSG_ERRO_EXISTE_TIPO_MATERIAL_MESMO_NOME = "Já existe um tipo de material com este nome.";
    public static final String MSG_ERRO_EXISTE_MATERIAL_MESMO_NOME = "Já existe um material com este nome.";

    /*
     * Mensagens de erro do Cooperado
     */

    public static final String MSG_ERRO_EXISTE_COOPERADO_NOME = "Já existe um cooperado com este nome.";
    public static final String MSG_ERRO_EXISTE_COOPERADO_CPF = "Já existe um cooperado com este CPF.";
}