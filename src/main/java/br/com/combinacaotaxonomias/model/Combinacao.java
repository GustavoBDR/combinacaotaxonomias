package br.com.combinacaotaxonomias.model;

public class Combinacao {
	private String nome;
	private String descricao;
	private Plataforma marketplace;
	private Plataforma vendedor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Plataforma getMarketplace() {
		return marketplace;
	}
	public void setMarketplace(Plataforma marketplace) {
		this.marketplace = marketplace;
	}
	public Plataforma getVendedor() {
		return vendedor;
	}
	public void setVendedor(Plataforma vendedor) {
		this.vendedor = vendedor;
	}
}
