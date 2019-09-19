package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface MarketplaceDao {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public void alterarMarketplace(Plataforma marketplace);
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Integer idMarketplace);
	public Integer getUltimoIdMarketplace();
	public void inserirAtributo(Atributo atributo, Integer idMarketplace);
}
