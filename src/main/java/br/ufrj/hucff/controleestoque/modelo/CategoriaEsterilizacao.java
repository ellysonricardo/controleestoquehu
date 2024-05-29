package br.ufrj.hucff.controleestoque.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoriaEsterilizacao {
	
	@Id
	private Long id;
	private String categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
