package main.dahora.model;

public class Certificado {
	private Long id;
	private String titulo;
	private String tipo;
	private Integer qtdHoras;
	
	public Certificado(Long id, String titulo, String tipo, Integer qtdHoras) {
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.qtdHoras = qtdHoras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}
}
