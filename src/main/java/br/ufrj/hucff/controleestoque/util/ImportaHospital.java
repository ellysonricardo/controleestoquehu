package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.Hospital;

public class ImportaHospital {

	/**
	 * @author ellysonalmeida
	 * @date 07/06/2023
	 * 
	 *    
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "hospital.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<Hospital> daoGeneric = new DAOGeneric<Hospital>();
		Hospital hospital = new Hospital();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] hospitalStr = linha.split(separa);
				
				
				if (!hospitalStr[0].isEmpty()) {
					Integer id = Integer.valueOf(hospitalStr[0]);
					hospital.setId(id);
				}
				
				if (!hospitalStr[1].isEmpty()) {
					hospital.setCodigo(hospitalStr[1]);
				}
				
				if (!hospitalStr[2].isEmpty()) {
					hospital.setDescricao(hospitalStr[2]);
				}
				
				daoGeneric.salvar(hospital);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}