package br.com.combinacaotaxonomias.model;

import java.util.List;

import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public class CombinacaoAtributoWrapper {
	
	private String idCombinacao;
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

	public String getIdCombinacao() {
		return idCombinacao;
	}

	public void setIdCombinacao(String idCombinacao) {
		this.idCombinacao = idCombinacao;
	}	
}
