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
@Table( comment = " tabelaLogica: GLC_Acct; tabelaFisica-Glogal: ^GLC(\"GLCAC\",{GLCAC_RowId}); fk: unidadeOrganizacional GLCAC_CoCode_DR -> CTCO;" , appliesTo = "Natureza" )
public class Natureza implements Serializable {
	private static final long serialVersionUID = 2039586206662037290L;
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: GLC_Acct
	 * @tabelaFisica - Global: ^GLC("GLCAC",{GLCAC_RowId})
	 * 
	 * @fk: unidadeOrganizacional GLCAC_CoCode_DR -> CTCO
	 */

	@Id
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (gerenciaCaixa IN ('Y', 'N'))")
	private YesOrNo gerenciaCaixa;
	private String classe;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_natureza_unidadeOrganizacional"))
	private UnidadeOrganizacional unidadeOrganizacional;
	private String descricao;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (arquivada IN ('Y', 'N'))")
	private YesOrNo arquivada;
	private String tipo;
	private String codigo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public YesOrNo getGerenciaCaixa() {
		return gerenciaCaixa;
	}
	public void setGerenciaCaixa(YesOrNo gerenciaCaixa) {
		this.gerenciaCaixa = gerenciaCaixa;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public UnidadeOrganizacional getUnidadeOrganizacional() {
		return unidadeOrganizacional;
	}
	public void setUnidadeOrganizacional(UnidadeOrganizacional unidadeOrganizacional) {
		this.unidadeOrganizacional = unidadeOrganizacional;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public YesOrNo getArquivada() {
		return arquivada;
	}
	public void setArquivada(YesOrNo arquivada) {
		this.arquivada = arquivada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
