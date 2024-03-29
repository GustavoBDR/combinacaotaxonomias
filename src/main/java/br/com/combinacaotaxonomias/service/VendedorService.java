package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;

public interface VendedorService {
	public void inserirVendedor(Plataforma vendedor);
	public List<Plataforma> buscaTodosVendedores();
	public List<Plataforma> buscaVendedores(Plataforma vendedor);
	public Plataforma buscaVendedorPorId(Long id);
	public boolean isVendedor(Plataforma vendedor);
	public void alterarVendedor(Plataforma vendedor);
	public List<CategoriaCombinacaoTO> buscaCategoriasPorVendedor(Long idVendedor);
	public List<CategoriaCombinacaoTO> buscaCategoriasFilhas(Long idVendedor, Integer idCategoriaPai);
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idVendedor);
	public CategoriaCombinacaoTO buscaCategoriaCombinacaoPorId(Integer idCategoria);
}
