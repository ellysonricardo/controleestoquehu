package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.UnidadeOrganizacional;

public class ImportaUnidadeOrganizacional {

	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "unidadeorganizacional.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<UnidadeOrganizacional> daoGeneric = new DAOGeneric<UnidadeOrganizacional>();
		UnidadeOrganizacional unidadeOrganizacional = new UnidadeOrganizacional();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] categoriaStr = linha.split(separa);
				
				
				if (!categoriaStr[0].isEmpty()) {
					Integer id = Integer.valueOf(categoriaStr[0]);
					unidadeOrganizacional.setId(id);
				}
				
				if (!categoriaStr[1].isEmpty()) {
					unidadeOrganizacional.setCodigo(categoriaStr[1]);
				}
				
				if (!categoriaStr[2].isEmpty()) {
					unidadeOrganizacional.setNome(categoriaStr[2]);
				}
				
				daoGeneric.salvar(unidadeOrganizacional);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}