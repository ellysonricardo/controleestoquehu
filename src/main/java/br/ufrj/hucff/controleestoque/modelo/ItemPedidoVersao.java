package br.ufrj.hucff.controleestoque.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemPedidoVersao {
	
	@Id
	private Long id;
	private String descricao;
	
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
}
