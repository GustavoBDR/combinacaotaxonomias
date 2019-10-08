package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.PlataformaTO;

public class PlataformaHelper {
	public static List<PlataformaTO> toListTO(List<Plataforma> plataformas) {
		List<PlataformaTO> plataformasTO = new ArrayList<PlataformaTO>();
		
		PlataformaTO plataformaTO;
		for (Plataforma plataforma : plataformas) {
			plataformaTO = new PlataformaTO();
			plataformaTO.setId(plataforma.getId().toString());
			plataformaTO.setNome(plataforma.getNome());
			plataformaTO.setUrlAPIGetCategorias(plataforma.getUrlAPIGetCategorias());
			plataformaTO.setUrlAPIGetAtributos(plataforma.getUrlAPIGetAtributos());
			plataformaTO.setApiTokenId(plataforma.getApiTokenId());
			plataformaTO.setApiTokenKey(plataforma.getApiTokenKey());
			plataformaTO.setUrlApiPostAutenticacao(plataforma.getUrlApiPostAutenticacao());
			plataformasTO.add(plataformaTO);
		}
		
		return plataformasTO;
	}
}
