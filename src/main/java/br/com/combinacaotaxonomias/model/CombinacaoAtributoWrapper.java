package br.com.combinacaotaxonomias.model;

import java.util.List;

public class CombinacaoAtributoWrapper {
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

}
