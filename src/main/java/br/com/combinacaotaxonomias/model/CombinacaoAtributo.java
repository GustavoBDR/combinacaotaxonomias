package br.com.combinacaotaxonomias.model;

public class CombinacaoAtributo {
    private Integer idCombinacao;
    private Integer idMarketplace;    
    private Integer idAtributoMarketplace;
    private String nomeAtributoMarketplace;
    private String tipoAtributoMarketplace;
    private Integer idVendedor;    
    private Integer idAtributoVendedor;
    private String nomeAtributoVendedor;
    private String tipoAtributoVendedor;
	
	public CombinacaoAtributo(){
		
	}

	public CombinacaoAtributo(Integer idCombinacao, Integer idMarketplace, Integer idAtributoMarketplace,
			String nomeAtributoMarketplace, String tipoAtributoMarketplace, Integer idVendedor,
			Integer idAtributoVendedor, String nomeAtributoVendedor, String tipoAtributoVendedor) {

		this.idCombinacao = idCombinacao;
		this.idMarketplace = idMarketplace;
		this.idAtributoMarketplace = idAtributoMarketplace;
		this.nomeAtributoMarketplace = nomeAtributoMarketplace;
		this.tipoAtributoMarketplace = tipoAtributoMarketplace;
		this.idVendedor = idVendedor;
		this.idAtributoVendedor = idAtributoVendedor;
		this.nomeAtributoVendedor = nomeAtributoVendedor;
		this.tipoAtributoVendedor = tipoAtributoVendedor;
	}

	public Integer getIdCombinacao() {
		return idCombinacao;
	}

	public void setIdCombinacao(Integer idCombinacao) {
		this.idCombinacao = idCombinacao;
	}

	public Integer getIdMarketplace() {
		return idMarketplace;
	}

	public void setIdMarketplace(Integer idMarketplace) {
		this.idMarketplace = idMarketplace;
	}

	public Integer getIdAtributoMarketplace() {
		return idAtributoMarketplace;
	}

	public void setIdAtributoMarketplace(Integer idAtributoMarketplace) {
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

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Integer getIdAtributoVendedor() {
		return idAtributoVendedor;
	}

	public void setIdAtributoVendedor(Integer idAtributoVendedor) {
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
