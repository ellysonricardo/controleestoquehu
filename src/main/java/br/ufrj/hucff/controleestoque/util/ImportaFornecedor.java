package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.Fornecedor;

public class ImportaFornecedor {

	/**
	 * @author ellysonalmeida
	 * @date 31/05/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "fornecedor.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<Fornecedor> daoGeneric = new DAOGeneric<Fornecedor>();
		Fornecedor fornecedor = new Fornecedor();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] fornecedorStr = linha.split(separa);
				
				
				if (!fornecedorStr[0].isEmpty()) {
					Integer id = Integer.valueOf(fornecedorStr[0]);
					fornecedor.setId(id);
				}
				
				if (!fornecedorStr[1].isEmpty()) {
					fornecedor.setCnpj(fornecedorStr[1]);
				}
				
				daoGeneric.salvar(fornecedor);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}