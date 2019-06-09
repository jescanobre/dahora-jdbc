package main.dahora.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgres {
	private final String user = "postgres";
	private final String password = "postgres";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/daHora", user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
