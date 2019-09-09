package br.com.combinacaotaxonomias.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.MarketplaceDao;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
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
		
		List<CategoriaResponse> categoriasResponse = consumoApiService.getCategorias(marketplace);
		List<Categoria> categorias = extrairCategorias(categoriasResponse);
		
		Integer idMarketplace = marketplaceDao.getUltimoIdMarketplace();
		
		inserirCategorias(categorias, idMarketplace);
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
	
	
	public void inserirCategorias(List<Categoria> categorias, Integer idMarketplace) {
		for (Categoria categoria : categorias) {
			Taxonomia linha = categoria;
			Taxonomia familia = categoria.getFilhoTaxonomia(0);
			Taxonomia grupo = familia.getFilhoTaxonomia(0);
			marketplaceDao.inserirCategoria(linha, null, idMarketplace);
			marketplaceDao.inserirCategoria(familia, linha.getId(), idMarketplace);
			marketplaceDao.inserirCategoria(grupo, familia.getId(), idMarketplace);
		}
	}
	
	public List<Categoria> extrairCategorias(List<CategoriaResponse> categoriasResponse) {
		
		List<Categoria> categoriasExtraidas = new ArrayList<Categoria>();
		
		
		for (CategoriaResponse categoriaResponse : categoriasResponse) {
			
			Categoria categoriaLinha = new Categoria(categoriaResponse.getLineId(),categoriaResponse.getLineName());
			Categoria categoriaFamilia = new Categoria(categoriaResponse.getFamilyId(),categoriaResponse.getFamilyName());
			Categoria categoriaGrupo = new Categoria(categoriaResponse.getGroupId(),categoriaResponse.getGroupName());
			
			categoriaFamilia.addTaxonomia(categoriaGrupo);
			categoriaLinha.addTaxonomia(categoriaFamilia);
			
			categoriasExtraidas.add(categoriaLinha);
		}
		
		return categoriasExtraidas;
	}
}



