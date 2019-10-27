package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public interface CombinacaoService {

	public void inserirCombinacao(Combinacao combinacao);
	public void inserirCombinacaoCategoria(Combinacao combinacao);
	public Long buscaUltimaCombinacaoCadastrada();
	public void inserirCombinacaoAtibutos(Long idCombinacaoCategoria, List<CombinacaoAtributo> listCombinacao);
	public Long buscaUltimaCombinacaoCategoriaCadastrada();
	public List<CombinacaoTO> buscaCombinacao(CombinacaoTO combinacaoTO);
	public CombinacaoTO buscaCombinacaoPorId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoIdCompleto(Long id);
}
