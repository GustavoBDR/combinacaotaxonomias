package br.com.combinacaotaxonomias.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.common.NivelHierarquia;
import br.com.combinacaotaxonomias.dao.MarketplaceDao;
import br.com.combinacaotaxonomias.model.Base;
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
		
		inserirCategorias(categorias);
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
	
	
	public void inserirCategorias(List<Categoria> categorias) {
		for (Categoria categoria : categorias) {
			for (int i = 0; i < NivelHierarquia.NIVEL_MAXIMO; i++) {
				Base linha = categoria;
				Base familia = categoria.getFilho(0);
				
				//Base grupo = familia.getFilho(0);
			}
		}
	}
	
	public List<Categoria> extrairCategorias(List<CategoriaResponse> categoriasResponse) {
		
		List<Categoria> categoriasExtraidas = new ArrayList<Categoria>();
		
		
		for (CategoriaResponse categoriaResponse : categoriasResponse) {
			
			Categoria categoriaLinha = new Categoria(new Long(categoriaResponse.getLineId()),categoriaResponse.getLineName());
			Categoria categoriaFamilia = new Categoria(new Long(categoriaResponse.getFamilyId()),categoriaResponse.getFamilyName());
			Categoria categoriaGrupo = new Categoria(new Long(categoriaResponse.getGroupId()),categoriaResponse.getGroupName());
			
			categoriaFamilia.add(categoriaGrupo);
			categoriaLinha.add(categoriaFamilia);
			
			categoriasExtraidas.add(categoriaLinha);
		}
		
		return categoriasExtraidas;
	}
}



