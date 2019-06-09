package main.dahora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.dahora.connection.ConnectionPostgres;
import main.dahora.model.Aluno;

public class AlunoDAO {
	private Connection connection;
	private ConnectionPostgres connectionPostgres;
	
	public AlunoDAO (ConnectionPostgres connectionPostgres) {
		this.connectionPostgres = connectionPostgres;
	}
	
	public boolean create(Aluno aluno) {
		String sql = "insert into aluno (matricula, nome, email, senha) values (?,?,?,?)";
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEmail());
			stmt.setString(4, aluno.getSenha());
			
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
	
	public Aluno getAluno (Integer matricula) {
		String sql = "select * from aluno where matricula = ?";
		Aluno aluno = null;
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, matricula);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSenha(rs.getString("senha"));
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
		return aluno;
	}
	
	public boolean update(Aluno aluno) {
		String sql = "update aluno set matricula = ?, nome = ?, email = ?, senha = ? where matricula = ?";
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEmail());
			stmt.setString(4, aluno.getSenha());
			stmt.setInt(5, aluno.getMatricula());
			
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
	
	public boolean delete(Integer matricula) {
		String sql = "delete from aluno where matricula = ?";
		
		try {
			this.connection = connectionPostgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, matricula);
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
