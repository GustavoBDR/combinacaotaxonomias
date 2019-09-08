package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Plataforma;

public interface VendedorService {
	public void inserirVendedor(Plataforma vendedor);
	public List<Plataforma> buscaTodosVendedores();
	public List<Plataforma> buscaVendedores(Plataforma vendedor);
	public Plataforma buscaVendedorPorId(Long id);
	public boolean isVendedor(Plataforma vendedor);
	public void alterarVendedor(Plataforma vendedor);
}
