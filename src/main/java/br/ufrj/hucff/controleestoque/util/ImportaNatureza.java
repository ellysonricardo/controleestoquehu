package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.Natureza;
import br.ufrj.hucff.controleestoque.modelo.UnidadeOrganizacional;
import br.ufrj.hucff.controleestoque.modelo.YesOrNo;

public class ImportaNatureza {

	/**
	 * @author ellysonalmeida
	 * @date 01/06/2023
	 * 
	 *    
	 */
	
	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "natureza.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<Natureza> daoGeneric = new DAOGeneric<Natureza>();
		Natureza natureza = new Natureza();
		UnidadeOrganizacional unidadeOrganizacional = new UnidadeOrganizacional();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] naturezaStr = linha.split(separa);
				
				
				if (!naturezaStr[0].isEmpty()) {
					Integer id = Integer.valueOf(naturezaStr[0]);
					natureza.setId(id);
				}
				
				if (!naturezaStr[1].isEmpty()) {
					if (naturezaStr[1].equals("Y"))
						natureza.setGerenciaCaixa(YesOrNo.Y);
					if (naturezaStr[1].equals("N"))
						natureza.setGerenciaCaixa(YesOrNo.N);
				}
				
				if (!naturezaStr[2].isEmpty()) {
					natureza.setClasse(naturezaStr[2]);
				}
				
				if (!naturezaStr[3].isEmpty()) {
					Integer unidadeOrganizacionalInt = Integer.valueOf(naturezaStr[3]);
					unidadeOrganizacional.setId(unidadeOrganizacionalInt);
					natureza.setUnidadeOrganizacional(unidadeOrganizacional);
				}
				
				if (!naturezaStr[4].isEmpty()) {
					natureza.setDescricao(naturezaStr[4]);
				}
				
				if (!naturezaStr[5].isEmpty()) {
					if (naturezaStr[5].equals("Y"))
						natureza.setArquivada(YesOrNo.Y);
					if (naturezaStr[5].equals("N"))
						natureza.setArquivada(YesOrNo.N);
				}
				
				if (!naturezaStr[6].isEmpty()) {
					natureza.setTipo(naturezaStr[6]);
				}
				
				if (!naturezaStr[7].isEmpty()) {
					natureza.setCodigo(naturezaStr[7]);
				}
				
				daoGeneric.salvar(natureza);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}