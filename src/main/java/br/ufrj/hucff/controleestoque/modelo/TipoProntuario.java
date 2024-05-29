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
@Table( comment = " tabelaLogica: RTC_MRecordType; tabelaFisica-Glogal: ^RTC(\"TYPE\",{TYP_RowId}); fk: Localizacao - TYP_CTLOC_DR -> CT_Loc; coluna tipovolume check: [E] Baseado_Episodio [U] Definido_pelo_Usuario" , appliesTo = "TipoProntuario" )
public class TipoProntuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: RTC_MRecordType
	 * @tabelaFisica-Glogal: ^RTC("TYPE",{TYP_RowId})
	 *    
	 * @fk: Localizacao - TYP_CTLOC_DR -> CT_Loc
	 */
	
	@Id
    private Integer id;
	private String codigo;
	private String descricao;
	private String prefix;
	private String suffix;
	private Integer tamanho;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (TipoVolume IN ('E', 'U'))")
	private TipoVolume tipoVolume;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_tipo_prontuario_localizacao"))
	private CadastroLocal localizacao;
	
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
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public Integer getTamanho() {
		return tamanho;
	}
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	public TipoVolume getTipoVolume() {
		return tipoVolume;
	}
	public void setTipoVolume(TipoVolume tipoVolume) {
		this.tipoVolume = tipoVolume;
	}
}
