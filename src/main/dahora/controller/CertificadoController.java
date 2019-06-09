package main.dahora.controller;

import java.util.List;

import main.dahora.connection.ConnectionPostgres;
import main.dahora.dao.CertificadoDAO;
import main.dahora.model.Certificado;

public class CertificadoController {
	ConnectionPostgres connectionPostgres = new ConnectionPostgres();
	CertificadoDAO certificadoDAO = new CertificadoDAO(connectionPostgres);
	
	public boolean addCertificado(Long id, String titulo, String tipo, Integer qtdHoras) {
		Certificado certificado = new Certificado();
		certificado.setId(id);
		certificado.setTitulo(titulo);
		certificado.setTipo(tipo);
		certificado.setQtdHoras(qtdHoras);
		return certificadoDAO.create(certificado);
	}
	
	public Certificado getCertificadoById(Long id) {
		return certificadoDAO.getCertificado(id);
	}
	
	public boolean deleteCertificado(Long id) {
		return certificadoDAO.delete(id);
	}
	
	public boolean updateCertificado(Certificado certificado) {
		return certificadoDAO.update(certificado);
	}
	
	public List<Certificado> getCertificadosByMatricula(Integer matricula) {
		return certificadoDAO.getCertificadosByAluno(matricula);
	}
	
}
