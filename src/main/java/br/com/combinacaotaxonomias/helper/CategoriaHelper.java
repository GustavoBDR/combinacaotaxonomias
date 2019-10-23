package br.com.combinacaotaxonomias.helper;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;

public class CategoriaHelper {
	
	public  static Categoria toCategoria(CategoriaCombinacaoTO categoriaTO) {	
		Categoria categoria = new Categoria(Integer.valueOf(categoriaTO.getIdCategoriaPlataforma()), categoriaTO.getNome());
		
		return categoria;
	}
	
	public  static CategoriaCombinacaoTO toCategoriaTO(Taxonomia categoria, Integer idPai, Long idPlataforma) {
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
		
		CategoriaCombinacaoTO categoriaTO = new CategoriaCombinacaoTO(null, idCategoria, categoria.getNome(), idCategoriaPai, idPlataforma2);
		
		return categoriaTO;
	}
}
