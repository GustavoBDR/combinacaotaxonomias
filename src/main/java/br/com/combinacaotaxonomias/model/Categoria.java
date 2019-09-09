package br.com.combinacaotaxonomias.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria extends Base{

	private List<Base> filho = new ArrayList<Base>();
	
	public Categoria(Long lineId, String lineName) {
		super(lineId,lineName);
	}
	public void add(Base base) {
		filho.add(base);
	}
	public void remove(Base base) {
		filho.remove(base);
	}
	public List<Base> getFilhos() {
		return filho;
	}
	public void setFilho(List<Base> filho) {
		this.filho = filho;
	}	
	public Base getFilho(Integer index) {
		return filho.get(index);
	}	
}
