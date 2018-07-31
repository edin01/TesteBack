package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

//	Classe que cria a conexao com o DB
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

//		Retorna uma conexao
		return DriverManager.getConnection("jdbc:mysql://localhost/TesteBack",
				"root", "");
	}
}
