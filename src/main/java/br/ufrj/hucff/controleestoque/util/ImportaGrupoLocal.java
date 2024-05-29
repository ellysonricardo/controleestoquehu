package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.GrupoLocal;

public class ImportaGrupoLocal {

	/**
	 * @author ellysonalmeida
	 * @date 12/06/2023
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "grupolocal.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<GrupoLocal> daoGeneric = new DAOGeneric<GrupoLocal>();
		GrupoLocal grupoLocal = new GrupoLocal();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] grupoLocalStr = linha.split(separa);
				
				
				if (!grupoLocalStr[0].isEmpty()) {
					Integer id = Integer.valueOf(grupoLocalStr[0]);
					grupoLocal.setId(id);
				}
				
				if (!grupoLocalStr[1].isEmpty()) {
					grupoLocal.setCodigo(grupoLocalStr[1]);
				}
				
				if (!grupoLocalStr[2].isEmpty()) {
					grupoLocal.setDecricao(grupoLocalStr[2]);
				}
				
				daoGeneric.salvar(grupoLocal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}