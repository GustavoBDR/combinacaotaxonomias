package br.com.combinacaotaxonomias.model;

import java.util.List;

import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public class CombinacaoAtributoWrapper {
	
	private String idCombinacaoCategoria;
	private List<CombinacaoAtributoTO>  combinacaoAtributos;

	public List<CombinacaoAtributoTO> getCombinacaoAtributos() {
		return combinacaoAtributos;
	}

	public void setCombinacaoAtributos(List<CombinacaoAtributoTO> combinacaoAtributos) {
		this.combinacaoAtributos = combinacaoAtributos;
	}
	
	public CombinacaoAtributoWrapper() {
		
	}

	public CombinacaoAtributoWrapper(List<CombinacaoAtributoTO> combinacaoAtributos) {
		this.combinacaoAtributos = combinacaoAtributos;
	}

	public String getIdCombinacaoCategoria() {
		return idCombinacaoCategoria;
	}

	public void setIdCombinacaoCategoria(String idCombinacaoCategoria) {
		this.idCombinacaoCategoria = idCombinacaoCategoria;
	}	
}
