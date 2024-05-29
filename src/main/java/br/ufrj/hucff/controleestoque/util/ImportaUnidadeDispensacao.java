package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.UnidadeDispensacao;

public class ImportaUnidadeDispensacao {

	/**
	 * @author ellysonalmeida
	 * @date 26/05/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "unidadedispensacao.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<UnidadeDispensacao> daoGeneric = new DAOGeneric<UnidadeDispensacao>();
		UnidadeDispensacao unidadeDispensacao = new UnidadeDispensacao();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] unidadeDispensacaoStr = linha.split(separa);
				
				
				if (!unidadeDispensacaoStr[0].isEmpty()) {
					Integer id = Integer.valueOf(unidadeDispensacaoStr[0]);
					unidadeDispensacao.setId(id);
				}
				
				if (!unidadeDispensacaoStr[1].isEmpty()) {
					unidadeDispensacao.setDescricao(unidadeDispensacaoStr[1]);
				}
				
				daoGeneric.salvar(unidadeDispensacao);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}