package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaTO;

public interface VendedorDao {
	public void inserirVendedor(Plataforma vendedor);
	public List<Plataforma> buscaTodosVendedores();
	public List<Plataforma> buscaVendedores(Plataforma vendedor);
	public Plataforma buscaVendedorPorId(Long id);
	public void alterarVendedor(Plataforma vendedor);
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Long idVendedor);
	public Long getUltimoIdVendedor();
	public void inserirAtributo(Atributo atributo, Long idVendedor);
	public List<CategoriaTO> buscaCategoriasPorVendedor(Long idVendedor);
	public List<CategoriaTO> buscaCategoriasFilhas(Long idVendedor, Integer idCategoriaPai);
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idVendedor);
}
