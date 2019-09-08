package br.com.combinacaotaxonomias.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.TokenApiResponse;

public interface ConsumoApiService {
	public TokenApiResponse getAutenticacao(String url, String id, String key);
	public List<Categoria> getCategorias(String url);
}
