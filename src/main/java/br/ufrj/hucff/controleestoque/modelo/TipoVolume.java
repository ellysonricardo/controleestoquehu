package br.ufrj.hucff.controleestoque.modelo;

public enum TipoVolume {

	E("Baseado_Episodio"), U("Definido_pelo_Usuario");
	
	private final String sigra;

	public String getSigra() {
		return sigra;
	}

	private TipoVolume(String sigra) {
		this.sigra = sigra;
	}
}
