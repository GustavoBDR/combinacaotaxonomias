package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public class CombinacaoAtributoHelper {

	public static CombinacaoAtributo toCombinacaoAtributo(CombinacaoAtributoTO combinacaoAtributoTO) {
		CombinacaoAtributo combinacaoAtributo = new CombinacaoAtributo();
		
		if (!combinacaoAtributoTO.getIdCombinacao().isEmpty()) {
			combinacaoAtributo.setIdCombinacao(Integer.valueOf(combinacaoAtributoTO.getIdCombinacao()));      
		}
		if (!combinacaoAtributoTO.getIdMarketplace().isEmpty()) {
			combinacaoAtributo.setIdMarketplace(Integer.valueOf(combinacaoAtributoTO.getIdMarketplace()));  
		}
		if (!combinacaoAtributoTO.getIdAtributoMarketplace().isEmpty()) {
			combinacaoAtributo.setIdAtributoMarketplace(Integer.valueOf(combinacaoAtributoTO.getIdAtributoMarketplace()));  
		}
		if (!combinacaoAtributoTO.getNomeAtributoMarketplace().isEmpty()) {
			combinacaoAtributo.setNomeAtributoMarketplace(combinacaoAtributoTO.getNomeAtributoMarketplace()); 
		} 
		if (!combinacaoAtributoTO.getTipoAtributoMarketplace().isEmpty()) {
			combinacaoAtributo.setTipoAtributoMarketplace(combinacaoAtributoTO.getTipoAtributoMarketplace()); 
		}   
		if (!combinacaoAtributoTO.getIdVendedor().isEmpty()) {
			combinacaoAtributo.setIdVendedor(Integer.valueOf(combinacaoAtributoTO.getIdVendedor()));
		}
		if (!combinacaoAtributoTO.getIdAtributoVendedor().isEmpty()) {
			combinacaoAtributo.setIdAtributoVendedor(Integer.valueOf(combinacaoAtributoTO.getIdAtributoVendedor()));
		}
		if (!combinacaoAtributoTO.getNomeAtributoVendedor().isEmpty()) {
			combinacaoAtributo.setNomeAtributoVendedor(combinacaoAtributoTO.getNomeAtributoVendedor()); 
		}
		if (!combinacaoAtributoTO.getTipoAtributoVendedor().isEmpty()) {
			combinacaoAtributo.setTipoAtributoVendedor(combinacaoAtributoTO.getTipoAtributoVendedor());
		}
		
		return combinacaoAtributo;
	}
	
	public static CombinacaoAtributoTO toCombinacaoAtributoTO(CombinacaoAtributo combinacaoAtributo) {
		CombinacaoAtributoTO combinacaoAtributoTO = new CombinacaoAtributoTO();

		if (combinacaoAtributo.getIdCombinacao() != null) {
			combinacaoAtributoTO.setIdCombinacao(combinacaoAtributo.getIdCombinacao().toString());      
		}
		if (combinacaoAtributo.getIdMarketplace() != null) {
			combinacaoAtributoTO.setIdMarketplace(combinacaoAtributo.getIdMarketplace().toString());  
		}
		if (combinacaoAtributo.getIdAtributoMarketplace() != null) {
			combinacaoAtributoTO.setIdAtributoMarketplace(combinacaoAtributo.getIdAtributoMarketplace().toString());  
		}
		if (!combinacaoAtributo.getNomeAtributoMarketplace().isEmpty()) {
			combinacaoAtributoTO.setNomeAtributoMarketplace(combinacaoAtributo.getNomeAtributoMarketplace()); 
		} 
		if (!combinacaoAtributo.getTipoAtributoMarketplace().isEmpty()) {
			combinacaoAtributoTO.setTipoAtributoMarketplace(combinacaoAtributo.getTipoAtributoMarketplace()); 
		}   
		if (combinacaoAtributo.getIdVendedor() != null) {
			combinacaoAtributoTO.setIdVendedor(combinacaoAtributo.getIdVendedor().toString());
		}
		if (combinacaoAtributo.getIdAtributoVendedor() != null) {
			combinacaoAtributoTO.setIdAtributoVendedor(combinacaoAtributo.getIdAtributoVendedor().toString());
		}
		if (!combinacaoAtributo.getNomeAtributoVendedor().isEmpty()) {
			combinacaoAtributoTO.setNomeAtributoVendedor(combinacaoAtributo.getNomeAtributoVendedor()); 
		}
		if (combinacaoAtributo.getTipoAtributoVendedor() != null) {
			combinacaoAtributoTO.setTipoAtributoVendedor(combinacaoAtributo.getTipoAtributoVendedor());
		}
		
		return combinacaoAtributoTO;
	}
	
	public static List<CombinacaoAtributo> toListCombinacao(List<CombinacaoAtributoTO> listCombinacaoAtributoTO){
		List<CombinacaoAtributo> listCombinacao = new ArrayList<CombinacaoAtributo>();

		for (CombinacaoAtributoTO combinacaoAtributoTO : listCombinacaoAtributoTO) {
			listCombinacao.add(toCombinacaoAtributo(combinacaoAtributoTO));
		}

		return listCombinacao;
	}

	public static List<CombinacaoAtributoTO> toListCombinacaoTO(List<CombinacaoAtributo> listCombinacaoAtributo){
		List<CombinacaoAtributoTO> listCombinacaoTO = new ArrayList<CombinacaoAtributoTO>();

		for (CombinacaoAtributo combinacaoAtributo : listCombinacaoAtributo) {
			listCombinacaoTO.add(toCombinacaoAtributoTO(combinacaoAtributo));
		}

		return listCombinacaoTO;
	} 
}
