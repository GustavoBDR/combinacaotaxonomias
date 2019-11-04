package br.com.combinacaotaxonomias.model;

import java.util.List;

public class CombinacaoTaxonomia {
	private Long idCombinacao;
	private String nome;
	private String descricao;
	private Long idMarketplace;
	private Long idVendedor;
	private Integer idLinhaMarketplace;
	private String nomeLinhaMarketplace;
	private Integer idFamiliaMarketplace;
	private String nomeFamiliaMarketplace;
	private Integer idGrupoMarketplace;
	private String nomeGrupoMarktetplace;
	private Integer idLinhaVendedor;
	private String nomeLinhaVendedor;
	private Integer idFamiliaVendedor;
	private String nomeFamiliaVendedor;
	private Integer idGrupoVendedor;
	private String nomeGrupoVendedor;
	private List<CombinacaoAtributo> atributos;
	
	public Long getIdCombinacao() {
		return idCombinacao;
	}
	public void setIdCombinacao(Long idCombinacao) {
		this.idCombinacao = idCombinacao;
	}
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
	public Long getIdMarketplace() {
		return idMarketplace;
	}
	public void setIdMarketplace(Long idMarketplace) {
		this.idMarketplace = idMarketplace;
	}
	public Long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
	public Integer getIdLinhaMarketplace() {
		return idLinhaMarketplace;
	}
	public void setIdLinhaMarketplace(Integer idLinhaMarketplace) {
		this.idLinhaMarketplace = idLinhaMarketplace;
	}
	public String getNomeLinhaMarketplace() {
		return nomeLinhaMarketplace;
	}
	public void setNomeLinhaMarketplace(String nomeLinhaMarketplace) {
		this.nomeLinhaMarketplace = nomeLinhaMarketplace;
	}
	public Integer getIdFamiliaMarketplace() {
		return idFamiliaMarketplace;
	}
	public void setIdFamiliaMarketplace(Integer idFamiliaMarketplace) {
		this.idFamiliaMarketplace = idFamiliaMarketplace;
	}
	public String getNomeFamiliaMarketplace() {
		return nomeFamiliaMarketplace;
	}
	public void setNomeFamiliaMarketplace(String nomeFamiliaMarketplace) {
		this.nomeFamiliaMarketplace = nomeFamiliaMarketplace;
	}
	public Integer getIdGrupoMarketplace() {
		return idGrupoMarketplace;
	}
	public void setIdGrupoMarketplace(Integer idGrupoMarketplace) {
		this.idGrupoMarketplace = idGrupoMarketplace;
	}
	public String getNomeGrupoMarktetplace() {
		return nomeGrupoMarktetplace;
	}
	public void setNomeGrupoMarktetplace(String nomeGrupoMarktetplace) {
		this.nomeGrupoMarktetplace = nomeGrupoMarktetplace;
	}
	public Integer getIdLinhaVendedor() {
		return idLinhaVendedor;
	}
	public void setIdLinhaVendedor(Integer idLinhaVendedor) {
		this.idLinhaVendedor = idLinhaVendedor;
	}
	public String getNomeLinhaVendedor() {
		return nomeLinhaVendedor;
	}
	public void setNomeLinhaVendedor(String nomeLinhaVendedor) {
		this.nomeLinhaVendedor = nomeLinhaVendedor;
	}
	public Integer getIdFamiliaVendedor() {
		return idFamiliaVendedor;
	}
	public void setIdFamiliaVendedor(Integer idFamiliaVendedor) {
		this.idFamiliaVendedor = idFamiliaVendedor;
	}
	public String getNomeFamiliaVendedor() {
		return nomeFamiliaVendedor;
	}
	public void setNomeFamiliaVendedor(String nomeFamiliaVendedor) {
		this.nomeFamiliaVendedor = nomeFamiliaVendedor;
	}
	public Integer getIdGrupoVendedor() {
		return idGrupoVendedor;
	}
	public void setIdGrupoVendedor(Integer idGrupoVendedor) {
		this.idGrupoVendedor = idGrupoVendedor;
	}
	public String getNomeGrupoVendedor() {
		return nomeGrupoVendedor;
	}
	public void setNomeGrupoVendedor(String nomeGrupoVendedor) {
		this.nomeGrupoVendedor = nomeGrupoVendedor;
	}
	public List<CombinacaoAtributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<CombinacaoAtributo> atributos) {
		this.atributos = atributos;
	}	
}
