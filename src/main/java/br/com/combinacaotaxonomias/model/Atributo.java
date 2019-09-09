package br.com.combinacaotaxonomias.model;

import br.com.combinacaotaxonomias.common.TipoAtributo;

public class Atributo extends Taxonomia{
	public Atributo(Integer id, String nome) {
		super(id, nome);
	}

	private TipoAtributo tipoatributo;

	public TipoAtributo getTipoatributo() {
		return tipoatributo;
	}

	public void setTipoatributo(TipoAtributo tipoatributo) {
		this.tipoatributo = tipoatributo;
	}
}
