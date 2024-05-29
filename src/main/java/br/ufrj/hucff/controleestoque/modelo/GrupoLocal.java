package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GrupoLocal implements Serializable {

	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: RBC_DepartmentGroup
	 * @tabelaFisica - Global: ^RBC("DEP",{DEP_RowId})
	 *     
	 */
	
	private static final long serialVersionUID = 8663937800767780437L;
	
	@Id
	private Integer id;
	private String codigo;
	private String decricao;

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
	public String getDecricao() {
		return decricao;
	}
	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
}
