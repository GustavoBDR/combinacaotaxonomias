package br.com.combinacaotaxonomias.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.CombinacaoDao;
import br.com.combinacaotaxonomias.model.Combinacao;

@Service("combinacaoService")
public class CombinacaoServiceImp implements CombinacaoService{

	@Resource 
	private CombinacaoDao combinacaoDao;
	
	@Override
	public void inserirCombinacao(Combinacao combinacao) {
		combinacaoDao.inserirCombinacao(combinacao);
	}

	@Override
	public Integer buscaUltimaCombinacaoCadastrada() {
		// TODO Auto-generated method stub
		return null;
	}

}
