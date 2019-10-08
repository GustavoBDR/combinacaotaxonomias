package br.com.combinacaotaxonomias.model;

public class PlataformaTO {
	private String id;
	private String nome;
	private String urlAPIGetCategorias;
	private String urlAPIGetAtributos;
	private String apiTokenId;
	private String apiTokenKey;
	private String urlApiPostAutenticacao;
	
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
	public String getApiTokenId() {
		return apiTokenId;
	}
	public void setApiTokenId(String apiTokenId) {
		this.apiTokenId = apiTokenId;
	}
	public String getApiTokenKey() {
		return apiTokenKey;
	}
	public void setApiTokenKey(String apiTokenKey) {
		this.apiTokenKey = apiTokenKey;
	}
	public String getUrlApiPostAutenticacao() {
		return urlApiPostAutenticacao;
	}
	public void setUrlApiPostAutenticacao(String urlApiPostAutenticacao) {
		this.urlApiPostAutenticacao = urlApiPostAutenticacao;
	}
	
}
