package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.TipoCompra;

public class ImportaTipoCompra {

	/**
	 * @author ellysonalmeida
	 * @date 01/06/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "tipocompra.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<TipoCompra> daoGeneric = new DAOGeneric<TipoCompra>();
		TipoCompra tipoCompra = new TipoCompra();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] tipoCompraStr = linha.split(separa);
				
				
				if (!tipoCompraStr[0].isEmpty()) {
					Integer id = Integer.valueOf(tipoCompraStr[0]);
					tipoCompra.setId(id);
				}
				
				if (!tipoCompraStr[1].isEmpty()) {
					tipoCompra.setTipo(tipoCompraStr[1]);
				}
				
				daoGeneric.salvar(tipoCompra);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}