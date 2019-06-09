package main.dahora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.dahora.connection.ConnectionPostgres;
import main.dahora.model.Aluno;
import main.dahora.model.Certificado;

public class CertificadoDAO {
	private Connection connection;
	private ConnectionPostgres connectionPostgres;
	
	public CertificadoDAO (ConnectionPostgres connectionPostgres) {
		this.connectionPostgres = connectionPostgres;
	}
	
	public boolean create(Certificado certificado) {
		String sql = "insert into certificado (id, titulo, tipo, qtdHoras) values (?,?,?,?)";
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, certificado.getId());
			stmt.setString(2, certificado.getTitulo());
			stmt.setString(3, certificado.getTipo());
			stmt.setInt(4, certificado.getQtdHoras());
			
			stmt.execute();
			stmt.close();
			
			return true;
		} catch (SQLException e){
			
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public List<Certificado> getCertificadosByAluno(Integer matricula){
		String sql = "select * from certificado where aluno = ?";
		List<Certificado> certificados = new ArrayList<Certificado>();
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, matricula);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Certificado certificado = new Certificado();
				certificado.setId(rs.getLong("id"));
				certificado.setTitulo(rs.getString("titulo"));
				certificado.setTipo(rs.getString("tipo"));
				certificado.setQtdHoras(rs.getInt("qtdHoras"));
				
				certificados.add(certificado);
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
		return certificados;
	}
	
	public Certificado getCertificado(Long id) {
		String sql = "select * from certificado where id = ?";
		Certificado certificado = null;
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				certificado = new Certificado();
				certificado.setId(rs.getLong("id"));
				certificado.setTitulo(rs.getString("titulo"));
				certificado.setTipo(rs.getString("tipo"));
				certificado.setQtdHoras(rs.getInt("qtdHoras"));
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
		return certificado;
	}
	
	public boolean update(Certificado certificado) {
		String sql = "update certificado set id = ?, titulo = ?, tipo = ?, qtdHoras = ? where id = ?";
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, certificado.getId());
			stmt.setString(2, certificado.getTitulo());
			stmt.setString(3, certificado.getTipo());
			stmt.setInt(4, certificado.getQtdHoras());
			stmt.setLong(5, certificado.getId());
			
			stmt.executeUpdate();
			stmt.close();
			
			return true;
		}catch (SQLException e) {
			
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean delete(Long id) {
		String sql = "delete from certificado where id = ?";
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, id);
			stmt.executeUpdate();
			stmt.close();
			
			return true;
			
		}catch (SQLException e) {
			
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
}
