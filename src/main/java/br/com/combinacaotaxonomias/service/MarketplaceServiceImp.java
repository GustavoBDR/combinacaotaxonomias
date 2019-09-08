package br.com.combinacaotaxonomias.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.MarketplaceDao;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Plataforma;

@Service("marketplaceService")
public class MarketplaceServiceImp implements MarketplaceService{

	@Resource 
	private MarketplaceDao marketplaceDao;
	
	@Resource 
	private ConsumoApiService consumoApiService;	
	
	@Override
	public void inserirMarketplace(Plataforma marketplace) {
		marketplaceDao.inserirMarketplace(marketplace);
		
		List<Categoria> categorias = consumoApiService.getCategorias(marketplace.getUrlAPIGetCategorias());
	}

	@Override
	public List<Plataforma> buscaTodosMarketplaces() {
		return marketplaceDao.buscaTodosMarketplaces();
	}

	@Override
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace) {
		return marketplaceDao.buscaMarketplaces(marketplace);
	}

	@Override
	public Plataforma buscaMarketplacePorId(Long id) {
		return marketplaceDao.buscaMarketplacePorId(id);
	}

	@Override
	public boolean isMarketplace(Plataforma marketplace) {
		Plataforma v =  marketplaceDao.buscaMarketplacePorId(marketplace.getId());
		if (v.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void alterarMarketplace(Plataforma marketplace) {
		marketplaceDao.alterarMarketplace(marketplace);		
	}
}
