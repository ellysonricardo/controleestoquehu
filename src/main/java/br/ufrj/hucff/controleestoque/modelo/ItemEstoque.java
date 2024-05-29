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
@Table( comment = " tabelaLogica: INC_Itm; tabelaFisica-Glogal: ^INCI({INCI_RowId}); loteRequerido [R]Requerido [O]Opcional [N]Nao_Requerido" , appliesTo = "ItemEstoque" )
public class ItemEstoque implements Serializable {
	
	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 * 
	 * 
	 * @tabelaLogica: INC_Itm
	 * @tabelaFisica - Global: ^INCI({INCI_RowId})
	 *    
	 * @fk: natureza INCI_Account_DR -> GLC_Acct
	 * @fk: itemPedido INCI_ARCIM_DR -> ARC_ItmMast
	 * @fk: cadastroLocal INCI_CTLOC_DR -> CT_Loc
	 * @fk: unidadeDispensacao INCI_CTUOM_DR  -> CT_UOM
	 * @fk: tipoCompra INCI_INCPO_DR  -> INC_POGroup
	 * @fk: categoria INCI_INCSC_DR -> INC_StkCat
	 * @fk: grupoInventario INCI_INCTG_DR -> INC_StkTkGp
	 * @fk: itemPedidoVersao INCI_OriginalARCIM -> ARC_ItmMast
	 * @fk: categoriaEsterilizacao INCI_SterCat_DR -> INC_SterileCategory
	 * 
	 * R("Requerido"), O("Opcional"), N("Nao_Requerido");
	 */
	
	private static final long serialVersionUID = -7348199054940826704L;
	
	@Id
	private Integer id;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_natureza"))
	private Natureza natureza;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_itempedido"))
	private ItemPedido itemPedido;
	private String codigoBarra;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "CHAR(1) CHECK (loteRequerido IN ('R', 'O','N'))")
	private LoteRequerido loteRequerido;
	private String codigo;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_cadastrolocal"))
	private CadastroLocal cadastroLocal;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_unidadedispensacao"))
	private UnidadeDispensacao unidadeDispensacao;
	@Column(length = 500)
    private String descricao;
    private Long reservaProduto;
    private String validadeRequerido;
    @OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_fornecedor"))
    private Fornecedor fornecedor;
    @OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_tipocompra"))
    private TipoCompra tipoCompra;
    @OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_categoria"))
    private Categoria categoria;
    @OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_grupoinventario"))
    private GrupoInventario grupoInventario;
    private String transferenciaItem;
    private Long quantidade;
    private Long quantidadeMaxima;
    private Long quatidadeMinima;
    private String inativacao;
    @OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_itempedidoversao"))
    private ItemPedidoVersao itemPedidoVersao;
    private String observacao;
    private Long pontoPedido;
    private Long quantidadeRepor;
    @OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_itemestoque_categoriaesterilizacao"))
    private CategoriaEsterilizacao categoriaEsterilizacao;
    private String esterilizavel;
    private Double custoUnitario;
    private String reabastecimento;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Natureza getNatureza() {
		return natureza;
	}
	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}
	public ItemPedido getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public LoteRequerido getLoteRequerido() {
		return loteRequerido;
	}
	public void setLoteRequerido(LoteRequerido loteRequerido) {
		this.loteRequerido = loteRequerido;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public CadastroLocal getCadastroLocal() {
		return cadastroLocal;
	}
	public void setCadastroLocal(CadastroLocal cadastroLocal) {
		this.cadastroLocal = cadastroLocal;
	}
	public UnidadeDispensacao getUnidadeDispensacao() {
		return unidadeDispensacao;
	}
	public void setUnidadeDispensacao(UnidadeDispensacao unidadeDispensacao) {
		this.unidadeDispensacao = unidadeDispensacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getReservaProduto() {
		return reservaProduto;
	}
	public void setReservaProduto(Long reservaProduto) {
		this.reservaProduto = reservaProduto;
	}
	public String getValidadeRequerido() {
		return validadeRequerido;
	}
	public void setValidadeRequerido(String validadeRequerido) {
		this.validadeRequerido = validadeRequerido;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public TipoCompra getTipoCompra() {
		return tipoCompra;
	}
	public void setTipoCompra(TipoCompra tipoCompra) {
		this.tipoCompra = tipoCompra;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public GrupoInventario getGrupoInventario() {
		return grupoInventario;
	}
	public void setGrupoInventario(GrupoInventario grupoInventario) {
		this.grupoInventario = grupoInventario;
	}
	public String getTransferenciaItem() {
		return transferenciaItem;
	}
	public void setTransferenciaItem(String transferenciaItem) {
		this.transferenciaItem = transferenciaItem;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Long getQuantidadeMaxima() {
		return quantidadeMaxima;
	}
	public void setQuantidadeMaxima(Long quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}
	public Long getQuatidadeMinima() {
		return quatidadeMinima;
	}
	public void setQuatidadeMinima(Long quatidadeMinima) {
		this.quatidadeMinima = quatidadeMinima;
	}
	public String getInativacao() {
		return inativacao;
	}
	public void setInativacao(String inativacao) {
		this.inativacao = inativacao;
	}
	public ItemPedidoVersao getItemPedidoVersao() {
		return itemPedidoVersao;
	}
	public void setItemPedidoVersao(ItemPedidoVersao itemPedidoVersao) {
		this.itemPedidoVersao = itemPedidoVersao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Long getPontoPedido() {
		return pontoPedido;
	}
	public void setPontoPedido(Long pontoPedido) {
		this.pontoPedido = pontoPedido;
	}
	public Long getQuantidadeRepor() {
		return quantidadeRepor;
	}
	public void setQuantidadeRepor(Long quantidadeRepor) {
		this.quantidadeRepor = quantidadeRepor;
	}
	public CategoriaEsterilizacao getCategoriaEsterilizacao() {
		return categoriaEsterilizacao;
	}
	public void setCategoriaEsterilizacao(CategoriaEsterilizacao categoriaEsterilizacao) {
		this.categoriaEsterilizacao = categoriaEsterilizacao;
	}
	public String getEsterilizavel() {
		return esterilizavel;
	}
	public void setEsterilizavel(String esterilizavel) {
		this.esterilizavel = esterilizavel;
	}
	public Double getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(Double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	public String getReabastecimento() {
		return reabastecimento;
	}
	public void setReabastecimento(String reabastecimento) {
		this.reabastecimento = reabastecimento;
	}
}