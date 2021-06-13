package br.com.cooperativa.util;

import java.util.List;

public class TesteJPA {

	public static void main(String[] args) {
		List<String> listaClientes = BibliotecaFuncoes.lerArquivo("D:/clientes.txt");
		
		System.out.println(listaClientes);
		
		
		System.out.println("Fim!");
		
	}
}