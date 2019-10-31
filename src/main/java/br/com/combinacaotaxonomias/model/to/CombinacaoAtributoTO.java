package br.com.combinacaotaxonomias.model.to;

public class CombinacaoAtributoTO {
	private String idCombinacao;
	private String idAtributoMarketplace;
	private String nomeAtributoMarketplace;
	private String tipoAtributoMarketplace;
	private String idAtributoVendedor;	
	private String nomeAtributoVendedor;
	private String tipoAtributoVendedor;	
	
	public CombinacaoAtributoTO(String idAtributoMarketplace, String idAtributoVendedor) {
		this.idAtributoMarketplace = idAtributoMarketplace;
		this.idAtributoVendedor = idAtributoVendedor;
	}
	
	public CombinacaoAtributoTO() {

	}

	public String getIdCombinacao() {
		return idCombinacao;
	}

	public void setIdCombinacao(String idCombinacao) {
		this.idCombinacao = idCombinacao;
	}

	public String getIdAtributoMarketplace() {
		return idAtributoMarketplace;
	}

	public void setIdAtributoMarketplace(String idAtributoMarketplace) {
		this.idAtributoMarketplace = idAtributoMarketplace;
	}

	public String getNomeAtributoMarketplace() {
		return nomeAtributoMarketplace;
	}

	public void setNomeAtributoMarketplace(String nomeAtributoMarketplace) {
		this.nomeAtributoMarketplace = nomeAtributoMarketplace;
	}

	public String getTipoAtributoMarketplace() {
		return tipoAtributoMarketplace;
	}

	public void setTipoAtributoMarketplace(String tipoAtributoMarketplace) {
		this.tipoAtributoMarketplace = tipoAtributoMarketplace;
	}

	public String getIdAtributoVendedor() {
		return idAtributoVendedor;
	}

	public void setIdAtributoVendedor(String idAtributoVendedor) {
		this.idAtributoVendedor = idAtributoVendedor;
	}

	public String getNomeAtributoVendedor() {
		return nomeAtributoVendedor;
	}

	public void setNomeAtributoVendedor(String nomeAtributoVendedor) {
		this.nomeAtributoVendedor = nomeAtributoVendedor;
	}

	public String getTipoAtributoVendedor() {
		return tipoAtributoVendedor;
	}

	public void setTipoAtributoVendedor(String tipoAtributoVendedor) {
		this.tipoAtributoVendedor = tipoAtributoVendedor;
	}

}
