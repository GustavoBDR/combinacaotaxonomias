package br.com.combinacaotaxonomias.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Taxonomia {
    private Integer id;
    private String nome;
	
    private List<Taxonomia> filhoTaxonomia = new ArrayList<Taxonomia>();
    
	
    public Taxonomia(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.filhoTaxonomia = new ArrayList<Taxonomia>();
	}

	public void addTaxonomia(Taxonomia taxonomia) {
    	filhoTaxonomia.add(taxonomia);
    }
 
    public void removeTaxonomia(Taxonomia taxonomia) {
    	filhoTaxonomia.remove(taxonomia);
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

	public List<Taxonomia> getFilhosTaxonomia() {
		return filhoTaxonomia;
	}
	
	public Taxonomia getFilhoTaxonomia(Integer index) {
		return filhoTaxonomia.get(index);
	}

	public void setFilhoTaxonomia(List<Taxonomia> filhoTaxonomia) {
		this.filhoTaxonomia = filhoTaxonomia;
	}
}
