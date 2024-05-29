package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.Categoria;

public class ImportaCategoria {

	/**
	 * @author ellysonalmeida
	 * @date 31/05/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "categoria.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<Categoria> daoGeneric = new DAOGeneric<Categoria>();
		Categoria categoria = new Categoria();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] categoriaStr = linha.split(separa);
				
				
				if (!categoriaStr[0].isEmpty()) {
					Long id = Long.valueOf(categoriaStr[0]);
					categoria.setId(id);
				}
				
				if (!categoriaStr[1].isEmpty()) {
					categoria.setCategoria(categoriaStr[1]);
				}
				
				daoGeneric.salvar(categoria);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}