package br.ufrj.hucff.controleestoque.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fornecedor {
	
	@Id
	private Integer id;
	private String cnpj;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
