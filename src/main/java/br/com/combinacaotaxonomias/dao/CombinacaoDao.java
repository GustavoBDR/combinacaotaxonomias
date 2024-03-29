package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.CombinacaoTaxonomia;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTaxonomiaTO;

public interface CombinacaoDao {
	public void inserirCombinacao(Combinacao combinacao);
	public void inserirCombinacaoCategoria(Combinacao combinacao);
	public Long buscaUltimaCombinacaoCadastrada();
	public void inserirCombinacaoAtributos(Long idCombinacao, CombinacaoAtributo combinacaoAtributo);
	public Long buscaUltimaCombinacaoCategoriaCadastrada();
	public List<CombinacaoTO> buscaCombinacao(CombinacaoTO combinacaoTO);
	public Combinacao buscaCombinacaoPorId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoIdCompleto(Long id);
	public void updateCombinacao(Combinacao novaCombinacao);
	public void deleteCombinacaoAtributos(Combinacao novaCombinacao);
	public List<Combinacao> buscaCombinacaoPorIdMarketplace(Long idMarketplace);
	public List<Combinacao> buscaCombinacaoPorIdVendedor(Long idVendedor);
	public List<Combinacao> buscaCombinacaoPorIdMarketplaceCompleto(Long idMarketplace);
	public List<CombinacaoTaxonomia> buscaCombinacaoTaxonomiaPorIdMarketplace(Long idMarketplace);
	public List<CombinacaoAtributo> buscaCombinacaoTaxonomiaAtributos(Long idCombinacao);
}
