package br.com.bruno;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConeccao {
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");
		System.out.println("Abrindo uma conexao com sucesso");
		connection.close();
	}
}