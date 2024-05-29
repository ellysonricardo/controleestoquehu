package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.CadastroLocal;
import br.ufrj.hucff.controleestoque.modelo.Categoria;
import br.ufrj.hucff.controleestoque.modelo.CategoriaEsterilizacao;
import br.ufrj.hucff.controleestoque.modelo.GrupoInventario;
import br.ufrj.hucff.controleestoque.modelo.ItemEstoque;
import br.ufrj.hucff.controleestoque.modelo.ItemPedido;
import br.ufrj.hucff.controleestoque.modelo.LoteRequerido;
import br.ufrj.hucff.controleestoque.modelo.Natureza;
import br.ufrj.hucff.controleestoque.modelo.TipoCompra;
import br.ufrj.hucff.controleestoque.modelo.UnidadeDispensacao;

public class ImportaItemEstoque {

	/**
	 * @author ellysonalmeida
	 * @date 26/05/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		
		final String csvFile = caminhoSt + "itemestoque.txt";
		String linha = "";
		final String separa = ";";
		ItemEstoque itemEstoque = new ItemEstoque();
		Natureza natureza = new Natureza();
		ItemPedido itemPedido = new ItemPedido();
		CadastroLocal cadastroLocal = new CadastroLocal();
		UnidadeDispensacao unidadeDispensacao = new UnidadeDispensacao();
		TipoCompra tipoCompra = new TipoCompra();
		Categoria categoria = new Categoria();
		GrupoInventario grupoInventario = new GrupoInventario();
		CategoriaEsterilizacao categoriaEsterilizacao = new CategoriaEsterilizacao();
		
		DAOGeneric<ItemEstoque> daoGeneric = new DAOGeneric<ItemEstoque>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile, StandardCharsets.UTF_8))) {

			while ((linha = br.readLine()) != null) {

				String[] itemEstoqueStr = linha.split(separa);
				
				
				if (!itemEstoqueStr[0].isEmpty()) {
					Integer id = Integer.valueOf(itemEstoqueStr[0]);
					itemEstoque.setId(id);
				}
				
				if (!itemEstoqueStr[1].isEmpty()) {
					Integer naturezaInt = Integer.valueOf(itemEstoqueStr[1]);
					natureza.setId(naturezaInt);
					itemEstoque.setNatureza(natureza);
				}
				
				if (!itemEstoqueStr[2].isEmpty()) {
					
					int inicio; 
					int fim; 
					inicio = itemEstoqueStr[2].indexOf(0); 
					fim = itemEstoqueStr[2].lastIndexOf("||"); 
					Integer itemPedidoInt = Integer.valueOf(itemEstoqueStr[2].substring(inicio + 1, fim));
					itemPedido.setId(itemPedidoInt);
					itemEstoque.setItemPedido(itemPedido);
				}
				
				if (!itemEstoqueStr[3].isEmpty()) {
					itemEstoque.setCodigoBarra(itemEstoqueStr[3]);
				}
				
				if (!itemEstoqueStr[4].isEmpty()) {
					if(itemEstoqueStr[4].equals("O"))
						itemEstoque.setLoteRequerido(LoteRequerido.O);
					if(itemEstoqueStr[4].equals("R"))
						itemEstoque.setLoteRequerido(LoteRequerido.R);
					if(itemEstoqueStr[4].equals("N"))
						itemEstoque.setLoteRequerido(LoteRequerido.N);
				}
				
				if (!itemEstoqueStr[5].isEmpty()) {
					itemEstoque.setCodigo(itemEstoqueStr[5]);
				}
				
				if (!itemEstoqueStr[6].isEmpty()) {
					Integer cadastroLocalInt = Integer.valueOf(itemEstoqueStr[6]);
					cadastroLocal.setId(cadastroLocalInt);
					itemEstoque.setCadastroLocal(cadastroLocal);
				}
				
				if (!itemEstoqueStr[7].isEmpty()) {
					Integer unidadeDispensacaoInt = Integer.valueOf(itemEstoqueStr[7]);
					unidadeDispensacao.setId(unidadeDispensacaoInt);
					itemEstoque.setUnidadeDispensacao(unidadeDispensacao);
				}
				
				if (!itemEstoqueStr[8].isEmpty()) {
					itemEstoque.setDescricao(itemEstoqueStr[8]);
				}
				
				if (!itemEstoqueStr[9].isEmpty()) {
					Long reservaProdutoLong = Long.valueOf(itemEstoqueStr[9]);
					itemEstoque.setReservaProduto(reservaProdutoLong);
				}
				
				if (!itemEstoqueStr[10].isEmpty()) {
					itemEstoque.setValidadeRequerido(itemEstoqueStr[10]);
				}
				
//				if (!itemEstoqueStr[11].isEmpty()) {
//					Integer fornecedorInt = Integer.valueOf(itemEstoqueStr[11]);
//					fornecedor.setId(fornecedorInt);
//					itemEstoque.setFornecedor(fornecedor);
//				}
				
				if (!itemEstoqueStr[12].isEmpty()) {
					Integer tipoCompraInt = Integer.valueOf(itemEstoqueStr[12]);
					tipoCompra.setId(tipoCompraInt);
					itemEstoque.setTipoCompra(tipoCompra);
				}
				
				if (!itemEstoqueStr[13].isEmpty()) {
					Long categoriaLong = Long.valueOf(itemEstoqueStr[13]);
					categoria.setId(categoriaLong);
					itemEstoque.setCategoria(categoria);
				}
				
				if (!itemEstoqueStr[14].isEmpty()) {
					Long grupoInventarioLong = Long.valueOf(itemEstoqueStr[14]);
					grupoInventario.setId(grupoInventarioLong);
					itemEstoque.setGrupoInventario(grupoInventario);
				}
				
				if (!itemEstoqueStr[15].isEmpty()) {
					itemEstoque.setTransferenciaItem(itemEstoqueStr[15]);
				}
				
				if (!itemEstoqueStr[16].isEmpty()) {
					Long quantidadeLong = Long.valueOf(itemEstoqueStr[16]);
					itemEstoque.setQuantidade(quantidadeLong);
				}
				
				if (!itemEstoqueStr[17].isEmpty()) {
					Long quantidadeMaximaLong = Long.valueOf(itemEstoqueStr[17]);
					itemEstoque.setQuantidadeMaxima(quantidadeMaximaLong);
				}
				
				if (!itemEstoqueStr[18].isEmpty()) {
					Long quatidadeMinimaLong = Long.valueOf(itemEstoqueStr[18]);
					itemEstoque.setQuatidadeMinima(quatidadeMinimaLong);
				}
				
				if (!itemEstoqueStr[19].isEmpty()) {
					itemEstoque.setInativacao(itemEstoqueStr[19]);
				}
				
				
//			   if (!itemEstoqueStr[2].isEmpty()) {
//					int inicio; 
//					int fim; 
//					inicio = itemEstoqueStr[2].indexOf(0); 
//					fim = itemEstoqueStr[2].lastIndexOf("||"); 
//					Long itemPedidoVersaoLong = Long.valueOf(itemEstoqueStr[2].substring(inicio + 1, fim));
//					itemPedidoVersao.setId(itemPedidoVersaoLong);
//					itemEstoque.setItemPedidoVersao(itemPedidoVersao);
//				}
				
				if (!itemEstoqueStr[21].isEmpty()) {
					itemEstoque.setObservacao(itemEstoqueStr[21]);
				}
				
				if (!itemEstoqueStr[22].isEmpty()) {
					Long pontoPedidoLong = Long.valueOf(itemEstoqueStr[22]);
					itemEstoque.setPontoPedido(pontoPedidoLong);
				}
				
				if (!itemEstoqueStr[23].isEmpty()) {
					Long quantidadeReporLong = Long.valueOf(itemEstoqueStr[23]);
					itemEstoque.setQuantidadeRepor(quantidadeReporLong);
				}
				
				if (!itemEstoqueStr[24].isEmpty()) {
					Long categoriaEsterilizacaoLong = Long.valueOf(itemEstoqueStr[24]);
					categoriaEsterilizacao.setId(categoriaEsterilizacaoLong);
					itemEstoque.setCategoriaEsterilizacao(categoriaEsterilizacao);
				}
				
				if (!itemEstoqueStr[25].isEmpty()) {
					itemEstoque.setEsterilizavel(itemEstoqueStr[25]);
				}
				
				if (!itemEstoqueStr[26].isEmpty()) {
					Double custoUnitarioDouble = Double.valueOf(itemEstoqueStr[26]);
					itemEstoque.setCustoUnitario(custoUnitarioDouble);
				}
				
				
				if (itemEstoqueStr[27].isEmpty()) {
					itemEstoque.setReabastecimento("NAO ENCONTRADO");
				}else {
					itemEstoque.setReabastecimento(itemEstoqueStr[27]);
				}
				
				daoGeneric.salvar(itemEstoque);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}