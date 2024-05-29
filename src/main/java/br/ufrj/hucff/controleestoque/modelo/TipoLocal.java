package br.ufrj.hucff.controleestoque.modelo;

public enum TipoLocal {

	W("Posto"), E("Executavel"), DI("Injetaveis"), D("Farmacia"), C("Caixa"), O("Outros"), OP("CentroCirurgico"), EM("Emergência"), DS("HospitalDia"), MR("SDM"), OR("Consultório");
	
	private final String sigla;


	public String getSigla() {
		return sigla;
	}

	private TipoLocal(String sigla) {
		this.sigla = sigla;
	}
}
