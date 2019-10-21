package br.com.combinacaotaxonomias.model.to;

public class CombinacaoAtributoTO {
	private String idAtributoMarketplace;
	private String idAtributoVendedor;	
	
	public CombinacaoAtributoTO(String idAtributoMarketplace, String idAtributoVendedor) {
		this.idAtributoMarketplace = idAtributoMarketplace;
		this.idAtributoVendedor = idAtributoVendedor;
	}
	
	public CombinacaoAtributoTO() {

	}	
	
	public String getIdAtributoMarketplace() {
		return idAtributoMarketplace;
	}
	public void setIdAtributoMarketplace(String idAtributoMarketplace) {
		this.idAtributoMarketplace = idAtributoMarketplace;
	}
	public String getIdAtributoVendedor() {
		return idAtributoVendedor;
	}
	public void setIdAtributoVendedor(String idAtributoVendedor) {
		this.idAtributoVendedor = idAtributoVendedor;
	}
		
}
