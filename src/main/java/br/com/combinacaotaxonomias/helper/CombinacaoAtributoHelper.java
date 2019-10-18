package br.com.combinacaotaxonomias.helper;

import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;

public class CombinacaoAtributoHelper {

	public static CombinacaoAtributo toCombinacaoAtributo(CombinacaoAtributoTO combinacaoAtributoTO) {
		CombinacaoAtributo combinacaoAtributo = new CombinacaoAtributo();
		
		combinacaoAtributo.setIdMarketplace(Integer.valueOf(combinacaoAtributoTO.getIdMarketplace()));
		combinacaoAtributo.setIdVendedor(Integer.valueOf(combinacaoAtributoTO.getIdVendedor()));
		combinacaoAtributo.setIdAtributoMarketplace(Integer.valueOf(combinacaoAtributoTO.getIdAtributoMarketplace()));
		combinacaoAtributo.setIdAtributoVendedor(Integer.valueOf(combinacaoAtributoTO.getIdAtributoVendedor()));
		
		return combinacaoAtributo;
	}
	
	public static CombinacaoAtributoTO toCombinacaoAtributoTO(CombinacaoAtributo combinacaoAtributo) {
		CombinacaoAtributoTO combinacaoAtributoTO = new CombinacaoAtributoTO();
		
		combinacaoAtributoTO.setIdMarketplace(combinacaoAtributoTO.getIdMarketplace().toString());
		combinacaoAtributoTO.setIdVendedor(combinacaoAtributoTO.getIdVendedor().toString());
		combinacaoAtributoTO.setIdAtributoMarketplace(combinacaoAtributoTO.getIdAtributoMarketplace().toString());
		combinacaoAtributoTO.setIdAtributoVendedor(combinacaoAtributoTO.getIdAtributoVendedor().toString());
		
		return combinacaoAtributoTO;
	}	
}
