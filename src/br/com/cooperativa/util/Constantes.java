package br.com.cooperativa.util;

public abstract class Constantes {



    private Constantes() {
		
	}
	
	public static final String SUCESSO = "success";
	public static final String MES = "mes";
	public static final String TXT_1 = "1";
	public static final String PDF_2 = "2";

	public static final String HOME_COOPERATIVA = "homeCooperativa";
	public static final String TIPO_MATERIAL_CADASTRAR = "cadastrarTipoMaterial";
	public static final String MATERIAL_CADASTRAR = "cadastrarMaterial";
	
	/*
	 * Mensagens Condomínio
	 */
	public static final String MSG_ERRO_EXISTE_CONDOMINIO_NOME = "Já existe um condomínio com este nome.";
	public static final String MSG_ERRO_EXISTE_CONDOMINIO_CNPJ = "Já existe um condomínio com este CNPJ.";

	/*
	 * Mensagens Cliente
	 */
	
	public static final String MSG_ERRO_EXISTE_CLIENTE_NOME = "Já existe um condomínio com este nome.";
	public static final String MSG_ERRO_EXISTE_COOPERADO_NOME = "Já existe um cooperado com este nome.";
	public static final String MSG_ERRO_EXISTE_COOPERADO_CPF = "Já existe um condomínio com este email.";
	
	/*
	 *  Constantes de Apartamento
	 */
	
	public static final String APARTAMENTO_CADASTRAR = "cadastrarApartamento";
	
	/*
	 *  Constantes de Cliente
	 */
	
	public static final String CLIENTE_CADASTRAR = "cadastrarCliente";
	public static final String CLIENTE_NOVO = "novoCliente";
	
	public static final String PRECO_GAS_CADASTRAR = "cadastrarPreco";
	/*
	 *  Constantes de Condomínio
	 */	
	public static final String COOPERADO_CADASTRAR = "cadastrarCooperado";
	public static final String CONDOMINIO_NOVO = "publico/CondominioCadastrar";
	public static final String CONDOMINIO_ALTERAR = "publico/CondominioAlterar";
	public static final String CONDOMINIO_SALVAR = "publico/CondominioSalvar";
	public static final String CONDOMINIO_INCLUIR = "publico/CondominioIncluir";
	public static final String CONDOMINIO_EXCLUIR = "publico/CondominioExcluir";
	public static final String CONDOMINIO_SUCESSO = "publico/CondominioSucesso";
	
	/*
	 *  Constantes de Empresa
	 */
	
	public static final String EMPRESA_NOVO = "EmpresaCadastrar";
	public static final String EMPRESA_ALTERAR = "EmpresaAlterar";
	public static final String EMPRESA_SALVAR = "EmpresaSalvar";
	public static final String EMPRESA_INCLUIR = "EmpresaIncluir";
	public static final String EMPRESA_EXCLUIR = "EmpresaExcluir";
	public static final String EMPRESA_SUCESSO = "EmpresaSucesso";
	
	/*
	 *  Constantes de Endereco
	 */
	
	public static final String ENDERECO_NOVO = "publico/EnderecoCadastrar";
	public static final String ENDERECO_ALTERAR = "publico/EnderecoAlterar";
	public static final String ENDERECO_SALVAR = "publico/EnderecoSalvar";
	public static final String ENDERECO_INCLUIR = "publico/EnderecoIncluir";
	public static final String ENDERECO_EXCLUIR = "publico/EnderecoExcluir";
	public static final String ENDERECO_SUCESSO = "publico/EnderecoSucesso";
	
	/*
	 *  Constantes de Funcionario
	 */
	
	public static final String FUNCIONARIO_NOVO = "FuncionarioCadastrar";
	public static final String FUNCIONARIO_ALTERAR = "FuncionarioAlterar";
	public static final String FUNCIONARIO_SALVAR = "FuncionarioSalvar";
	public static final String FUNCIONARIO_INCLUIR = "FuncionarioIncluir";
	public static final String FUNCIONARIO_EXCLUIR = "FuncionarioExcluir";
	public static final String FUNCIONARIO_SUCESSO = "FuncionarioSucesso";

	/*
	 *  Constantes de Sindico
	 */
	
	public static final String SINDICO_NOVO = "SindicoCadastrar";
	public static final String SINDICO_ALTERAR = "SindicoAlterar";
	public static final String SINDICO_SALVAR = "SindicoSalvar";
	public static final String SINDICO_INCLUIR = "SindicoIncluir";
	public static final String SINDICO_EXCLUIR = "SindicoExcluir";
	public static final String SINDICO_SUCESSO = "SindicoSucesso";

	public static final String TORRE_CADASTRAR = "cadastrarTorre";
	public static final String LISTAR_LEITURAS = "listarLeituras";
}