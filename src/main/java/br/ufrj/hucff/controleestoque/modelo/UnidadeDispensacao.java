package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UnidadeDispensacao implements Serializable {

	/**
	 * @author ellysonalmeida
	 * @date 03/07/2023
	 * 
	 * 
	 * @tabelaLogica: CT_UOM
	 * @tabelaFisica - Global: ^CT("UOM",{CTUOM_RowId})
	 *    
	 */
	
	private static final long serialVersionUID = -2129384917406733804L;
	@Id
	private Integer id;
	private String Codigo;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
