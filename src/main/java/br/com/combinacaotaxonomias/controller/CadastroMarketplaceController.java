package br.com.combinacaotaxonomias.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.TokenApiResponse;
import br.com.combinacaotaxonomias.service.ConsumoApiService;
import br.com.combinacaotaxonomias.service.MarketplaceService;

@Controller
public class CadastroMarketplaceController {
	
    @Autowired
    private MarketplaceService marketplaceService;
    
    @Autowired
    private ConsumoApiService consumoApiService;

	@RequestMapping(value = "/cadastromarketplace", method = RequestMethod.GET)
	public String getCadastroMarketplace(Model model){
		
		Plataforma marketplace = new Plataforma();
		model.addAttribute("marketplace", marketplace);
		return "cadastroMarketplace";
	}
	
	@RequestMapping(value = "/salvacadastromarketplace", method = RequestMethod.POST)
	public String postCadastroMarketplace(Plataforma marketplace){
		if (marketplace.getId() != null) {
			marketplaceService.alterarMarketplace(marketplace);
		}else {
			marketplaceService.inserirMarketplace(marketplace);	
		}
		return "index";
	}

	@RequestMapping(value = "/consultatodosmarketplaces", method = RequestMethod.GET)
	public String getConsultaTodosMarketplaces(Model model){
		
		List<Plataforma> marketplaces = marketplaceService.buscaTodosMarketplaces();	
		model.addAttribute("marketplaces", marketplaces);
		return "testebanco";
	}
	
	@RequestMapping(value = "/marketplace", method = RequestMethod.GET)
	public String getMarketplace(Model model, Plataforma marketplace) {
		if (!marketplace.isEmpty()) {
			model.addAllAttributes(getAtributosBusca(marketplace));
		}
		model.addAttribute("marketplace", marketplace);
		
		return "buscaMarketplace";
	}
	
	@RequestMapping(value = "/editarMarketplace/{id}", method = RequestMethod.GET)
	public String getEditarMarketplace(@PathVariable Long id, Model model) {
		
		Plataforma marketplace = marketplaceService.buscaMarketplacePorId(id);
		model.addAttribute("marketplace", marketplace);
		
		return "cadastroMarketplace";
	}	
	
    public Map<String, Object> getAtributosBusca(Plataforma marketplace) {
        Map<String, Object> atributosMarketplace = new HashMap<>();
        List<Plataforma> marketplaces = marketplaceService.buscaMarketplaces(marketplace);
        if (marketplaces == null) {
        	atributosMarketplace.put("erroBusca", " Nenhum registro encontrado. ");
        } else {
        	atributosMarketplace.put("resultadoBuscaMarketplaces", marketplaces);
        }
        
        return atributosMarketplace;
    }
    
    @RequestMapping(value = "/testeapi", method = RequestMethod.GET)
	public String salvaCategoriasMarketplace(Plataforma marketplace) {
    	Plataforma marketplace2 = marketplaceService.buscaMarketplacePorId(new Long(3));

    	List<CategoriaResponse> resultado = consumoApiService.getCategorias(marketplace2);
    	
		return "index";
	}	    
}
