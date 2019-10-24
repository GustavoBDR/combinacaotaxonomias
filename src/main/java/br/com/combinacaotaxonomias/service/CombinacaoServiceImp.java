package br.com.combinacaotaxonomias.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.CombinacaoDao;
import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;

@Service("combinacaoService")
public class CombinacaoServiceImp implements CombinacaoService{

	@Resource 
	private CombinacaoDao combinacaoDao;
	
	@Override
	public void inserirCombinacao(Combinacao combinacao) {
		combinacaoDao.inserirCombinacao(combinacao);
		combinacao.setId(buscaUltimaCombinacaoCadastrada());
		inserirCombinacaoCategoria(combinacao);
	}

	@Override
	public void inserirCombinacaoCategoria(Combinacao combinacao) {
		combinacaoDao.inserirCombinacaoCategoria(combinacao);
	}	
	
	@Override
	public Long buscaUltimaCombinacaoCadastrada() {
		return combinacaoDao.buscaUltimaCombinacaoCadastrada();
	}

	@Override
	public void inserirCombinacaoAtibutos(Long idCombinacaoCategoria, List<CombinacaoAtributo> listCombinacao) {
		for (CombinacaoAtributo combinacaoAtributo : listCombinacao) {
			combinacaoDao.inserirCombinacaoAtributos(idCombinacaoCategoria, combinacaoAtributo);	
		}
	}

	@Override
	public Long buscaUltimaCombinacaoCategoriaCadastrada() {
		return combinacaoDao.buscaUltimaCombinacaoCategoriaCadastrada();
	}

	
}
