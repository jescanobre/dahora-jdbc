package main.dahora.model;

public class Graduacao {
	private Long id;
	private String nome;
	private Integer horas;
	
	public Graduacao (Long id, String nome, Integer horas) {
		this.id = id;
		this.nome = nome;
		this.horas = horas;
	}
	
	public Graduacao () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
}
