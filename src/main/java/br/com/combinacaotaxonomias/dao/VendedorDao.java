package br.com.combinacaotaxonomias.dao;

import java.util.List;

import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;

public interface VendedorDao {
	public void inserirVendedor(Plataforma vendedor);
	public List<Plataforma> buscaTodosVendedores();
	public List<Plataforma> buscaVendedores(Plataforma vendedor);
	public Plataforma buscaVendedorPorId(Long id);
	public void alterarVendedor(Plataforma vendedor);
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Integer idVendedor);
	public Integer getUltimoIdVendedor();	
}
