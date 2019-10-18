package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.to.PlataformaTO;

public class PlataformaHelper {
	
	public static Plataforma toPlataforma(PlataformaTO plataformaTO) {
		Plataforma plataforma = new Plataforma();
		
		plataforma.setId(Long.valueOf(plataformaTO.getId()));
		plataforma.setNome(plataformaTO.getNome());
		plataforma.setUrlAPIGetCategorias(plataformaTO.getUrlAPIGetCategorias());
		plataforma.setUrlAPIGetAtributos(plataformaTO.getUrlAPIGetAtributos());
		plataforma.setUrlApiPostAutenticacao(plataformaTO.getUrlApiPostAutenticacao());
		plataforma.setApiTokenId(plataformaTO.getApiTokenId());
		plataforma.setApiTokenKey(plataformaTO.getApiTokenKey());

		return plataforma;
	}	
	
	public static PlataformaTO toPlataformaTO(Plataforma plataforma) {
		PlataformaTO plataformaTO = new PlataformaTO();
		
		plataformaTO.setId(plataforma.getId().toString());
		plataformaTO.setNome(plataforma.getNome());
		plataformaTO.setUrlAPIGetCategorias(plataforma.getUrlAPIGetCategorias());
		plataformaTO.setUrlAPIGetAtributos(plataforma.getUrlAPIGetAtributos());
		plataformaTO.setUrlApiPostAutenticacao(plataforma.getUrlApiPostAutenticacao());
		plataformaTO.setApiTokenId(plataforma.getApiTokenId());
		plataformaTO.setApiTokenKey(plataforma.getApiTokenKey());

		return plataformaTO;
	}

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
