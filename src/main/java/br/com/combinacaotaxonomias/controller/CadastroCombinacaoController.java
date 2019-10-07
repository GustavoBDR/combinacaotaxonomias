package br.com.combinacaotaxonomias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.service.MarketplaceService;
import br.com.combinacaotaxonomias.service.VendedorService;

@Controller
public class CadastroCombinacaoController {
	
    @Autowired
    private MarketplaceService marketplaceService;
    
    @Autowired
    private VendedorService vendedorService;
	
	@RequestMapping(value = "/cadastrocombinacaocategoria", method = RequestMethod.GET)
	public String getCadastroCombinacao(Model model){
		List<Plataforma> marketplaces = marketplaceService.buscaTodosMarketplaces();
		List<Plataforma> vendedores = vendedorService.buscaTodosVendedores();
		
		model.addAttribute("vendedores", vendedores);
		model.addAttribute("marketplaces", marketplaces);

		Combinacao novaCombinacao = new Combinacao();
		model.addAttribute("novaCombinacao", novaCombinacao);

		return "cadastroCombinacaoCategoria";
	}

	@RequestMapping(value = "/salvacadastrocombinacao", method = RequestMethod.POST)
	public String salvaCadastroCombinacao(@RequestParam("novaCombinacao") Combinacao novaCombinacao, List<Plataforma> marketplaces){
		return "cadastroCombinacaoCategoria";
	}
	
	
    @ResponseBody
    @RequestMapping(path = {"/marketplacelinha"}, method = RequestMethod.GET)
    public List<Categoria> getMarketplaceLinha(@RequestParam(required = true, name = "idMarketplace") Integer idMarketplace) {
        return marketplaceService.getCategoriasPorMarketplace(marketplaceService);
    }

}
