package br.com.cooperativa.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class LeitorDeArquivo {

	public static List<String> lerArquivo(String nomeArquivo) {
		
		String linha = "";
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
}