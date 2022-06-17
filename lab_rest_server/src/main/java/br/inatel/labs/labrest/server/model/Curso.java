package br.inatel.labs.labrest.server.model;

public class Curso {
	
	private Long id;
	
	private String descricao;
	
	private Integer cargaHoraria;

	
	//construtor gerado com Ctrl + 3 > 'gcuf' (Generate Constructor Using Fields)

	public Curso(Long id, String descricao, Integer cargaHoraria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
	}

	public Curso() { // construtor padrão
		
	}


	// getters e setters com Ctrl + 3 > 'ggas' (Generate Getter And Setter)
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
	
	
	

}
