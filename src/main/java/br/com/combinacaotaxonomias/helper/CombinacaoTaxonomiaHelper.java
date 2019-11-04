package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.CombinacaoTaxonomia;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTaxonomiaTO;

public class CombinacaoTaxonomiaHelper {
    private static CombinacaoAtributoHelper combinacaoAtributoHelper;	
	
	public static CombinacaoTaxonomiaTO toCombinacaoTaxonomiaTO(CombinacaoTaxonomia combinacaoTaxonomia) {
		CombinacaoTaxonomiaTO combinacaoTaxonomiaTO = new CombinacaoTaxonomiaTO();
		
		combinacaoTaxonomiaTO.setIdCombinacao(combinacaoTaxonomia.getIdCombinacao().toString());
		combinacaoTaxonomiaTO.setNome(combinacaoTaxonomia.getNome());
		combinacaoTaxonomiaTO.setDescricao(combinacaoTaxonomia.getDescricao());
		combinacaoTaxonomiaTO.setIdMarketplace(combinacaoTaxonomia.getIdMarketplace().toString());
		combinacaoTaxonomiaTO.setIdVendedor(combinacaoTaxonomia.getIdVendedor().toString());
		combinacaoTaxonomiaTO.setIdLinhaMarketplace(combinacaoTaxonomia.getIdLinhaMarketplace().toString());
		combinacaoTaxonomiaTO.setNomeLinhaMarketplace(combinacaoTaxonomia.getNomeLinhaMarketplace());
		combinacaoTaxonomiaTO.setIdFamiliaMarketplace(combinacaoTaxonomia.getIdFamiliaMarketplace().toString());
		combinacaoTaxonomiaTO.setNomeFamiliaMarketplace(combinacaoTaxonomia.getNomeFamiliaMarketplace());
		combinacaoTaxonomiaTO.setIdGrupoMarketplace(combinacaoTaxonomia.getIdGrupoMarketplace().toString());
		combinacaoTaxonomiaTO.setNomeGrupoMarktetplace(combinacaoTaxonomia.getNomeGrupoMarktetplace());
		combinacaoTaxonomiaTO.setIdLinhaVendedor(combinacaoTaxonomia.getIdLinhaVendedor().toString());
		combinacaoTaxonomiaTO.setNomeLinhaVendedor(combinacaoTaxonomia.getNomeLinhaVendedor());
		combinacaoTaxonomiaTO.setIdFamiliaVendedor(combinacaoTaxonomia.getIdFamiliaVendedor().toString());
		combinacaoTaxonomiaTO.setNomeFamiliaVendedor(combinacaoTaxonomia.getNomeFamiliaVendedor());
		combinacaoTaxonomiaTO.setIdGrupoVendedor(combinacaoTaxonomia.getIdGrupoVendedor().toString());
		combinacaoTaxonomiaTO.setNomeGrupoVendedor(combinacaoTaxonomia.getNomeGrupoVendedor());
		combinacaoTaxonomiaTO.setAtributos(combinacaoAtributoHelper.toListCombinacaoTO(combinacaoTaxonomia.getAtributos()));
		
		return combinacaoTaxonomiaTO;
	}

	public static List<CombinacaoTaxonomiaTO> toListCombinacaoTO(List<CombinacaoTaxonomia> listCombinacaoTaxonomia) {
		List<CombinacaoTaxonomiaTO> listCombinacaoTaxonomiaTO = new ArrayList<CombinacaoTaxonomiaTO>();

		for (CombinacaoTaxonomia combinacaoTaxonomia : listCombinacaoTaxonomia) {
			listCombinacaoTaxonomiaTO.add(toCombinacaoTaxonomiaTO(combinacaoTaxonomia));
		}

		return listCombinacaoTaxonomiaTO;
	} 
}
