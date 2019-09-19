package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.AtributoResponse;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface MarketplaceService {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public boolean isMarketplace(Plataforma marketplace);
	public void alterarMarketplace(Plataforma marketplace);
	public List<Atributo> extrairAtributos(List<AtributoResponse> atributosResponse, Categoria categoria);
}
