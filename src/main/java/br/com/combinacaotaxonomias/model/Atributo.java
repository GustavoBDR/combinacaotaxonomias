package br.com.combinacaotaxonomias.model;

import br.com.combinacaotaxonomias.common.TipoAtributo;

public class Atributo extends Base{
	private TipoAtributo tipoatributo;

	public TipoAtributo getTipoatributo() {
		return tipoatributo;
	}

	public void setTipoatributo(TipoAtributo tipoatributo) {
		this.tipoatributo = tipoatributo;
	}
}
