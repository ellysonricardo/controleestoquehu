package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UnidadeOrganizacional implements Serializable {
	 
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: CTCO
	 * @tabelaFisica - Global: ^CT("CTCO",{CTCO_RowId})
	 *    
	 * 
	 */
	
	private static final long serialVersionUID = 4826945308239291257L;
	
	@Id
	private Integer id;
	private String codigo;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
