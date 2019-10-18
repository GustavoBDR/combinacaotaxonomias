package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaTO;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface MarketplaceDao {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public void alterarMarketplace(Plataforma marketplace);
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Long idMarketplace);
	public void inserirCategoriaTO(CategoriaTO categoria);
	public Long getUltimoIdMarketplace();
	public void inserirAtributo(Atributo atributo, Long idMarketplace);
	public List<CategoriaTO> buscaCategoriasPorMarketplace(Long idMarketplace);
	public List<CategoriaTO> buscaCategoriasFilhas(Long idMarketplace, Integer idCategoriaPai);
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idMarketplace);
}
