package br.com.cooperativa.util;

import java.io.OutputStream;
import java.math.BigDecimal;

public class Conta {

	/*
	 * Cabeçalho
	 */
	private Integer id;
	private String ano;
	private String mes;
	private String cliente;
	private String apartamento;
	private String condominio;
	private String torre;
	private Integer qtdApartamentos;
	
	/*
	 * Dados coletados
	 */
	private BigDecimal volumeTotal = BigDecimal.ZERO;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private BigDecimal coeficiente = BigDecimal.ZERO;
	private String dataLeituraAtual;
	private String dataLeituraAnterior;

	/*
	 * Dados do gerenciamento 
	 */
	private BigDecimal taxaLeitura = BigDecimal.ZERO;
	private String dataProximaLeitura;
	
	/*
	 * Consumo individual
	 */
	private BigDecimal leituraAnterior = BigDecimal.ZERO;
	private BigDecimal leituraAtual = BigDecimal.ZERO;
	private BigDecimal consumo = BigDecimal.ZERO;
	private BigDecimal valorConsumo = BigDecimal.ZERO;
	private BigDecimal valorConsumoComTaxa = BigDecimal.ZERO;
	
	/*
	 * Histórico do consumo individual
	 */
	private BigDecimal ant1 = BigDecimal.ZERO;
	private BigDecimal ant2 = BigDecimal.ZERO;
	private BigDecimal ant3 = BigDecimal.ZERO;
	private BigDecimal ant4 = BigDecimal.ZERO;
	
	/*
	 * Gráfico
	 */
	private OutputStream grafico;
	
	public BigDecimal getConsumo() {
		return consumo;
	}

	public void setConsumo(BigDecimal consumo) {
		this.consumo = consumo;
	}

	public BigDecimal getTaxaLeitura() {
		return taxaLeitura;
	}

	public void setTaxaLeitura(BigDecimal taxaLeitura) {
		this.taxaLeitura = taxaLeitura;
	}

	public String getDataLeituraAtual() {
		return dataLeituraAtual;
	}

	public void setDataLeituraAtual(String dataLeituraAtual) {
		this.dataLeituraAtual = dataLeituraAtual;
	}

	public String getDataLeituraAnterior() {
		return dataLeituraAnterior;
	}

	public void setDataLeituraAnterior(String dataLeituraAnterior) {
		this.dataLeituraAnterior = dataLeituraAnterior;
	}

	public String getDataProximaLeitura() {
		return dataProximaLeitura;
	}

	public void setDataProximaLeitura(String dataProximaLeitura) {
		this.dataProximaLeitura = dataProximaLeitura;
	}

	public BigDecimal getValorConsumoComTaxa() {
		return valorConsumoComTaxa;
	}

	public void setValorConsumoComTaxa(BigDecimal valorConsumoComTaxa) {
		this.valorConsumoComTaxa = valorConsumoComTaxa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMesReferenciaLeitura() {
		return mes;
	}

	public void setMesReferenciaLeitura(String mes) {
		this.mes = mes;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String string) {
		this.condominio = string;
	}

	public String getTorre() {
		return torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(BigDecimal coeficiente) {
		this.coeficiente = coeficiente;
	}

	public BigDecimal getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(BigDecimal leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public BigDecimal getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(BigDecimal leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public BigDecimal getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(BigDecimal valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public BigDecimal getAnt1() {
		return ant1;
	}

	public void setAnt1(BigDecimal ant1) {
		this.ant1 = ant1;
	}

	public BigDecimal getAnt2() {
		return ant2;
	}

	public void setAnt2(BigDecimal ant2) {
		this.ant2 = ant2;
	}

	public BigDecimal getAnt3() {
		return ant3;
	}

	public void setAnt3(BigDecimal ant3) {
		this.ant3 = ant3;
	}

	public BigDecimal getAnt4() {
		return ant4;
	}

	public void setAnt4(BigDecimal ant4) {
		this.ant4 = ant4;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getQtdApartamentos() {
		return qtdApartamentos;
	}

	public void setQtdApartamentos(Integer qtdApartamentos) {
		this.qtdApartamentos = qtdApartamentos;
	}

	public BigDecimal getVolumeTotal() {
		return volumeTotal;
	}

	public void setVolumeTotal(BigDecimal volumeTotal) {
		this.volumeTotal = volumeTotal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public OutputStream getGrafico() {
		return grafico;
	}

	public void setGrafico(OutputStream grafico) {
		this.grafico = grafico;
	}

}
