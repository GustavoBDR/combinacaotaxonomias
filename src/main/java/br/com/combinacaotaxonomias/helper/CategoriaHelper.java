package br.com.combinacaotaxonomias.helper;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaTO;
import br.com.combinacaotaxonomias.model.Taxonomia;

public class CategoriaHelper {
	public  static Categoria toCategoria(CategoriaTO categoriaTO) {	
		return null;
	}
	public  static CategoriaTO toCategoriaTO(Taxonomia categoria, Integer idPai, Integer idPlataforma) {	
		CategoriaTO categoriaTO = new CategoriaTO(categoria.getId(), categoria.getNome(), idPai, idPlataforma);
		
		return categoriaTO;
	}	
}
