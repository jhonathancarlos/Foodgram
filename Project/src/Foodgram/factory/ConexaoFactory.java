package Foodgram.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String URL = "jdbc:mysql://localhost:3306/newschema";
	private static final String USER = "root";
	private static final String PASSWORD = "c@tolic@";
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
