package main.dahora.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgres {
	private final String ip = "localhost";
	private final Integer port = 5432;
	private final String user = "postgres";
	private final String password = "postgres";
	private final String database = "daHora";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/daHora", user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
