package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.AtributoResponse;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;

public interface MarketplaceService {
	public void inserirMarketplace(Plataforma marketplace);
	public List<Plataforma> buscaTodosMarketplaces();
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace);
	public Plataforma buscaMarketplacePorId(Long id);
	public boolean isMarketplace(Plataforma marketplace);
	public void alterarMarketplace(Plataforma marketplace);
	public List<Atributo> extrairAtributos(List<AtributoResponse> atributosResponse, Integer idCategoria);
	public List<CategoriaCombinacaoTO> buscaCategoriasPorMarketplace(Long idMarketplace);
	public List<CategoriaCombinacaoTO> buscaCategoriasFilhas(Long idMarketplace, Integer idCategoriaPai);
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idMarketplace);
	public CategoriaCombinacaoTO buscaCategoriaCombinacaoPorId(Integer idCategoria);
}
