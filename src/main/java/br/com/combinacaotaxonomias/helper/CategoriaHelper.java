package br.com.combinacaotaxonomias.helper;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.CategoriaTO;

public class CategoriaHelper {
	
	public  static Categoria toCategoria(CategoriaTO categoriaTO) {	
		Categoria categoria = new Categoria(Integer.valueOf(categoriaTO.getIdCategoria()), categoriaTO.getNome());
		
		return categoria;
	}
	
	public  static CategoriaTO toCategoriaTO(Taxonomia categoria, Integer idPai, Integer idPlataforma) {	
		CategoriaTO categoriaTO = new CategoriaTO(categoria.getId().toString(), categoria.getNome(), idPai.toString(), idPlataforma.toString());
		
		return categoriaTO;
	}
}
