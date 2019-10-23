package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface MarketplaceDao {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public void alterarMarketplace(Plataforma marketplace);
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Long idMarketplace);
	public void inserirCategoriaTO(CategoriaCombinacaoTO categoria);
	public Long getUltimoIdMarketplace();
	public void inserirAtributo(Atributo atributo, Long idMarketplace);
	public List<CategoriaCombinacaoTO> buscaCategoriasPorMarketplace(Long idMarketplace);
	public List<CategoriaCombinacaoTO> buscaCategoriasFilhas(Long idMarketplace, Integer idCategoriaPai);
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idMarketplace);
}
