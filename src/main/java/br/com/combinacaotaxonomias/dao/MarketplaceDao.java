package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.AtributoTO;
import br.com.combinacaotaxonomias.model.CategoriaTO;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface MarketplaceDao {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public void alterarMarketplace(Plataforma marketplace);
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Integer idMarketplace);
	public void inserirCategoriaTO(CategoriaTO categoria);
	public Integer getUltimoIdMarketplace();
	public void inserirAtributo(Atributo atributo, Integer idMarketplace);
	public List<CategoriaTO> buscaCategoriasPorMarketplace(Integer idMarketplace);
	public List<CategoriaTO> buscaCategoriasFilhas(Integer idMarketplace, Integer idCategoriaPai);
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Integer idMarletplace);
}
