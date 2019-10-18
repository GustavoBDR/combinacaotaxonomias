package br.com.combinacaotaxonomias.model.to;

import br.com.combinacaotaxonomias.common.TipoAtributo;

public class AtributoTO {
	private String id;
	private String nome;
	private String categoriaId;
	private String tipoAtributo;

	public AtributoTO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(String categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getTipoAtributo() {
		return tipoAtributo;
	}

	public void setTipoAtributo(String tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}
	
}
