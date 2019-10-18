package br.com.combinacaotaxonomias.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

public class CombinacaoHelper {
	public static Combinacao toCombinacao(CombinacaoTO combinacaoTO) {
		Combinacao combinacao = new Combinacao();
		
		combinacao.setNome(combinacaoTO.getNome());
		combinacao.setDescricao(combinacaoTO.getDescricao());
		combinacao.setIdMarketplace(Long.valueOf(combinacaoTO.getIdMarketplace()));
		combinacao.setIdVendedor(Long.valueOf(combinacaoTO.getIdVendedor()));
		combinacao.setIdLinhaMarketplace(Integer.valueOf(combinacaoTO.getIdLinhaMarketplace()));
		combinacao.setIdFamiliaMarketplace(Integer.valueOf(combinacaoTO.getIdLinhaMarketplace()));
		combinacao.setIdGrupoMarketplace(Integer.valueOf(combinacaoTO.getIdGrupoMarketplace()));
		combinacao.setIdLinhaVendedor(Integer.valueOf(combinacaoTO.getIdLinhaVendedor()));
		combinacao.setIdFamiliaVendedor(Integer.valueOf(combinacaoTO.getIdGrupoVendedor()));
		combinacao.setIdGrupoVendedor(Integer.valueOf(combinacaoTO.getIdGrupoVendedor()));
		
		return combinacao;
	}
	
	public static CombinacaoTO toCombinacaoTO(Combinacao combinacao) {
		CombinacaoTO combinacaoTO = new CombinacaoTO();
		
		combinacaoTO.setNome(combinacao.getNome());
		combinacaoTO.setDescricao(combinacao.getDescricao());
		combinacaoTO.setIdMarketplace(combinacao.getIdMarketplace().toString());
		combinacaoTO.setIdVendedor(combinacao.getIdVendedor().toString());
		combinacaoTO.setIdLinhaMarketplace(combinacao.getIdLinhaMarketplace().toString());
		combinacaoTO.setIdFamiliaMarketplace(combinacao.getIdLinhaMarketplace().toString());
		combinacaoTO.setIdGrupoMarketplace(combinacao.getIdGrupoMarketplace().toString());
		combinacaoTO.setIdLinhaVendedor(combinacao.getIdLinhaVendedor().toString());
		combinacaoTO.setIdFamiliaVendedor(combinacao.getIdGrupoVendedor().toString());
		combinacaoTO.setIdGrupoVendedor(combinacao.getIdGrupoVendedor().toString());
		
		return combinacaoTO;
	}
	
	public static List<CombinacaoTO> toListCombinacaoTO(List<Combinacao> listCombinacao) {
		List<CombinacaoTO> listCombinacaoTO = new ArrayList<CombinacaoTO>();
		
		for (Combinacao combinacao : listCombinacao) {
			CombinacaoTO combinacaoTO = new CombinacaoTO();
			
			combinacaoTO.setNome(combinacao.getNome());
			combinacaoTO.setDescricao(combinacao.getDescricao());
			combinacaoTO.setIdMarketplace(combinacao.getIdMarketplace().toString());
			combinacaoTO.setIdVendedor(combinacao.getIdVendedor().toString());
			combinacaoTO.setIdLinhaMarketplace(combinacao.getIdLinhaMarketplace().toString());
			combinacaoTO.setIdFamiliaMarketplace(combinacao.getIdLinhaMarketplace().toString());
			combinacaoTO.setIdGrupoMarketplace(combinacao.getIdGrupoMarketplace().toString());
			combinacaoTO.setIdLinhaVendedor(combinacao.getIdLinhaVendedor().toString());
			combinacaoTO.setIdFamiliaVendedor(combinacao.getIdGrupoVendedor().toString());
			combinacaoTO.setIdGrupoVendedor(combinacao.getIdGrupoVendedor().toString());
			
			listCombinacaoTO.add(combinacaoTO);
		}

		return listCombinacaoTO;
	}
	
	public static List<Combinacao> toListCombinacao(List<CombinacaoTO> listCombinacaoTO) {
		List<Combinacao> listCombinacao = new ArrayList<Combinacao>();
		
		for (CombinacaoTO combinacaoTO : listCombinacaoTO) {
			Combinacao combinacao = new Combinacao();
			
			combinacao.setNome(combinacaoTO.getNome());
			combinacao.setDescricao(combinacaoTO.getDescricao());
			combinacao.setIdMarketplace(Long.valueOf(combinacaoTO.getIdMarketplace()));
			combinacao.setIdVendedor(Long.valueOf(combinacaoTO.getIdVendedor()));
			combinacao.setIdLinhaMarketplace(Integer.valueOf(combinacaoTO.getIdLinhaMarketplace()));
			combinacao.setIdFamiliaMarketplace(Integer.valueOf(combinacaoTO.getIdLinhaMarketplace()));
			combinacao.setIdGrupoMarketplace(Integer.valueOf(combinacaoTO.getIdGrupoMarketplace()));
			combinacao.setIdLinhaVendedor(Integer.valueOf(combinacaoTO.getIdLinhaVendedor()));
			combinacao.setIdFamiliaVendedor(Integer.valueOf(combinacaoTO.getIdGrupoVendedor()));
			combinacao.setIdGrupoVendedor(Integer.valueOf(combinacaoTO.getIdGrupoVendedor()));
			
			listCombinacao.add(combinacao);
		}

		return listCombinacao;
	}
}
