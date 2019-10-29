package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;



public class CombinacaoHelper {
	public static Combinacao toCombinacao(CombinacaoTO combinacaoTO) {
		Combinacao combinacao = new Combinacao();
		
		if (combinacaoTO.getIdCombinacao() != null && combinacaoTO.getIdCombinacao() != "") {
			combinacao.setIdCombinacao(Long.valueOf(combinacaoTO.getIdCombinacao()));			
		}
		if (combinacaoTO.getIdCombinacaoCategoria() != null && combinacaoTO.getIdCombinacaoCategoria() != "" ) {
			combinacao.setIdCombinacaoCategoria(Long.valueOf(combinacaoTO.getIdCombinacaoCategoria()));			
		}
		combinacao.setNome(combinacaoTO.getNome());
		combinacao.setDescricao(combinacaoTO.getDescricao());
		combinacao.setIdMarketplace(Long.valueOf(combinacaoTO.getIdMarketplace()));
		combinacao.setIdVendedor(Long.valueOf(combinacaoTO.getIdVendedor()));
		combinacao.setIdLinhaMarketplace(Integer.valueOf(combinacaoTO.getIdLinhaMarketplace()));
		combinacao.setIdFamiliaMarketplace(Integer.valueOf(combinacaoTO.getIdFamiliaMarketplace()));
		combinacao.setIdGrupoMarketplace(Integer.valueOf(combinacaoTO.getIdGrupoMarketplace()));
		combinacao.setIdLinhaVendedor(Integer.valueOf(combinacaoTO.getIdLinhaVendedor()));
		combinacao.setIdFamiliaVendedor(Integer.valueOf(combinacaoTO.getIdFamiliaVendedor()));
		combinacao.setIdGrupoVendedor(Integer.valueOf(combinacaoTO.getIdGrupoVendedor()));
		
		return combinacao;
	}
	
	public static CombinacaoTO toCombinacaoTO(Combinacao combinacao) {
		CombinacaoTO combinacaoTO = new CombinacaoTO();
		
		if (combinacao.getIdCombinacao() != null) {
			combinacaoTO.setIdCombinacao(combinacao.getIdCombinacao().toString());
		}
		if (combinacao.getIdCombinacaoCategoria() != null) {
			combinacaoTO.setIdCombinacaoCategoria(combinacao.getIdCombinacaoCategoria().toString());			
		}		
		if (combinacao.getNome() != null) {
			combinacaoTO.setNome(combinacao.getNome());			
		}
		if (combinacao.getDescricao() != null) {
			combinacaoTO.setDescricao(combinacao.getDescricao());			
		}
		if (combinacao.getIdMarketplace() != null) {
			combinacaoTO.setIdMarketplace(combinacao.getIdMarketplace().toString());			
		}
		if (combinacao.getIdVendedor() != null) {
			combinacaoTO.setIdVendedor(combinacao.getIdVendedor().toString());			
		}
		if (combinacao.getIdLinhaMarketplace() != null) {
			combinacaoTO.setIdLinhaMarketplace(combinacao.getIdLinhaMarketplace().toString());			
		}
		if (combinacao.getIdFamiliaMarketplace() != null) {
			combinacaoTO.setIdFamiliaMarketplace(combinacao.getIdFamiliaMarketplace().toString());			
		}
		if (combinacao.getIdGrupoMarketplace() != null) {
			combinacaoTO.setIdGrupoMarketplace(combinacao.getIdGrupoMarketplace().toString());			
		}
		if (combinacao.getIdLinhaVendedor() != null) {
			combinacaoTO.setIdLinhaVendedor(combinacao.getIdLinhaVendedor().toString());			
		}
		if (combinacao.getIdFamiliaVendedor() != null) {
			combinacaoTO.setIdFamiliaVendedor(combinacao.getIdFamiliaVendedor().toString());			
		}
		if (combinacao.getIdGrupoVendedor() != null ) {
			combinacaoTO.setIdGrupoVendedor(combinacao.getIdGrupoVendedor().toString());			
		}

		return combinacaoTO;
	}
 
	public static List<CombinacaoTO> toListCombinacaoTO(List<Combinacao> listaCombinacoes) {
		List<CombinacaoTO> listCombinacaoTO = new ArrayList<CombinacaoTO>();
		 
		for (Combinacao combinacao : listaCombinacoes) {
			
			CombinacaoTO combinacaoTO = new CombinacaoTO();
			
			combinacaoTO = toCombinacaoTO(combinacao);
			
			listCombinacaoTO.add(combinacaoTO);			
		}

		return listCombinacaoTO;
	}
	
	public static List<Combinacao> toListCombinacao(List<CombinacaoTO> listCombinacaoTO) {
		List<Combinacao> listCombinacao = new ArrayList<Combinacao>();
		
		for (CombinacaoTO combinacaoTO : listCombinacaoTO) {
			Combinacao combinacao = new Combinacao();
			
			combinacao = toCombinacao(combinacaoTO);
			
			listCombinacao.add(combinacao);
		}

		return listCombinacao;
	}
}
