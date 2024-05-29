package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.GrupoInventario;

public class ImportaGrupoInventario {

	/**
	 * @author ellysonalmeida
	 * @date 01/06/2023
	 * 
	 *    
	 */

	
	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "grupoinventario.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<GrupoInventario> daoGeneric = new DAOGeneric<GrupoInventario>();
		GrupoInventario grupoInventario = new GrupoInventario();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] grupoInventarioStr = linha.split(separa);
				
				
				if (!grupoInventarioStr[0].isEmpty()) {
					Long id = Long.valueOf(grupoInventarioStr[0]);
					grupoInventario.setId(id);
				}
				
				if (!grupoInventarioStr[1].isEmpty()) {
					grupoInventario.setGrupo(grupoInventarioStr[1]);
				}
				
				daoGeneric.salvar(grupoInventario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}