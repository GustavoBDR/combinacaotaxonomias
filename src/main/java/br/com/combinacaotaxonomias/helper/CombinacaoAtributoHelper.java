package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public class CombinacaoAtributoHelper {

	public static CombinacaoAtributo toCombinacaoAtributo(CombinacaoAtributoTO combinacaoAtributoTO) {
		CombinacaoAtributo combinacaoAtributo = new CombinacaoAtributo();
		
		combinacaoAtributo.setIdAtributoMarketplace(Integer.valueOf(combinacaoAtributoTO.getIdAtributoMarketplace()));
		combinacaoAtributo.setIdAtributoVendedor(Integer.valueOf(combinacaoAtributoTO.getIdAtributoVendedor()));
		
		return combinacaoAtributo;
	}
	
	public static CombinacaoAtributoTO toCombinacaoAtributoTO(CombinacaoAtributo combinacaoAtributo) {
		CombinacaoAtributoTO combinacaoAtributoTO = new CombinacaoAtributoTO();

		combinacaoAtributoTO.setIdAtributoMarketplace(combinacaoAtributoTO.getIdAtributoMarketplace().toString());
		combinacaoAtributoTO.setIdAtributoVendedor(combinacaoAtributoTO.getIdAtributoVendedor().toString());
		
		return combinacaoAtributoTO;
	}
	
	public static List<CombinacaoAtributo> toListCombinacao(List<CombinacaoAtributoTO> listCombinacaoAtributoTO){
		List<CombinacaoAtributo> listCombinacao = new ArrayList<CombinacaoAtributo>();

		for (CombinacaoAtributoTO combinacaoAtributoTO : listCombinacaoAtributoTO) {
			listCombinacao.add(toCombinacaoAtributo(combinacaoAtributoTO));
		}

		return listCombinacao;
	} 
}
