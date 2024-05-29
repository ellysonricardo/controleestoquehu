package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.TipoProntuario;
import br.ufrj.hucff.controleestoque.modelo.TipoVolume;

public class ImportaTipoProntuario {

	/**
	 * @author ellysonalmeida
	 * @date 07/06/2023
	 * 
	 * 
	 */

	public static void importar(String caminhoSt) {

		final String csvFile = caminhoSt + "tipoprontuario.txt";
		String linha = "";
		final String separa = ";";

		DAOGeneric<TipoProntuario> daoGeneric = new DAOGeneric<TipoProntuario>();
		TipoProntuario tipoProntuario = new TipoProntuario();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] tipoProntuarioStr = linha.split(separa);

				if (!tipoProntuarioStr[0].isEmpty()) {
					Integer id = Integer.valueOf(tipoProntuarioStr[0]);
					tipoProntuario.setId(id);
				}

				if (!tipoProntuarioStr[1].isEmpty()) {
					tipoProntuario.setCodigo(tipoProntuarioStr[1]);
				}

				if (!tipoProntuarioStr[2].isEmpty()) {
					tipoProntuario.setDescricao(tipoProntuarioStr[2]);
				}
				if (!tipoProntuarioStr[6].isEmpty()) {
					tipoProntuario.setPrefix(tipoProntuarioStr[6]);
				}
				if (!tipoProntuarioStr[3].isEmpty()) {
					tipoProntuario.setSuffix(tipoProntuarioStr[3]);
				}
				if (!tipoProntuarioStr[4].isEmpty()) {
					Integer tamanhoInt = Integer.valueOf(tipoProntuarioStr[4]);
					tipoProntuario.setTamanho(tamanhoInt);
				}
				if (!tipoProntuarioStr[5].isEmpty()) {
					Integer tipoProntuarioInt = Integer.valueOf(tipoProntuarioStr[5]);
					tipoProntuario.setId(tipoProntuarioInt);
				}

				if (!tipoProntuarioStr[7].isEmpty()) {
					if (tipoProntuarioStr[7].equals("E"))
						tipoProntuario.setTipoVolume(TipoVolume.E);
					if (tipoProntuarioStr[7].equals("U"))
						tipoProntuario.setTipoVolume(TipoVolume.U);
				}

				daoGeneric.salvar(tipoProntuario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}