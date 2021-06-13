package br.com.cooperativa.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestaConexao {
	
	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			String url = "jdbc:mysql://localhost/lacqua";
			String usuario = "admin";
			String senha = "admin";
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
			conexao.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao criar a conexão: " + e.getMessage());
		}
	}
}
