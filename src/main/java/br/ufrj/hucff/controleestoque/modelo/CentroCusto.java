package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;

@Entity
@Table( comment = " tabelaLogica: GLC_CC; tabelaFisica-Glogal: ^GLC(\"GLCCC\",{GLCCC_RowId}); UnidadeOrganizacional - GLCCC_CoCode_DR -> CTCO(CT_Company)" , appliesTo = "CentroCusto" )
public class CentroCusto implements Serializable {
	
	private static final long serialVersionUID = 3121751880843778571L;
	
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: GLC_CC
	 * @tabelaFisica - Global: ^GLC("GLCCC",{GLCCC_RowId})
	 *    
	 * @fk: UnidadeOrganizacional - GLCCC_CoCode_DR -> CTCO(CT_Company)  
	 */
	
	@Id
	private Integer id;
	private String codigo;
	private String descricao;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_controcusto_unidadeorganizacional"))
	private UnidadeOrganizacional unidadeOrganizacional; //CTCO
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (arquivado IN ('Y', 'N'))")
	private YesOrNo arquivado;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UnidadeOrganizacional getUnidadeOrganizacional() {
		return unidadeOrganizacional;
	}
	public void setUnidadeOrganizacional(UnidadeOrganizacional unidadeOrganizacional) {
		this.unidadeOrganizacional = unidadeOrganizacional;
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
	public YesOrNo getArquivado() {
		return arquivado;
	}
	public void setArquivado(YesOrNo arquivado) {
		this.arquivado = arquivado;
	}
}
