package br.com.combinacaotaxonomias.model.to;

import br.com.combinacaotaxonomias.common.TipoAtributo;

public class AtributoTO {
	private String idAtributo;
	private String idPlataforma;
	private String nome;
	private String categoriaId;
	private String tipoAtributo;

	public AtributoTO(){
		
	}

	public String getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(String idAtributo) {
		this.idAtributo = idAtributo;
	}

	public String getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(String idPlataforma) {
		this.idPlataforma = idPlataforma;
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
