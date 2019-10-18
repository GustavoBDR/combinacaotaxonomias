package br.com.combinacaotaxonomias.model;

public class CombinacaoAtributo {
	private Integer idMarketplace;
	private Integer idVendedor;
	private Integer idAtributoMarketplace;
	private Integer idAtributoVendedor;
	
	public CombinacaoAtributo(){
		
	}
	
	public CombinacaoAtributo(Integer idMarketplace, Integer idVendedor, Integer idAtributoMarketplace,
			Integer idAtributoVendedor) {
		super();
		this.idMarketplace = idMarketplace;
		this.idVendedor = idVendedor;
		this.idAtributoMarketplace = idAtributoMarketplace;
		this.idAtributoVendedor = idAtributoVendedor;
	}
	
	public Integer getIdMarketplace() {
		return idMarketplace;
	}
	public void setIdMarketplace(Integer idMarketplace) {
		this.idMarketplace = idMarketplace;
	}
	public Integer getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}
	public Integer getIdAtributoMarketplace() {
		return idAtributoMarketplace;
	}
	public void setIdAtributoMarketplace(Integer idAtributoMarketplace) {
		this.idAtributoMarketplace = idAtributoMarketplace;
	}
	public Integer getIdAtributoVendedor() {
		return idAtributoVendedor;
	}
	public void setIdAtributoVendedor(Integer idAtributoVendedor) {
		this.idAtributoVendedor = idAtributoVendedor;
	}
	
	
}
