package br.com.cooperativa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {

	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			//Registra classe JDBC e parï¿½metros de conexï¿½o em runtime
			System.out.println("Conectando ao banco de dados.");
			System.out.println("... \n...");
			String url = "jdbc:mysql://localhost/lacqua";
			String usuario = "admin";
			String senha = "senhaadm@10";
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao criar a conexão. Erro: " + e.getMessage());
		}
	}
}
