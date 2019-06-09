package main.dahora.controller;

import main.dahora.connection.ConnectionPostgres;
import main.dahora.dao.AlunoDAO;
import main.dahora.model.Aluno;

public class AlunoController {
	ConnectionPostgres connectionPostgres = new ConnectionPostgres();
	AlunoDAO alunoDAO = new AlunoDAO(connectionPostgres);
	
	public boolean addAluno(Integer matricula, String nome, String email, String senha) {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setSenha(senha);
		return alunoDAO.create(aluno);
	}
	
	public Aluno getAlunoByMatricula(Integer matricula) {
		return alunoDAO.getAluno(matricula);
	}
	
	public boolean deleteAluno(Integer matricula) {
		return alunoDAO.delete(matricula);
	}
	
	public boolean UpdateAluno(Aluno aluno) {
		return alunoDAO.update(aluno);
	}
	
}
