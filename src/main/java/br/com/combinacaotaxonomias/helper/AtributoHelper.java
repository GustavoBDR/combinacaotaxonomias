package br.com.combinacaotaxonomias.helper;

import br.com.combinacaotaxonomias.common.TipoAtributo;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.to.AtributoTO;

public class AtributoHelper {
	
	private static TipoAtributo tipoAtributo = null;
	
	public  static Atributo toAtributo(AtributoTO atributoTO) {	
		
		tipoAtributo .setTipo(atributoTO.getTipoAtributo());
		
		Atributo atributo = new Atributo(Integer.valueOf(atributoTO.getId()), atributoTO.getNome(), Integer.valueOf(atributoTO.getCategoriaId()), tipoAtributo );
		
		return atributo;
	}
	
	public  static AtributoTO toAtributoTO(Atributo atributo) {	
		
		AtributoTO atributoTO = new AtributoTO();
		
		atributoTO.setId(atributo.getId().toString());
		atributoTO.setNome(atributo.getNome());
		atributoTO.setCategoriaId(atributo.getCategoriaId().toString());
		atributoTO.setTipoAtributo(atributo.getTipoAtributo().getTipo());
		
		return atributoTO;
	}
}
