package br.ufrj.hucff.controleestoque.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.CadastroLocal;
import br.ufrj.hucff.controleestoque.modelo.CentroCusto;
import br.ufrj.hucff.controleestoque.modelo.GrupoLocal;
import br.ufrj.hucff.controleestoque.modelo.Hospital;
import br.ufrj.hucff.controleestoque.modelo.LocalInternacao;
import br.ufrj.hucff.controleestoque.modelo.TipoLocal;
import br.ufrj.hucff.controleestoque.modelo.TipoProntuario;
import br.ufrj.hucff.controleestoque.modelo.YesOrNo;

public class ImportaCadastroLocal {

	/**
	 * @author ellysonalmeida
	 * @throws ParseException 
	 * @date 26/05/2023
	 *    
	 */

	public static void importar(String caminhoSt) throws ParseException {
		

		final String csvFile = caminhoSt + "cadastrolocal.txt";
		String linha = "";
		final String separa = ";";
				
		DAOGeneric<CadastroLocal> daoGeneric = new DAOGeneric<CadastroLocal>();
		CadastroLocal cadastroLocal = new CadastroLocal();
		CentroCusto centroCusto = new CentroCusto();
		GrupoLocal grupoLocal = new GrupoLocal();
		Hospital hospital = new Hospital();
		TipoProntuario tipoProntuario = new TipoProntuario();
		SimpleDateFormat dataFormata = new SimpleDateFormat("dd/MM/yyyy");

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((linha = br.readLine()) != null) {

				String[] cadastroLocalStr = linha.split(separa);
				
				
				if (!cadastroLocalStr[0].isEmpty()) {
					Integer id = Integer.valueOf(cadastroLocalStr[0]);
					cadastroLocal.setId(id);
				}
				
				if (!cadastroLocalStr[1].isEmpty()) {
					cadastroLocal.setCodigo(cadastroLocalStr[1]);
				}
				
				if (!cadastroLocalStr[2].isEmpty()) {
					cadastroLocal.setDescricao(cadastroLocalStr[2]);
				}
				
				if (!cadastroLocalStr[3].equals("")) {
					Integer centroCustoInt = Integer.valueOf(cadastroLocalStr[3]);
					centroCusto.setId(centroCustoInt);
					cadastroLocal.setCentroCusto(centroCusto);
				}
				
				if (!cadastroLocalStr[4].isEmpty()) {
					if (cadastroLocalStr[4].equals("Y"))
						cadastroLocal.setPostoInternacao(YesOrNo.Y);
					if (cadastroLocalStr[4].equals("N"))
						cadastroLocal.setPostoInternacao(YesOrNo.N);
				}
				
				if (!cadastroLocalStr[5].isEmpty()) {
					if(cadastroLocalStr[5].equals("W"))
						cadastroLocal.setTipoLocal(TipoLocal.W);
					if(cadastroLocalStr[5].equals("E"))
						cadastroLocal.setTipoLocal(TipoLocal.E);
					if(cadastroLocalStr[5].equals("DI"))
						cadastroLocal.setTipoLocal(TipoLocal.DI);
					if(cadastroLocalStr[5].equals("D"))
						cadastroLocal.setTipoLocal(TipoLocal.D);
					if(cadastroLocalStr[5].equals("C"))
						cadastroLocal.setTipoLocal(TipoLocal.C);
					if(cadastroLocalStr[5].equals("O"))
						cadastroLocal.setTipoLocal(TipoLocal.O);
					if(cadastroLocalStr[5].equals("OP"))
						cadastroLocal.setTipoLocal(TipoLocal.OP);
					if(cadastroLocalStr[5].equals("EM"))
						cadastroLocal.setTipoLocal(TipoLocal.EM);
					if(cadastroLocalStr[5].equals("DS"))
						cadastroLocal.setTipoLocal(TipoLocal.DS);
					if(cadastroLocalStr[5].equals("MR"))
						cadastroLocal.setTipoLocal(TipoLocal.MR);
					if(cadastroLocalStr[5].equals("OR"))
						cadastroLocal.setTipoLocal(TipoLocal.OR);
				}
				
				if (!cadastroLocalStr[6].isEmpty()) {
					cadastroLocal.setAndar(cadastroLocalStr[6]);
				}
				
				if (!cadastroLocalStr[7].isEmpty()) {
					Integer grupoLocalInt = Integer.valueOf(cadastroLocalStr[7]);
					grupoLocal.setId(grupoLocalInt);
					cadastroLocal.setGrupoLocal(grupoLocal);
				}
				
				if (!cadastroLocalStr[8].isEmpty()) {
					if(cadastroLocalStr[8].equals("D"))
						cadastroLocal.setLocalInternacao(LocalInternacao.D);
					if(cadastroLocalStr[8].equals("W"))
						cadastroLocal.setLocalInternacao(LocalInternacao.W);
					if(cadastroLocalStr[8].equals("N"))
						cadastroLocal.setLocalInternacao(LocalInternacao.N);
				}
				
				if (!cadastroLocalStr[9].isEmpty()) {
					if (cadastroLocalStr[9].equals("Y"))
						cadastroLocal.setIndexLocal(YesOrNo.Y);
					if (cadastroLocalStr[9].equals("N"))
						cadastroLocal.setIndexLocal(YesOrNo.N);
				}
				
				if (!cadastroLocalStr[10].equals("")) {
					Integer hospitalInt = Integer.valueOf(cadastroLocalStr[10]);
					hospital.setId(hospitalInt);
					cadastroLocal.setHospital(hospital);
				}

				if (!cadastroLocalStr[11].isEmpty()) {
					if (cadastroLocalStr[11].equals("Y"))
						cadastroLocal.setConfirmacaoExecutor(YesOrNo.Y);
					if (cadastroLocalStr[11].equals("N"))
						cadastroLocal.setConfirmacaoExecutor(YesOrNo.N);
				}
				
				if (!cadastroLocalStr[12].isEmpty()) {
					Date dataInicioData = dataFormata.parse(cadastroLocalStr[12]);
					cadastroLocal.setDataInicio(dataInicioData);
				}
				
				if (!cadastroLocalStr[13].isEmpty()) {
					Date dataFinalData = dataFormata.parse(cadastroLocalStr[13]);
					cadastroLocal.setDataFinal(dataFinalData);
				}
				
				if (!cadastroLocalStr[14].isEmpty()) {
					if (cadastroLocalStr[14].equals("Y"))
						cadastroLocal.setLocalReabilitacao(YesOrNo.Y);
					if (cadastroLocalStr[14].equals("N"))
						cadastroLocal.setLocalReabilitacao(YesOrNo.N);
				}
			
				if (!cadastroLocalStr[15].isEmpty()) {
					if (cadastroLocalStr[15].equals("Y"))
						cadastroLocal.setGeraNumeroProntuario(YesOrNo.Y);
					if (cadastroLocalStr[15].equals("N"))
						cadastroLocal.setGeraNumeroProntuario(YesOrNo.N);
				}
				
				if (!cadastroLocalStr[16].isEmpty()) {
					Integer tipoProntuarioInt = Integer.valueOf(cadastroLocalStr[16]);
					tipoProntuario.setId(tipoProntuarioInt);
					cadastroLocal.setTipoProntuario(tipoProntuario);
				}
				
				if (!cadastroLocalStr[17].isEmpty()) {
					if (cadastroLocalStr[17].equals("Y"))
						cadastroLocal.setLocalColeta(YesOrNo.Y);
					if (cadastroLocalStr[17].equals("N"))
						cadastroLocal.setLocalColeta(YesOrNo.N);
				}
				
				daoGeneric.salvar(cadastroLocal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}