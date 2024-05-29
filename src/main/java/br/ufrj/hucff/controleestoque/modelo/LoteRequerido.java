package br.ufrj.hucff.controleestoque.modelo;

public enum LoteRequerido {
	
	R("Requerido"), O("Opcional"), N("Nao_Requerido");

	private final String sigla;
	
	public String getSigla() {
		return sigla;
	}

	LoteRequerido(String sigla) {
		this.sigla = sigla;
	}

}
