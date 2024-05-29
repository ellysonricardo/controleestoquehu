package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital implements Serializable {
	

	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: CT_Hospital
	 * @tabelaFisica - ^CT("HOSP",{HOSP_RowId})
	 *    
	 */
	
	private static final long serialVersionUID = 7800845526702438223L;
	
	@Id
	private Integer id;
	private String codigo;
	private String descricao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
