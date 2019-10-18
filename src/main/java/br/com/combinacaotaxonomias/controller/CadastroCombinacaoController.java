package br.com.combinacaotaxonomias.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.combinacaotaxonomias.helper.PlataformaHelper;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CombinacaoAtributoWrapper;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.PlataformaTO;
import br.com.combinacaotaxonomias.service.MarketplaceService;
import br.com.combinacaotaxonomias.service.VendedorService;

@Controller
public class CadastroCombinacaoController {
	
    @Autowired
    private MarketplaceService marketplaceService;
    
    @Autowired
    private VendedorService vendedorService;
    
    private PlataformaHelper plataformaHelper;
	
	@RequestMapping(value = "/cadastrocombinacaocategoria", method = RequestMethod.GET)
	public String getCadastroCombinacao(Model model, CombinacaoTO novaCombinacao){
		List<Plataforma> marketplaces = marketplaceService.buscaTodosMarketplaces();
		List<Plataforma> vendedores = vendedorService.buscaTodosVendedores();
		
		List<PlataformaTO> plataformasTO = plataformaHelper.toListTO(marketplaces);
		
		model.addAttribute("vendedores", vendedores);
		model.addAttribute("marketplaces", plataformasTO);

		novaCombinacao = new CombinacaoTO();
		model.addAttribute("novaCombinacao", novaCombinacao);

		return "cadastroCombinacaoCategoria";
	}

	@RequestMapping(value = "/salvacadastrocombinacao", method = RequestMethod.POST)
	public String salvaCadastroCombinacao(Model model, CombinacaoTO novaCombinacao){
		model.addAttribute("novaCombinacao", novaCombinacao);
		
		Plataforma marketplace = marketplaceService.buscaMarketplacePorId(Long.parseLong(novaCombinacao.getIdMarketplace()));
		Plataforma vendedor = vendedorService.buscaVendedorPorId(Long.parseLong(novaCombinacao.getIdVendedor()));
		model.addAttribute("marketplace", marketplace);
		model.addAttribute("vendedor", vendedor);
		
		List<AtributoTO> atributosLinhaMarketplace= new ArrayList<AtributoTO>();
		atributosLinhaMarketplace = marketplaceService.buscaAtributosPorCategoria(Integer.parseInt(novaCombinacao.getIdLinhaMarketplace()), Integer.parseInt(novaCombinacao.getIdMarketplace()));

		List<AtributoTO> atributosFamiliaMarketplace= new ArrayList<AtributoTO>();
		atributosFamiliaMarketplace = marketplaceService.buscaAtributosPorCategoria(Integer.parseInt(novaCombinacao.getIdFamiliaMarketplace()), Integer.parseInt(novaCombinacao.getIdMarketplace()));		
		
		List<AtributoTO> atributosGrupoMarketplace= new ArrayList<AtributoTO>();
		atributosGrupoMarketplace = marketplaceService.buscaAtributosPorCategoria(Integer.parseInt(novaCombinacao.getIdGrupoMarketplace()), Integer.parseInt(novaCombinacao.getIdMarketplace()));
		
		List<AtributoTO> atributosMarketplace = new ArrayList<AtributoTO>();
		//atributosMarketplace.addAll(atributosLinhaMarketplace);
		//atributosMarketplace.addAll(atributosFamiliaMarketplace);
		atributosMarketplace.addAll(atributosGrupoMarketplace);
		model.addAttribute("atributosMarketplace", atributosMarketplace);
		
		
		List<AtributoTO> atributosLinhaVendedor= new ArrayList<AtributoTO>();
		atributosLinhaVendedor = vendedorService.buscaAtributosPorCategoria(Integer.parseInt(novaCombinacao.getIdLinhaVendedor()), Integer.parseInt(novaCombinacao.getIdVendedor()));
		
		List<AtributoTO> atributosFamiliaVendedor= new ArrayList<AtributoTO>();
		atributosFamiliaVendedor = vendedorService.buscaAtributosPorCategoria(Integer.parseInt(novaCombinacao.getIdFamiliaVendedor()), Integer.parseInt(novaCombinacao.getIdVendedor()));
		
		List<AtributoTO> atributosGrupoVendedor= new ArrayList<AtributoTO>();
		atributosGrupoVendedor = vendedorService.buscaAtributosPorCategoria(Integer.parseInt(novaCombinacao.getIdGrupoVendedor()), Integer.parseInt(novaCombinacao.getIdVendedor()));
		
		List<AtributoTO> atributosVendedor = new ArrayList<AtributoTO>();
		//atributosVendedor.addAll(atributosLinhaVendedor);
		//atributosVendedor.addAll(atributosFamiliaVendedor);
		atributosVendedor.addAll(atributosGrupoVendedor);	
		model.addAttribute("atributosVendedor", atributosVendedor);
		
		
		List<CombinacaoAtributoTO> combinacaoAtributos = new ArrayList<CombinacaoAtributoTO>();
		
		for (int i = 0; i < 10; i++) {
			combinacaoAtributos.add(new CombinacaoAtributoTO());
		}
		
		CombinacaoAtributoWrapper combinacaoWrapper = new CombinacaoAtributoWrapper(combinacaoAtributos);
		
		
		model.addAttribute("combinacaoWrapper", combinacaoWrapper);
		
		return "cadastroCombinacaoAtributos";
	}
	
	@RequestMapping(value = "/salvacadastrocombinacaoatributos", method = RequestMethod.POST)
	public String salvaCadastroCombinacaoAtributos(@ModelAttribute CombinacaoAtributoWrapper combinacaoWrapper){
		Integer i;
		i = 1+1;
		
		return "index";
	}
	
    @ResponseBody
    @RequestMapping(value = "/marketplacelinha", method = RequestMethod.GET)
    public List<CategoriaTO> getMarketplaceLinha(@RequestParam(required = true, name = "idMarketplace") Integer idMarketplace) {
    	List<CategoriaTO> tt = marketplaceService.buscaCategoriasPorMarketplace(idMarketplace);
        return tt;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vendedorlinha", method = RequestMethod.GET)
    public List<CategoriaTO> getVendedorLinha(@RequestParam(required = true, name = "idVendedor") Integer idVendedor) {
    	List<CategoriaTO> tt = vendedorService.buscaCategoriasPorVendedor(idVendedor);
        return tt;
    }

    @ResponseBody
    @RequestMapping(value = "/marketplaceCategoriaFilha", method = RequestMethod.GET)
    public List<CategoriaTO> getMarketplaceCategoriaFilha(@RequestParam(required = true, name = "idMarketplace") Integer idMarketplace, @RequestParam(required = true, name = "idCategoriaPai") Integer idCategoriaPai) {
    	List<CategoriaTO> tt = marketplaceService.buscaCategoriasFilhas(idMarketplace, idCategoriaPai);
        return tt;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vendedorCategoriaFilha", method = RequestMethod.GET)
    public List<CategoriaTO> getVendedorCategoriaFilha(@RequestParam(required = true, name = "idVendedor") Integer idVendedor, @RequestParam(required = true, name = "idCategoriaPai") Integer idCategoriaPai) {
    	return vendedorService.buscaCategoriasFilhas(idVendedor, idCategoriaPai);
    }
    
    
}
