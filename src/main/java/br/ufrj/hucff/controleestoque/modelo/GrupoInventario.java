package br.ufrj.hucff.controleestoque.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GrupoInventario {

	@Id
	private Long id;
	private String grupo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
