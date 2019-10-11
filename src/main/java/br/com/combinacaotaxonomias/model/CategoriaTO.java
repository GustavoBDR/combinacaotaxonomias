package br.com.combinacaotaxonomias.model;

public class CategoriaTO {

    private Integer idCategoria;
    private String nome;
	private Integer idPai;
	private Integer idPlataforma;

	public CategoriaTO() {

	}	
	
	public CategoriaTO(Integer idCategoria, String nome, Integer idPai, Integer idPlataforma) {
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.idPai = idPai;
		this.idPlataforma = idPlataforma;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdPai() {
		return idPai;
	}
	public void setIdPai(Integer idPai) {
		this.idPai = idPai;
	}
	public Integer getIdPlataforma() {
		return idPlataforma;
	}
	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}
	
}
