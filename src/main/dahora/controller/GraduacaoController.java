package main.dahora.controller;

import java.util.List;

import main.dahora.connection.ConnectionPostgres;
import main.dahora.dao.GraduacaoDAO;
import main.dahora.model.Graduacao;

public class GraduacaoController {
	ConnectionPostgres connectionPostgres = new ConnectionPostgres();
	GraduacaoDAO graduacaoDAO = new GraduacaoDAO(connectionPostgres);
	
	public Graduacao getGraduacao(Long id) {
		return graduacaoDAO.getGraduacao(id);
	}
	
	public List<Graduacao> getGraduacoes() {
		return graduacaoDAO.getGraduacoes();
	}
}
