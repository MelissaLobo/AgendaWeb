package br.com.bruno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteAgenda {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/Agenda","SA","");

		Statement statement = connection.createStatement();
		statement.execute("select * from Agenda");
		
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()){
		int id = resultSet.getInt("id");
	    System.out.println(id);
		
	}
	resultSet.close();
	statement.close();
	connection.close();
 }

}