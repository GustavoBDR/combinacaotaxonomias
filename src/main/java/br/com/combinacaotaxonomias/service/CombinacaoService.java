package br.com.combinacaotaxonomias.service;

import br.com.combinacaotaxonomias.model.Combinacao;

public interface CombinacaoService {

	public void inserirCombinacao(Combinacao combinacao);

	public Integer buscaUltimaCombinacaoCadastrada();

}
