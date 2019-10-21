package br.com.combinacaotaxonomias.helper;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.CategoriaTO;

public class CategoriaHelper {
	
	public  static Categoria toCategoria(CategoriaTO categoriaTO) {	
		Categoria categoria = new Categoria(Integer.valueOf(categoriaTO.getIdCategoria()), categoriaTO.getNome());
		
		return categoria;
	}
	
	public  static CategoriaTO toCategoriaTO(Taxonomia categoria, Integer idPai, Long idPlataforma) {
		String idCategoria = null;
		if (categoria.getId() != null) {
			idCategoria = categoria.getId().toString();
		}
		String idCategoriaPai = null;
		if (idPai != null) {
			idCategoriaPai = idPai.toString();
		}
		String idPlataforma2 = null;
		if (idPlataforma != null) {
			idPlataforma2 = idPlataforma.toString();
		}
		
		CategoriaTO categoriaTO = new CategoriaTO(idCategoria, categoria.getNome(), idCategoriaPai, idPlataforma2);
		
		return categoriaTO;
	}
}
