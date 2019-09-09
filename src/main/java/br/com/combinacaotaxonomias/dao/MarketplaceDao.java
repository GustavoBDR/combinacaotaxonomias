package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Base;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface MarketplaceDao {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public void alterarMarketplace(Plataforma marketplace);
	public void inserirCategoria(Base base);
}
