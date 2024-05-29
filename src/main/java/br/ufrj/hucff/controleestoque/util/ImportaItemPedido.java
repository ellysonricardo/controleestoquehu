package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.ItemPedido;

public class ImportaItemPedido {

	/**
	 * @author ellysonalmeida
	 * @date 01/06/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "itempedido.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<ItemPedido> daoGeneric = new DAOGeneric<ItemPedido>();
		ItemPedido itemPedido = new ItemPedido();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] itemPedidoStr = linha.split(separa);
				
				
				if (!itemPedidoStr[0].isEmpty()) {
					Integer id = Integer.valueOf(itemPedidoStr[0]);
					itemPedido.setId(id);
				}
				
				if (!itemPedidoStr[1].isEmpty()) {
					itemPedido.setDescricao(itemPedidoStr[1]);
				}
				
				daoGeneric.salvar(itemPedido);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}