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

import br.com.combinacaotaxonomias.helper.CombinacaoHelper;
import br.com.combinacaotaxonomias.helper.PlataformaHelper;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Combinacao;
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
    
    private CombinacaoHelper combinacaoHelper;
	
	@RequestMapping(value = "/cadastrocombinacaocategoria", method = RequestMethod.GET)
	public String getCadastroCombinacao(Model model, CombinacaoTO novaCombinacao){
		List<Plataforma> marketplaces = marketplaceService.buscaTodosMarketplaces();
		List<Plataforma> vendedores = vendedorService.buscaTodosVendedores();
		
		List<PlataformaTO> marketplacesTO = plataformaHelper.toListTO(marketplaces);
		List<PlataformaTO> vendedoresTO = plataformaHelper.toListTO(vendedores);
		
		model.addAttribute("vendedores", vendedoresTO);
		model.addAttribute("marketplaces", marketplacesTO);

		novaCombinacao = new CombinacaoTO();
		model.addAttribute("novaCombinacao", novaCombinacao);

		return "cadastroCombinacaoCategoria";
	}

	@RequestMapping(value = "/salvacadastrocombinacao", method = RequestMethod.POST)
	public String salvaCadastroCombinacao(Model model, CombinacaoTO novaCombinacaoTO){
		model.addAttribute("novaCombinacao", novaCombinacaoTO);
		
		Combinacao novaCombinacao = combinacaoHelper.toCombinacao(novaCombinacaoTO);
				
		Plataforma marketplace = marketplaceService.buscaMarketplacePorId(novaCombinacao.getIdMarketplace());
		Plataforma vendedor = vendedorService.buscaVendedorPorId(novaCombinacao.getIdVendedor());
		
		PlataformaTO marketplaceTO = plataformaHelper.toPlataformaTO(marketplace);
		PlataformaTO vendedorTO = plataformaHelper.toPlataformaTO(vendedor);
		
		model.addAttribute("marketplace", marketplaceTO);
		model.addAttribute("vendedor", vendedorTO);
		
		List<AtributoTO> atributosLinhaMarketplace= new ArrayList<AtributoTO>();
		atributosLinhaMarketplace = marketplaceService.buscaAtributosPorCategoria(novaCombinacao.getIdLinhaMarketplace(), novaCombinacao.getIdMarketplace());
		List<AtributoTO> atributosFamiliaMarketplace= new ArrayList<AtributoTO>();
		atributosFamiliaMarketplace = marketplaceService.buscaAtributosPorCategoria(novaCombinacao.getIdFamiliaMarketplace(), novaCombinacao.getIdMarketplace());				
		List<AtributoTO> atributosGrupoMarketplace= new ArrayList<AtributoTO>();
		atributosGrupoMarketplace = marketplaceService.buscaAtributosPorCategoria(novaCombinacao.getIdGrupoMarketplace(), novaCombinacao.getIdMarketplace());
		
		List<AtributoTO> atributosMarketplace = new ArrayList<AtributoTO>();
		atributosMarketplace.addAll(atributosLinhaMarketplace);
		atributosMarketplace.addAll(atributosFamiliaMarketplace);
		atributosMarketplace.addAll(atributosGrupoMarketplace);
		model.addAttribute("atributosMarketplace", atributosMarketplace);
		
		
		List<AtributoTO> atributosLinhaVendedor= new ArrayList<AtributoTO>();
		atributosLinhaVendedor = vendedorService.buscaAtributosPorCategoria(novaCombinacao.getIdLinhaVendedor(), novaCombinacao.getIdVendedor());
		List<AtributoTO> atributosFamiliaVendedor= new ArrayList<AtributoTO>();
		atributosFamiliaVendedor = vendedorService.buscaAtributosPorCategoria(novaCombinacao.getIdFamiliaVendedor(), novaCombinacao.getIdVendedor());
		List<AtributoTO> atributosGrupoVendedor= new ArrayList<AtributoTO>();
		atributosGrupoVendedor = vendedorService.buscaAtributosPorCategoria(novaCombinacao.getIdGrupoVendedor(), novaCombinacao.getIdVendedor());
		
		List<AtributoTO> atributosVendedor = new ArrayList<AtributoTO>();
		atributosVendedor.addAll(atributosLinhaVendedor);
		atributosVendedor.addAll(atributosFamiliaVendedor);
		atributosVendedor.addAll(atributosGrupoVendedor);	
		model.addAttribute("atributosVendedor", atributosVendedor);
		
		
		List<CombinacaoAtributoTO> combinacaoAtributos = new ArrayList<CombinacaoAtributoTO>();
		CombinacaoAtributoWrapper combinacaoWrapper = new CombinacaoAtributoWrapper(combinacaoAtributos);
		
		//Após inserir no banco adicionar o id
		combinacaoWrapper.setIdCombinacaoCategoria("122");
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
    public List<CategoriaTO> getMarketplaceLinha(@RequestParam(required = true, name = "idMarketplace") Long idMarketplace) {
    	List<CategoriaTO> tt = marketplaceService.buscaCategoriasPorMarketplace(idMarketplace);
        return tt;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vendedorlinha", method = RequestMethod.GET)
    public List<CategoriaTO> getVendedorLinha(@RequestParam(required = true, name = "idVendedor") Long idVendedor) {
    	List<CategoriaTO> tt = vendedorService.buscaCategoriasPorVendedor(idVendedor);
        return tt;
    }

    @ResponseBody
    @RequestMapping(value = "/marketplaceCategoriaFilha", method = RequestMethod.GET)
    public List<CategoriaTO> getMarketplaceCategoriaFilha(@RequestParam(required = true, name = "idMarketplace") Long idMarketplace, @RequestParam(required = true, name = "idCategoriaPai") Integer idCategoriaPai) {
    	List<CategoriaTO> tt = marketplaceService.buscaCategoriasFilhas(idMarketplace, idCategoriaPai);
        return tt;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vendedorCategoriaFilha", method = RequestMethod.GET)
    public List<CategoriaTO> getVendedorCategoriaFilha(@RequestParam(required = true, name = "idVendedor") Long idVendedor, @RequestParam(required = true, name = "idCategoriaPai") Integer idCategoriaPai) {
    	return vendedorService.buscaCategoriasFilhas(idVendedor, idCategoriaPai);
    }
    
    
}
