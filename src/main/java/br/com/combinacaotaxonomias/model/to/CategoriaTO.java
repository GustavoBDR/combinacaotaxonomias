package br.com.combinacaotaxonomias.model.to;

public class CategoriaTO {

    private String idCategoria;
    private String nome;
	private String idPai;
	private String idPlataforma;

	public CategoriaTO() {

	}	
	
	public CategoriaTO(String idCategoria, String nome, String idPai, String idPlataforma) {
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.idPai = idPai;
		this.idPlataforma = idPlataforma;
	}
	
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdPai() {
		return idPai;
	}
	public void setIdPai(String idPai) {
		this.idPai = idPai;
	}
	public String getIdPlataforma() {
		return idPlataforma;
	}
	public void setIdPlataforma(String idPlataforma) {
		this.idPlataforma = idPlataforma;
	}
	
}
