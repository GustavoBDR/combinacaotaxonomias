package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface ConsumoApiService {
	public String getAutenticacao(Plataforma marketplace);
	public List<Categoria> getCategorias(Plataforma marketplace);
}
