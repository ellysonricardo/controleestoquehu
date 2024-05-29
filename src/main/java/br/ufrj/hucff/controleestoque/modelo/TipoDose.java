package br.ufrj.hucff.controleestoque.modelo;

public enum TipoDose {

O("Uma_Dose"),D("Dose_Diaria"),U("Doce_Unitaria");
	
	private final String sigra;

	public String getSigra() {
		return sigra;
	}

	private TipoDose(String sigra) {
		this.sigra = sigra;
	}
}
