package br.com.combinacaotaxonomias.dao;

import br.com.combinacaotaxonomias.model.Combinacao;

public interface CombinacaoDao {
	public void inserirCombinacao(Combinacao combinacao);
	public void inserirCombinacaoCategoria(Combinacao combinacao);
	public Long buscaUltimaCombinacaoCadastrada();
}
