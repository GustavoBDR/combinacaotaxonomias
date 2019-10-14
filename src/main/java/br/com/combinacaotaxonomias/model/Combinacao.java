package br.com.combinacaotaxonomias.model;

public class Combinacao extends Taxonomia{

	private String descricao;
	
	public Combinacao(Integer id, String nome) {
		super(id, nome);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
