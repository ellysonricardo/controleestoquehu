package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.CategoriaEsterilizacao;

public class ImportaCategoriaEsterilizacao {

	/**
	 * @author ellysonalmeida
	 * @date 31/05/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "categoriaesterilizacao.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<CategoriaEsterilizacao> daoGeneric = new DAOGeneric<CategoriaEsterilizacao>();
		CategoriaEsterilizacao categoriaEsterilizacao = new CategoriaEsterilizacao();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] categoriaEsterilizacaoStr = linha.split(separa);
				
				
				if (!categoriaEsterilizacaoStr[0].isEmpty()) {
					Long id = Long.valueOf(categoriaEsterilizacaoStr[0]);
					categoriaEsterilizacao.setId(id);
				}
				
				if (!categoriaEsterilizacaoStr[1].isEmpty()) {
					categoriaEsterilizacao.setCategoria(categoriaEsterilizacaoStr[1]);
				}
				
				daoGeneric.salvar(categoriaEsterilizacao);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}