package br.com.combinacaotaxonomias.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.combinacaotaxonomias.helper.CombinacaoHelper;
import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTaxonomiaTO;
import br.com.combinacaotaxonomias.service.CombinacaoService;

@RestController
public class ApiCombinacaoController {
    @Autowired
    private CombinacaoService combinacaoService;
    
    private CombinacaoHelper combinacaoHelper;
    
	/*
    @RequestMapping("/getCombinacoesPorMarketplace")
	public List<CombinacaoTO> getCombinacoes(Long idMarketplace){
	
		List<Combinacao> combinacoes= combinacaoService.buscaCombinacaoPorIdMarketplace(idMarketplace);
		List<CombinacaoTO> combinacoesTO = combinacaoHelper.toListCombinacaoTO(combinacoes);
	    
		return combinacoesTO;
	}*/
    
    @RequestMapping("/getCombinacoesPorMarketplace")
	public List<CombinacaoTaxonomiaTO> getCombinacoesTaxonomiaPorMarketplace(Long idMarketplace){

    	List<CombinacaoTaxonomiaTO> combinacaoTaxonomiaTO = combinacaoService.BuscaCombinacoesTaxonomiaPorMarketplace(idMarketplace);
    	
	    
		return combinacaoTaxonomiaTO;
	}
}
