package br.com.combinacaotaxonomias.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.common.TipoAtributo;
import br.com.combinacaotaxonomias.dao.MarketplaceDao;
import br.com.combinacaotaxonomias.helper.CategoriaHelper;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.AtributoResponse;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.CategoriaTO;
import br.com.combinacaotaxonomias.model.Plataforma;

@Service("marketplaceService")
public class MarketplaceServiceImp implements MarketplaceService{

	@Resource 
	private MarketplaceDao marketplaceDao;
	
	@Resource 
	private ConsumoApiService consumoApiService;	
	
	private List<Integer> idCategorias = new ArrayList<Integer>();
	
	private CategoriaHelper categoriaHelper;
	
	@Override
	public void inserirMarketplace(Plataforma marketplace) {
		marketplaceDao.inserirMarketplace(marketplace);
		
		List<CategoriaResponse> categoriasResponse = consumoApiService.getCategorias(marketplace);
		List<Categoria> categorias = extrairCategorias(categoriasResponse);
		
		Integer idMarketplace = marketplaceDao.getUltimoIdMarketplace();
		
		inserirCategorias(categorias, idMarketplace);
		
		for (Integer idCategoria : idCategorias) {	
			List<AtributoResponse> atributosResponse = consumoApiService.getAtributos(marketplace, idCategoria);
			List<Atributo> atributos = extrairAtributos(atributosResponse, idCategoria);
			inserirAtributos(atributos, idMarketplace);
		}
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
		Map<Integer, CategoriaTO> CategoriaMap = new HashMap<Integer,CategoriaTO>();
		
		
		for (Categoria categoria : categorias) {
			Taxonomia linha = categoria;
			Taxonomia familia = categoria.getFilhoTaxonomia(0);
			Taxonomia grupo = familia.getFilhoTaxonomia(0);
			
			if (!CategoriaMap.containsKey(linha.getId())) {
				CategoriaMap.put(linha.getId(), categoriaHelper.toCategoriaTO(linha, null, idMarketplace));
				marketplaceDao.inserirCategoria(linha, null, idMarketplace);
			}
			
			if (!CategoriaMap.containsKey(familia.getId())) {
				CategoriaMap.put(familia.getId(), categoriaHelper.toCategoriaTO(familia, linha.getId(), idMarketplace));
				marketplaceDao.inserirCategoria(familia, linha.getId(), idMarketplace);
			}
			
			if (!CategoriaMap.containsKey(grupo.getId())) {
				CategoriaMap.put(grupo.getId(), categoriaHelper.toCategoriaTO(grupo, familia.getId(), idMarketplace));
				marketplaceDao.inserirCategoria(grupo, familia.getId(), idMarketplace);
			}
		}
	}
	
	public void inserirAtributos(List<Atributo> atributos, Integer idMarketplace) {
		for (Atributo atributo : atributos) {
			marketplaceDao.inserirAtributo(atributo, idMarketplace);
		}
	}
	
	public List<Categoria> extrairCategorias(List<CategoriaResponse> categoriasResponse) {
		
		List<Categoria> categoriasExtraidas = new ArrayList<Categoria>();
		
		
		for (CategoriaResponse categoriaResponse : categoriasResponse) {
			
			Categoria categoriaLinha = new Categoria(categoriaResponse.getLineId(),categoriaResponse.getLineName());
			idCategorias.add(categoriaLinha.getId());
			Categoria categoriaFamilia = new Categoria(categoriaResponse.getFamilyId(),categoriaResponse.getFamilyName());
			idCategorias.add(categoriaFamilia.getId());
			Categoria categoriaGrupo = new Categoria(categoriaResponse.getGroupId(),categoriaResponse.getGroupName());
			idCategorias.add(categoriaGrupo.getId());
			
			categoriaFamilia.addTaxonomia(categoriaGrupo);
			categoriaLinha.addTaxonomia(categoriaFamilia);
			
			categoriasExtraidas.add(categoriaLinha);
		}
		
		return categoriasExtraidas;
	}
	
	public List<Atributo> extrairAtributos(List<AtributoResponse> atributosResponse, Integer idCategoria) {
		
		List<Atributo> atributosExtraidos = new ArrayList<Atributo>();
		
		
		for (AtributoResponse atributoResponse : atributosResponse) {
			
			TipoAtributo tipoAtributo = TipoAtributo.getTipo(atributoResponse.getAttributeType());
			
			Atributo atributo = new Atributo(atributoResponse.getAttributeId(), atributoResponse.getName(), idCategoria, tipoAtributo); 

			
			atributosExtraidos.add(atributo);
		}
		
		return atributosExtraidos;
	}

	@Override
	public List<CategoriaTO> buscaCategoriasPorMarketplace(Integer idMarketplace) {
		return marketplaceDao.buscaCategoriasPorMarketplace(idMarketplace);
	}
}
