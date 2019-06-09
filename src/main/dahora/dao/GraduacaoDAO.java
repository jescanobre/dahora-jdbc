package main.dahora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.dahora.connection.ConnectionPostgres;
import main.dahora.model.Graduacao;

public class GraduacaoDAO {
	private Connection connection;
	private ConnectionPostgres connectionPostgres;
	
	public GraduacaoDAO (ConnectionPostgres connectionPostgres) {
		this.connectionPostgres = connectionPostgres;
	}
	
	public Graduacao getGraduacao (Long id) {
		String sql = "select * from graduacao where id = ?";
		Graduacao graduacao = null;
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				graduacao = new Graduacao();
				graduacao.setId(rs.getLong("id"));
				graduacao.setNome(rs.getString("nome"));
				graduacao.setHoras(rs.getInt("horas"));
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return graduacao;
	}
	
	public List<Graduacao> getGraduacoes(){
		String sql = "select * from graduacao";
		List<Graduacao> graduacoes = new ArrayList<Graduacao>();
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Graduacao graduacao = new Graduacao();
				graduacao.setId(rs.getLong("id"));
				graduacao.setNome(rs.getString("nome"));
				graduacao.setHoras(rs.getInt("horas"));
				
				graduacoes.add(graduacao);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return graduacoes;
	}
}
