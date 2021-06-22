package br.com.cooperativa.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class BibliotecaFuncoes {

	private BibliotecaFuncoes() {
		throw new IllegalStateException("Biblioteca de funcoes utilitarias");
	}

	public static List<String> lerArquivo(String nomeArquivo) {

		String linha;
		List<String> lista = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File(nomeArquivo))) {

			while (scanner.hasNextLine()) {
				linha = scanner.nextLine();
				lista.add(linha);

			}
		} catch (IOException exception) {
			exception.printStackTrace();

		}
		return lista;
	}

	public static List<String> split(String texto, String separador) {

		Integer indice = null;
		String linha = "";
		List<String> lista = new ArrayList<>();

		while (texto.contains(separador)) {
			indice = texto.indexOf(separador);
			linha = texto.substring(0, indice);
			indice += 1;
			texto = texto.substring(indice);
			lista.add(linha);
		}
		lista.add(texto);

		return lista;
	}

	public static String converteBigDecimal(String pValor) {
		return pValor.replace(".", ",");
	}

	public static BigDecimal escalarConsumo(String pValor) {
		BigDecimal valor = new BigDecimal(pValor);
		return valor.setScale(3, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal escalarConsumo(BigDecimal pValor) {
		return pValor.setScale(3, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal escalarDinheiro(String pValor) {
		BigDecimal valor = new BigDecimal(pValor);
		return valor.setScale(2, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal escalarDinheiro(BigDecimal pValor) {
		return pValor.setScale(2, RoundingMode.HALF_EVEN);
	}

	public static Integer getMesFromLocalDate(LocalDate date) {
		return date.getMonthValue();
	}

	public static Integer getAnoFromLocalDate(LocalDate date) {
		return date.getYear();
	}

	public static Integer getMesFromDate(Date date) {
		Integer mes;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		mes = cal.get(Calendar.MONTH) + 1;
		return mes;
	}

	public static Integer getAnoFromDate(Date date) {
		Integer ano;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		ano = cal.get(Calendar.YEAR);
		return ano;
	}

	public static String getDateComoString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		String resposta;
		Integer dia;
		Integer ano;
		Integer mes ;

		dia = cal.get(Calendar.DAY_OF_MONTH);
		mes = cal.get(Calendar.MONTH) + 1;
		ano = cal.get(Calendar.YEAR);

		String diaString = dia.toString();
		String mesString = mes.toString();
		String anoString = ano.toString();

		if (dia < 10) {
			diaString = "0" + dia;
		}
		if (mes < 10) {
			mesString = "0" + mes;
		}

		resposta = diaString + "/" + mesString + "/" + anoString;
		return resposta;
	}

	public static String getLocalDateComoString(LocalDate date) {
		String resposta;
		Integer dia;
		Integer ano;
		Integer mes;

		dia = date.getDayOfMonth();
		mes = date.getMonthValue();
		ano = date.getYear();

		String diaString = dia.toString();
		String mesString = mes.toString();
		String anoString = ano.toString();

		if (dia < 10) {
			diaString = "0" + dia;
		}
		if (mes < 10) {
			mesString = "0" + mes;
		}

		resposta = diaString + "/" + mesString + "/" + anoString;
		return resposta;
	}

	public static String getMesPorExtenso(Integer mes) {
		if (mes == 1) {
			return "Janeiro";
		} else if (mes == 2) {
			return "Fevereiro";
		} else if (mes == 3) {
			return "Março";
		} else if (mes == 4) {
			return "Abril";
		} else if (mes == 5) {
			return "Maio";
		} else if (mes == 6) {
			return "Junho";
		} else if (mes == 7) {
			return "Julho";
		} else if (mes == 8) {
			return "Agosto";
		} else if (mes == 9) {
			return "Setembro";
		} else if (mes == 10) {
			return "Outubro";
		} else if (mes == 11) {
			return "Novembro";
		} else if (mes == 12) {
			return "Dezembro";
		} else {
			return "Mes inválido";
		}
	}

	public static List<Integer> getPeriodoProximo(Integer ano, Integer mes) {
		List<Integer> listaMesAno = new ArrayList<>();
		int month;
		Integer year = ano;

		if (mes == 12) {
			month = 1;
			year = ano + 1;
		} else {
			month = mes + 1;
		}

		listaMesAno.add(month);
		listaMesAno.add(year);
		return listaMesAno;
	}

	public static List<Integer> getPeriodoAnterior(Integer ano, Integer mes) {
		List<Integer> listaMesAno = new ArrayList<>();
		int month;
		Integer year = ano;

		if (mes == 1) {
			month = 12;
			year = ano - 1;
		} else {
			month = mes - 1;
		}

		listaMesAno.add(month);
		listaMesAno.add(year);
		return listaMesAno;
	}
}
