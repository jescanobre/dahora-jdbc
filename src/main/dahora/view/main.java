package main.dahora.view;

import java.awt.SystemColor;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.dahora.connection.ConnectionPostgres;

public class main {

	public static void main(String[] args) throws SQLException {
		try {
			DriverManager.getConnection("jdbc:postgresql://localhost:5432/daHora", "postgres", "postgres");
			System.out.println("Conex�o realizada com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
