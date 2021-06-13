/**
 * Retorna a data de hoje no formato dd/MM/yyyy.
 */
function dataFormatada() {
	const data = new Date();
	let dia = data.getDate();
	if (dia.toString().length == 1) {
		dia = "0" + dia;
	}
	let mes = data.getMonth() + 1;
	if (mes.toString().length == 1) {
		mes = "0" + mes;
	}
	const ano = data.getFullYear();

	return dia + "/" + mes + "/" + ano;
}

// Chama função que preenche o campo data
$('#Data').val(dataFormatada);

/**
 * Verifica se as senhas digitadas são iguais.
 */
// Verifica senha
function verificarSenha() {
	let senha1 = document.getElementById("");
	let senha2 = document.getElementById("");

	if (senha1 == senha2) {
		return true;
	}

	alert("Senhas diferentes!");
	senha1 = '';
	senha2 = '';
	return false;
}

function listarApartamentos() {

}

/**
 * Transforma o campo de leitura em readonly após seu preenchimento.
 */
function desabilitarCampoLeitura(pCampo) {
	let campo = $(pCampo);
	let valor = campo.val();
	if (valor != '' && valor != null) {
		campo.prop('readonly', true);
	} else {
		campo.prop('readonly', false);
	}
}


/**
 * Transforma o campo de leitura em writable com o evento doubleclick (duplo clique).
 */
function habilitarCampoLeitura(pCampo) {
	let campo = $(pCampo);
	let valor = campo.prop('readonly', false);
}

/**
 * Solicita confirmação de exclusão
 */
function excluir() {
	return confirm("Deseja excluir o registro?")
}

/**
 * Formata CPF e CNPF dependendo da quantidade de caracteres.
 */
function formatarCampo(campoTexto) {
	if (campoTexto.value.length <= 11) {
		campoTexto.value = mascaraCpf(campoTexto.value);
	} else {
		campoTexto.value = mascaraCnpj(campoTexto.value);
	}
}

// <input type="text" onfocus="javascript: retirarFormatacao(this);"
// onblur="javascript: formatarCampo(this);" maxlength="14"/>

function retirarFormatacao(campoTexto) {
	campoTexto.value = campoTexto.value.replace(/(\.|\/|\-)/g, "");
}

function mascaraCpf(valor) {
	return valor.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, "\$1.\$2.\$3\-\$4");
}

function mascaraCnpj(valor) {
	return valor.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/g,
			"\$1.\$2.\$3\/\$4\-\$5");
}

/**
 * Verifica se o valor da leitura atual é menor que a leitura anterior. </br>
 * Limpa o campo de leitura atual caso esta seja menor que a leitura anterior.
 */
function compararLeituras(pInput) {
	const leitura = Number(pInput.nextElementSibling.value);
	let leituraAnterior = pInput.parentElement.parentElement.previousSibling.firstElementChild.innerText;
	leituraAnterior = Number(leituraAnterior.replace(/\./g,''));

	if (leitura != 0 && leitura < leituraAnterior) {
		pInput.value = "";
		pInput.focus();
		alert("A leitura atual não pode ser menor que a leitura anterior.");
	}
	return;
}