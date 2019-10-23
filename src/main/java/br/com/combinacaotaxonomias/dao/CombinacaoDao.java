package br.com.combinacaotaxonomias.dao;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;

public interface CombinacaoDao {
	public void inserirCombinacao(Combinacao combinacao);
	public void inserirCombinacaoCategoria(Combinacao combinacao);
	public Long buscaUltimaCombinacaoCadastrada();
	public void inserirCombinacaoAtributos(Long idCombinacaoCategoria, CombinacaoAtributo combinacaoAtributo);
}
