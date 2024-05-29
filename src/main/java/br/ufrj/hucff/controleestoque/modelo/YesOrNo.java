package br.ufrj.hucff.controleestoque.modelo;

public enum YesOrNo {
	Y("Yes"), N("No");

	private final String sigra;

	public String getSigra() {
		return sigra;
	}

	private YesOrNo(String sigra) {
		this.sigra = sigra;
	}
}
