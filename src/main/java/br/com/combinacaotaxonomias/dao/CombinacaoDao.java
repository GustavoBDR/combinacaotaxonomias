package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public interface CombinacaoDao {
	public void inserirCombinacao(Combinacao combinacao);
	public void inserirCombinacaoCategoria(Combinacao combinacao);
	public Long buscaUltimaCombinacaoCadastrada();
	public void inserirCombinacaoAtributos(Long idCombinacaoCategoria, CombinacaoAtributo combinacaoAtributo);
	public Long buscaUltimaCombinacaoCategoriaCadastrada();
	public List<CombinacaoTO> buscaCombinacao(CombinacaoTO combinacaoTO);
	public CombinacaoTO buscaCombinacaoPorId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoId(Long id);
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoIdCompleto(Long id);
}
