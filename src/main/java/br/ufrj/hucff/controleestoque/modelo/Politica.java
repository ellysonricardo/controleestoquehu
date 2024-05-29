package br.ufrj.hucff.controleestoque.modelo;

public enum Politica {
	
	P("Registo"),S("Gerado_pelo_Sistema"),MO("Alocado_Manualmente"),MR("Gerado"),GO("Escritorio");
	
	private final String sigra;

	public String getSigra() {
		return sigra;
	}

	private Politica(String sigra) {
		this.sigra = sigra;
	}
}
