package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.CentroCusto;
import br.ufrj.hucff.controleestoque.modelo.UnidadeOrganizacional;
import br.ufrj.hucff.controleestoque.modelo.YesOrNo;

public class ImportaCentroCusto {

	/**
	 * @author ellysonalmeida
	 * @date 22/06/2023
	 */

	public static void importar(String caminhoSt) {
		

		final String csvFile = caminhoSt + "centrocusto.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<CentroCusto> daoGeneric = new DAOGeneric<CentroCusto>();
		 CentroCusto centroCusto = new CentroCusto();
		 UnidadeOrganizacional unidadeOrganizacional = new UnidadeOrganizacional();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] centroCustoStr = linha.split(separa);
				
				
				if (!centroCustoStr[0].isEmpty()) {
					Integer id = Integer.valueOf(centroCustoStr[0]);
					centroCusto.setId(id);
				}
				
				if (!centroCustoStr[1].isEmpty()) {
					centroCusto.setCodigo(centroCustoStr[1]);
				}
				
				if (!centroCustoStr[2].isEmpty()) {
					centroCusto.setDescricao(centroCustoStr[2]);
				}
				
				if (!centroCustoStr[3].isEmpty()) {
					Integer uoInt = Integer.valueOf(centroCustoStr[3]);
					unidadeOrganizacional.setId(uoInt);
					centroCusto.setUnidadeOrganizacional(unidadeOrganizacional);
				}
				
				if (!centroCustoStr[4].isEmpty()) {
					if (centroCustoStr[4].equals("Y"))
						centroCusto.setArquivado(YesOrNo.Y);
					if (centroCustoStr[4].equals("N"))
						centroCusto.setArquivado(YesOrNo.N);
				}
				daoGeneric.salvar(centroCusto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}