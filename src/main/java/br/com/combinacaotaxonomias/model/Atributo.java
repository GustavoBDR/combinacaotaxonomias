package br.com.combinacaotaxonomias.model;

import br.com.combinacaotaxonomias.common.TipoAtributo;

public class Atributo extends Taxonomia{
	
	private Integer categoriaId;
	private TipoAtributo tipoAtributo;

	public Atributo(Integer id, String nome, Integer categoriaId, TipoAtributo tipoAtributo) {
		super(id, nome);
		this.categoriaId = categoriaId;
		this.tipoAtributo = tipoAtributo;
	}

	public Atributo(Integer id, String nome) {
		super(id, nome);
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public TipoAtributo getTipoAtributo() {
		return tipoAtributo;
	}

	public void setTipoAtributo(TipoAtributo tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}
	
}
