package br.com.combinacaotaxonomias.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.CombinacaoDao;
import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.CombinacaoTaxonomia;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTaxonomiaTO;

@Service("combinacaoService")
public class CombinacaoServiceImp implements CombinacaoService{

	@Resource 
	private CombinacaoDao combinacaoDao;
	
	@Override
	public void inserirCombinacao(Combinacao combinacao) {
		combinacaoDao.inserirCombinacao(combinacao);
		combinacao.setIdCombinacao(buscaUltimaCombinacaoCadastrada());
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
	public void inserirCombinacaoAtibutos(Long idCombinacao, List<CombinacaoAtributo> listCombinacao) {
		for (CombinacaoAtributo combinacaoAtributo : listCombinacao) {
			combinacaoDao.inserirCombinacaoAtributos(idCombinacao, combinacaoAtributo);	
		}
	}

	@Override
	public Long buscaUltimaCombinacaoCategoriaCadastrada() {
		return combinacaoDao.buscaUltimaCombinacaoCategoriaCadastrada();
	}

	@Override
	public List<CombinacaoTO> buscaCombinacao(CombinacaoTO combinacaoTO) {
		return combinacaoDao.buscaCombinacao(combinacaoTO);
	}

	@Override
	public Combinacao buscaCombinacaoPorId(Long id) {
		return combinacaoDao.buscaCombinacaoPorId(id);
	}

	@Override
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoId(Long id) {
		return combinacaoDao.buscaCombinacaoCategoriaPorCombinacaoId(id);
	}

	@Override
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoIdCompleto(Long id) {
		return combinacaoDao.buscaCombinacaoCategoriaPorCombinacaoIdCompleto(id);
	}

	@Override
	public boolean isNovaCombinaca(Combinacao novaCombinacao) {
		Combinacao  combinacaoAntiga = combinacaoDao.buscaCombinacaoCategoriaPorCombinacaoIdCompleto(novaCombinacao.getIdCombinacao());
		
		Integer x = combinacaoAntiga.getIdLinhaMarketplace();
		Integer y = novaCombinacao.getIdLinhaMarketplace();
		
		if (combinacaoAntiga.getNome().equals(combinacaoAntiga.getNome()) || !combinacaoAntiga.getDescricao().equals(novaCombinacao.getDescricao())) {
			if (combinacaoAntiga.getIdLinhaMarketplace().equals(novaCombinacao.getIdLinhaMarketplace())) {
				if (combinacaoAntiga.getIdFamiliaMarketplace().equals(novaCombinacao.getIdFamiliaMarketplace())) {
					if (combinacaoAntiga.getIdGrupoMarketplace().equals(novaCombinacao.getIdGrupoMarketplace())) {
						if (combinacaoAntiga.getIdLinhaVendedor().equals(novaCombinacao.getIdLinhaVendedor())) {
							if (combinacaoAntiga.getIdFamiliaVendedor().equals(novaCombinacao.getIdFamiliaVendedor())) {
								if (combinacaoAntiga.getIdGrupoVendedor().equals(novaCombinacao.getIdGrupoVendedor())) {
									return false;
								}
							}
						}
					}
				}
			}
		} 
		return true;
		
	}

	@Override
	public void updateCombinacao(Combinacao novaCombinacao) {
		combinacaoDao.updateCombinacao(novaCombinacao);
	}

	@Override
	public void deleteCombinacaoAtributos(Combinacao novaCombinacao) {
		combinacaoDao.deleteCombinacaoAtributos(novaCombinacao);	
	}

	@Override
	public List<Combinacao> buscaCombinacaoPorIdMarketplace(Long idMarketplace) {
		return combinacaoDao.buscaCombinacaoPorIdMarketplace(idMarketplace);
	}
	
	@Override	
	public List<Combinacao> buscaCombinacaoPorIdVendedor(Long idVendedor){
		return combinacaoDao.buscaCombinacaoPorIdVendedor(idVendedor);
	}

	@Override
	public List<Combinacao> buscaCombinacaoPorIdMarketplaceCompleto(Long idMarketplace) {
		return combinacaoDao.buscaCombinacaoPorIdMarketplaceCompleto(idMarketplace);
	}

	@Override
	public List<CombinacaoTaxonomia> BuscaCombinacoesTaxonomiaPorMarketplace(Long idMarketplace) {
		List<CombinacaoTaxonomia> combinacoes = combinacaoDao.buscaCombinacaoTaxonomiaPorIdMarketplace(idMarketplace);
		for (CombinacaoTaxonomia combinacao : combinacoes) {
			List<CombinacaoAtributo> atributos = combinacaoDao.buscaCombinacaoTaxonomiaAtributos(combinacao.getIdCombinacao());
			combinacao.setAtributos(atributos);
		}
		
		return combinacoes;
	}
}
