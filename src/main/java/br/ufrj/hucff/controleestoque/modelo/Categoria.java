package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = -3259542656261416327L;
	
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: INC_StkCat
	 * @tabelaFisica - 
	 *    
	 */
	
	@Id
	private Long id;
	private String Categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
}
