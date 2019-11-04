package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.CombinacaoTaxonomia;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTaxonomiaTO;

public interface CombinacaoService {

	public void inserirCombinacao(Combinacao combinacao);
	public void inserirCombinacaoCategoria(Combinacao combinacao);
	public Long buscaUltimaCombinacaoCadastrada();
	public void inserirCombinacaoAtibutos(Long idCombinacao, List<CombinacaoAtributo> listCombinacao);
	public Long buscaUltimaCombinacaoCategoriaCadastrada();
	public List<CombinacaoTO> buscaCombinacao(CombinacaoTO combinacaoTO);
	public Combinacao buscaCombinacaoPorId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoIdCompleto(Long id);
	public boolean isNovaCombinaca(Combinacao novaCombinacao);
	public void updateCombinacao(Combinacao novaCombinacao);
	public void deleteCombinacaoAtributos(Combinacao novaCombinacao);
	public List<Combinacao> buscaCombinacaoPorIdMarketplace(Long idMarketplace);
	public List<Combinacao> buscaCombinacaoPorIdVendedor(Long idVendedor);
	public List<Combinacao> buscaCombinacaoPorIdMarketplaceCompleto(Long idMarketplace);
	public List<CombinacaoTaxonomia> BuscaCombinacoesTaxonomiaPorMarketplace(Long idMarketplace);
}
