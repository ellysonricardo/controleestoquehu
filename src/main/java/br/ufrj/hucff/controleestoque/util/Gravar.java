package br.ufrj.hucff.controleestoque.util;

import java.text.ParseException;

public class Gravar {

	public static final String CAMINHOSTR = System.getProperty("user.dir")+ "\\controleestoquearquivos\\";

	public static void main(String[] args) throws ParseException {
		

		ImportaUnidadeOrganizacional.importar(CAMINHOSTR);
		ImportaHospital.importar(CAMINHOSTR);
		ImportaGrupoLocal.importar(CAMINHOSTR);
		ImportaCentroCusto.importar(CAMINHOSTR);
		ImportaCadastroLocal.importar(CAMINHOSTR);
		ImportaNatureza.importar(CAMINHOSTR);
		ImportaTipoProntuario.importar(CAMINHOSTR);
		ImportaUnidadeDispensacao.importar(CAMINHOSTR);
		ImportaCategoria.importar(CAMINHOSTR);
		ImportaUnidadeDispensacao.importar(CAMINHOSTR);
		ImportaFornecedor.importar(CAMINHOSTR);
		ImportaCategoriaEsterilizacao.importar(CAMINHOSTR);
		ImportaGrupoInventario.importar(CAMINHOSTR);
		ImportaNatureza.importar(CAMINHOSTR);
		ImportaTipoCompra.importar(CAMINHOSTR);
		ImportaItemPedido.importar(CAMINHOSTR);
		ImportaItemEstoque.importar(CAMINHOSTR);
		

	}
}