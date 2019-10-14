package br.com.combinacaotaxonomias.model;

import br.com.combinacaotaxonomias.common.TipoAtributo;

public class AtributoTO {
	private Integer id;
	private String nome;
	private Integer categoriaId;
	private String tipoAtributo;

	public AtributoTO(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getTipoAtributo() {
		return tipoAtributo;
	}

	public void setTipoAtributo(String tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}
	
}
