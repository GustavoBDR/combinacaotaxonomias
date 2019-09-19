package br.com.combinacaotaxonomias.service;

import java.util.List;

import br.com.combinacaotaxonomias.model.AtributoResponse;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.Plataforma;

public interface ConsumoApiService {
	public String getAutenticacao(Plataforma marketplace);
	public List<CategoriaResponse> getCategorias(Plataforma marketplace);
	public List<AtributoResponse> getAtributos(Plataforma plataforma, Categoria categoria);
}
