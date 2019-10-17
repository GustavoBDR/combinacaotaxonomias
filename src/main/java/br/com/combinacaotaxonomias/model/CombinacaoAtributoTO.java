package br.com.combinacaotaxonomias.model;

public class CombinacaoAtributoTO {
	private String idMarketplace;
	private String idVendedor;
	private String idAtributoMarketplace;
	private String idAtributoVendedor;	
	
	public CombinacaoAtributoTO(String idMarketplace, String idVendedor, String idAtributoMarketplace, String idAtributoVendedor) {
		this.idMarketplace = idMarketplace;
		this.idVendedor = idVendedor;
		this.idAtributoMarketplace = idAtributoMarketplace;
		this.idAtributoVendedor = idAtributoVendedor;
	}
	
	public CombinacaoAtributoTO() {

	}	
	
	public CombinacaoAtributoTO(String idMarketplace) {
		this.idMarketplace = idMarketplace;
	}	
	
	public CombinacaoAtributoTO(String idMarketplace, String idVendedor) {
		this.idMarketplace = idMarketplace;
		this.idVendedor = idVendedor;
	}	
	
	
	public String getIdMarketplace() {
		return idMarketplace;
	}
	public void setIdMarketplace(String idMarketplace) {
		this.idMarketplace = idMarketplace;
	}
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
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
