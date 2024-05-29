package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Table;

@Entity
@Table( comment = " tabelaLogica: CT_Loc; tabelaFisica-Glogal: ^CTLOC({CTLOC_RowID}); fk: CentroCusto - CTLOC_GLCCC_DR -> GLC_CC; tipoLocal [W]Posto [E]Executavel [DI]Injetaveis [D]Farmacia "
		+ "[C]Caixa [O]Outros [OP]CentroCirurgico [EM]Emergência [DS]HospitalDia [MR]SDM [OR]Consultório, localInternacao [D]Does_Not_Matter [W]Warning [N]Not_Allowed" , appliesTo = "CadastroLocal" )
public class CadastroLocal implements Serializable {
	
	private static final long serialVersionUID = -7368289312340422995L;
	
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: CT_Loc
	 * @tabelaFisica - ^CTLOC({CTLOC_RowID})
	 *    
	 * @fk: CentroCusto - CTLOC_GLCCC_DR -> GLC_CC
	 * @fk: CadastroLocal - CTLOC_Cashier_DR -> CTLOC
	 * @fk: GrupoLocal - CTLOC_OTC_DR -> CTLOC    
	 */
	
	@Id
	private Integer id;
	private String codigo;
	private String descricao;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_cadastrolocal_centrocusto"))
	private CentroCusto centroCusto;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (postoInternacao IN ('Y', 'N'))")
	private YesOrNo postoInternacao;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(2) CHECK (tipoLocal IN ('W', 'E','DI','D','C','O','OP','EM','DS','MR','OR'))")
	private TipoLocal tipoLocal;
	private String andar;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_cadastrolocal_grupolocal"))
	private GrupoLocal grupoLocal;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(2) CHECK (localInternacao IN ('D', 'W','N'))")
	private LocalInternacao localInternacao;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (indexLocal IN ('Y', 'N'))")
	private YesOrNo indexLocal;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_cadastrolocal_hospital"))
	private Hospital hospital;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (confirmacaoExecutor IN ('Y', 'N'))")
	private YesOrNo confirmacaoExecutor;
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (localReabilitacao IN ('Y', 'N'))")
	private YesOrNo localReabilitacao;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (geraNumeroProntuario IN ('Y', 'N'))")
	private YesOrNo geraNumeroProntuario;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_cadastrolocal_tipoprontuario"))
	private TipoProntuario tipoProntuario;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (localColeta IN ('Y', 'N'))")
	private YesOrNo localColeta;
	
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
	public CentroCusto getCentroCusto() {
		return centroCusto;
	}
	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
	public YesOrNo getPostoInternacao() {
		return postoInternacao;
	}
	public void setPostoInternacao(YesOrNo postoInternacao) {
		this.postoInternacao = postoInternacao;
	}
	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}
	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
	public GrupoLocal getGrupoLocal() {
		return grupoLocal;
	}
	public void setGrupoLocal(GrupoLocal grupoLocal) {
		this.grupoLocal = grupoLocal;
	}
	public LocalInternacao getLocalInternacao() {
		return localInternacao;
	}
	public void setLocalInternacao(LocalInternacao localInternacao) {
		this.localInternacao = localInternacao;
	}
	public YesOrNo getIndexLocal() {
		return indexLocal;
	}
	public void setIndexLocal(YesOrNo indexLocal) {
		this.indexLocal = indexLocal;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public YesOrNo getConfirmacaoExecutor() {
		return confirmacaoExecutor;
	}
	public void setConfirmacaoExecutor(YesOrNo confirmacaoExecutor) {
		this.confirmacaoExecutor = confirmacaoExecutor;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public YesOrNo getLocalReabilitacao() {
		return localReabilitacao;
	}
	public void setLocalReabilitacao(YesOrNo localReabilitacao) {
		this.localReabilitacao = localReabilitacao;
	}
	public YesOrNo getGeraNumeroProntuario() {
		return geraNumeroProntuario;
	}
	public void setGeraNumeroProntuario(YesOrNo geraNumeroProntuario) {
		this.geraNumeroProntuario = geraNumeroProntuario;
	}
	public TipoProntuario getTipoProntuario() {
		return tipoProntuario;
	}
	public void setTipoProntuario(TipoProntuario tipoProntuario) {
		this.tipoProntuario = tipoProntuario;
	}
	public YesOrNo getLocalColeta() {
		return localColeta;
	}
	public void setLocalColeta(YesOrNo localColeta) {
		this.localColeta = localColeta;
	}
}
