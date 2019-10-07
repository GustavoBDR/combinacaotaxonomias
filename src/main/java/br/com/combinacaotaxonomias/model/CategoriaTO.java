package br.com.combinacaotaxonomias.model;

public class CategoriaTO {

    private Integer id;
    private String nome;
	private Integer idPai;
	private Integer idMarketplace;

	public CategoriaTO(Integer id, String nome, Integer idPai, Integer idMarketplace) {
		this.id = id;
		this.nome = nome;
		this.idPai = idPai;
		this.idMarketplace = idMarketplace;
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
	public Integer getIdPai() {
		return idPai;
	}
	public void setIdPai(Integer idPai) {
		this.idPai = idPai;
	}
	public Integer getIdMarketplace() {
		return idMarketplace;
	}
	public void setIdMarketplace(Integer idMarketplace) {
		this.idMarketplace = idMarketplace;
	}
	
}
