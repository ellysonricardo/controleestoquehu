package br.ufrj.hucff.controleestoque.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;

@Entity
@Table( comment = "tabelaLogica: ARC_ItmMast; tabelaFisica-Glogal: ^ARCIM({ARCIM_Subscript},{ARCIM_Version}); tipoDose [O]Uma_Dose [D]Dose_Diaria [U]Doce_Unitaria" , appliesTo = "ItemPedido" )
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 9202665665199319841L;
	
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: ARC_ItmMast
	 * @tabelaFisica - Global: ^ARCIM({ARCIM_Subscript},{ARCIM_Version})
	 *    
	 * @fk: ARCIM_BillBodyP_DR -> ARC_BillBodyParts 
	 * @fk: ARCIM_BillSub_DR -> ARC_BillSub
	 * @fk: ARCIM_BillingUOM_DR -> CT_UOM
	 * @fk: ARCIM_BillSub_DR -> ARC_BillSub
	 * @fk: ARCIM_CurVers_DR -> ARC_ItmMast
	 * @fk: ARCIM_DefPriority_DR -> OEC_Priority
	 * @fk: ARCIM_DerFeeRules_DR -> ARC_DerivedFeeRules
	 * @fk: ARCIM_Generic_DR -> PHC_Generic
	 * @fk: ARCIM_IncSource_DR -> ARC_IncomeSource
	 * @fk: ARCIM_InsSubCat_DR -> ARC_InsuranceSubcategory
	 * @fk: ARCIM_ItemCat_DR -> ARC_ItemCat
	 * @fk: ARCIM_MealType_DR -> DTC_MealType
	 * @fk: ARCIM_PHCDF_DR -> PHC_DrgForm
	 * @fk: ARCIM_RiceType_DR -> DTC_RiceType  
	 * @fk: ARCIM_RMDuration_DR -> PHC_Duration
	 * @fk: ARCIM_RMFrequency_DR -> PHC_Freq 
	 * @fk: ARCIM_ServCat_DR -> ARC_ServCat
	 * @fk: ARCIM_ServiceGroup_DR -> RBC_ServiceGroup
	 * @fk: ARCIM_ServTax_DR -> ARC_ServTax
	 * @fk: unidadeDispensacao ARCIM_UOM_DR -> CT_UOM
	 * @fk: ARCIM_Surcharge_DR -> ARC_SurchargeCode
	 * 
	 */
	
	@Id
	private Integer id;
	private String codigo;
	private String descricao;
	private String abreviacao;
	@OneToOne
	private UnidadeDispensacao unidadeDispensacao;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (tipoDose IN ('O', 'D', 'U'))")
	private TipoDose tipoDose;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (perfil IN ('Y', 'N'))")
	private YesOrNo perfil;
//	datahora
//	data
//	hora
//	
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
	public String getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
	public UnidadeDispensacao getUnidadeDispensacao() {
		return unidadeDispensacao;
	}
	public void setUnidadeDispensacao(UnidadeDispensacao unidadeDispensacao) {
		this.unidadeDispensacao = unidadeDispensacao;
	}
	public TipoDose getTipoDose() {
		return tipoDose;
	}
	public void setTipoDose(TipoDose tipoDose) {
		this.tipoDose = tipoDose;
	}
	public YesOrNo getPerfil() {
		return perfil;
	}
	public void setPerfil(YesOrNo perfil) {
		this.perfil = perfil;
	}
}
