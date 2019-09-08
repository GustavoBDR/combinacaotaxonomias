package br.com.combinacaotaxonomias.model;

public class Plataforma {
	private Long id;
	private String nome;
	private String urlAPIGetCategorias;
	private String urlAPIGetAtributos;
	
	public Plataforma() {
		
	}
	
	public Plataforma(Long id, String nome, String urlAPIGetCategorias, String urlAPIGetAtributos) {
		this.id = id;
		this.nome = nome;
		this.urlAPIGetCategorias = urlAPIGetCategorias;
		this.urlAPIGetAtributos = urlAPIGetAtributos;
	}
	
	public Plataforma(String nome, String urlAPIGetCategorias, String urlAPIGetAtributos) {
		this.nome = nome;
		this.urlAPIGetCategorias = urlAPIGetCategorias;
		this.urlAPIGetAtributos = urlAPIGetAtributos;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlAPIGetCategorias() {
		return urlAPIGetCategorias;
	}
	public void setUrlAPIGetCategorias(String urlAPIGetCategorias) {
		this.urlAPIGetCategorias = urlAPIGetCategorias;
	}
	public String getUrlAPIGetAtributos() {
		return urlAPIGetAtributos;
	}
	public void setUrlAPIGetAtributos(String urlAPIGetAtributos) {
		this.urlAPIGetAtributos = urlAPIGetAtributos;
	}
	
	public boolean isEmpty() {
		if (this.id == null && this.nome == null && this.urlAPIGetCategorias == null && this.urlAPIGetAtributos == null ) {
			return true;
		}
		return false;
	}
}
