package br.ufrj.hucff.controleestoque.modelo;

public enum LocalInternacao {
	D("Does_Not_Matter"), W("Warning"), N("Not_Allowed");
	
	private final String sigra;

	public String getSigra() {
		return sigra;
	}

	private LocalInternacao(String sigra) {
		this.sigra = sigra;
	}
}
