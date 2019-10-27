package br.com.combinacaotaxonomias.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.combinacaotaxonomias.helper.CombinacaoAtributoHelper;
import br.com.combinacaotaxonomias.helper.CombinacaoHelper;
import br.com.combinacaotaxonomias.helper.PlataformaHelper;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributoWrapper;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.PlataformaTO;
import br.com.combinacaotaxonomias.service.CombinacaoService;
import br.com.combinacaotaxonomias.service.MarketplaceService;
import br.com.combinacaotaxonomias.service.VendedorService;

@Controller
public class CadastroCombinacaoController {
	
    @Autowired
    private MarketplaceService marketplaceService;
    
    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private CombinacaoService combinacaoService;    
    
    private PlataformaHelper plataformaHelper;
    
    private CombinacaoHelper combinacaoHelper;
    
    private CombinacaoAtributoHelper combinacaoAtributoHelper;
	
    
    @RequestMapping(value = "/buscaCombinacao", method = RequestMethod.GET)
    public String getPesquisaCombinacao(Model model, CombinacaoTO combinacaoTO){
    	model.addAttribute("combinacaoTO", combinacaoTO);
    	List<CombinacaoTO> resultadoBuscaCombinacao;
    	
    	if (combinacaoTO.getNome() != null||combinacaoTO.getDescricao() != null) {
			resultadoBuscaCombinacao = combinacaoService.buscaCombinacao(combinacaoTO);
			model.addAttribute("resultadoBuscaCombinacao", resultadoBuscaCombinacao);
		}
    	
    	return "buscaCombinacao";
    }
    
	@RequestMapping(value = "/editarCombinacao/{id}", method = RequestMethod.GET)
	public String getEditarMarketplace(@PathVariable Long id, Model model) {
		
		Combinacao combinacao = combinacaoService.buscaCombinacaoCategoriaPorCombinacaoIdCompleto(id);
		CombinacaoTO combinacaoTO = combinacaoHelper.toCombinacaoTO(combinacao);
		model.addAttribute("novaCombinacao", combinacaoTO);
		
		List<PlataformaTO> marketplacesTO = new ArrayList<PlataformaTO>();
		List<PlataformaTO> vendedoresTO = new ArrayList<PlataformaTO>();
		
		Plataforma marketplace = marketplaceService.buscaMarketplacePorId(Long.valueOf(combinacaoTO.getIdMarketplace()));
		marketplacesTO.add(plataformaHelper.toPlataformaTO(marketplace));
		
		Plataforma vendedor = vendedorService.buscaVendedorPorId(Long.valueOf(combinacaoTO.getIdVendedor()));
		vendedoresTO.add(plataformaHelper.toPlataformaTO(vendedor));
		
		model.addAttribute("marketplaces", marketplacesTO);		
		model.addAttribute("vendedores", vendedoresTO);

		
		
		
		return "cadastrocombinacaocategoria";
	}	
	    
    
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
		
		model.addAttribute("marketplace", plataformaHelper.toPlataformaTO(marketplace));
		model.addAttribute("vendedor", plataformaHelper.toPlataformaTO(vendedor));
		
		List<AtributoTO> atributosLinhaMarketplace = marketplaceService.buscaAtributosPorCategoria(novaCombinacao.getIdLinhaMarketplace(), novaCombinacao.getIdMarketplace());
		List<AtributoTO> atributosFamiliaMarketplace = marketplaceService.buscaAtributosPorCategoria(novaCombinacao.getIdFamiliaMarketplace(), novaCombinacao.getIdMarketplace());				
		List<AtributoTO> atributosGrupoMarketplace = marketplaceService.buscaAtributosPorCategoria(novaCombinacao.getIdGrupoMarketplace(), novaCombinacao.getIdMarketplace());
		
		List<AtributoTO> atributosMarketplace = new ArrayList<AtributoTO>();
		atributosMarketplace.addAll(atributosLinhaMarketplace);
		atributosMarketplace.addAll(atributosFamiliaMarketplace);
		atributosMarketplace.addAll(atributosGrupoMarketplace);
		model.addAttribute("atributosMarketplace", atributosMarketplace);
		
		
		List<AtributoTO> atributosLinhaVendedor = vendedorService.buscaAtributosPorCategoria(novaCombinacao.getIdLinhaVendedor(), novaCombinacao.getIdVendedor());
		List<AtributoTO> atributosFamiliaVendedor = vendedorService.buscaAtributosPorCategoria(novaCombinacao.getIdFamiliaVendedor(), novaCombinacao.getIdVendedor());
		List<AtributoTO> atributosGrupoVendedor = vendedorService.buscaAtributosPorCategoria(novaCombinacao.getIdGrupoVendedor(), novaCombinacao.getIdVendedor());
		
		List<AtributoTO> atributosVendedor = new ArrayList<AtributoTO>();
		atributosVendedor.addAll(atributosLinhaVendedor);
		atributosVendedor.addAll(atributosFamiliaVendedor);
		atributosVendedor.addAll(atributosGrupoVendedor);	
		model.addAttribute("atributosVendedor", atributosVendedor);
		
		
		combinacaoService.inserirCombinacao(novaCombinacao);
		
		Long idCombinacao = combinacaoService.buscaUltimaCombinacaoCategoriaCadastrada();
		
		List<CombinacaoAtributoTO> combinacaoAtributosTO = new ArrayList<CombinacaoAtributoTO>();
		CombinacaoAtributoWrapper combinacaoWrapper = new CombinacaoAtributoWrapper(combinacaoAtributosTO);
		
		//Após inserir no banco, adicionar o id
		combinacaoWrapper.setIdCombinacaoCategoria(idCombinacao.toString());
		model.addAttribute("combinacaoWrapper", combinacaoWrapper);
		
		return "cadastroCombinacaoAtributos";
	}
	
	@RequestMapping(value = "/salvacadastrocombinacaoatributos", method = RequestMethod.POST)
	public String salvaCadastroCombinacaoAtributos(@ModelAttribute CombinacaoAtributoWrapper combinacaoWrapper){

		combinacaoService.inserirCombinacaoAtibutos(Long.valueOf(combinacaoWrapper.getIdCombinacaoCategoria()), combinacaoAtributoHelper.toListCombinacao(combinacaoWrapper.getCombinacaoAtributos()));
		
		return "index";
	}
	
    @ResponseBody
    @RequestMapping(value = "/marketplacelinha", method = RequestMethod.GET)
    public List<CategoriaCombinacaoTO> getMarketplaceLinha(@RequestParam(required = true, name = "idMarketplace") Long idMarketplace) {
    	List<CategoriaCombinacaoTO> tt = marketplaceService.buscaCategoriasPorMarketplace(idMarketplace);
        return tt;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vendedorlinha", method = RequestMethod.GET)
    public List<CategoriaCombinacaoTO> getVendedorLinha(@RequestParam(required = true, name = "idVendedor") Long idVendedor) {
    	List<CategoriaCombinacaoTO> tt = vendedorService.buscaCategoriasPorVendedor(idVendedor);
        return tt;
    }

    @ResponseBody
    @RequestMapping(value = "/marketplaceCategoriaFilha", method = RequestMethod.GET)
    public List<CategoriaCombinacaoTO> getMarketplaceCategoriaFilha(@RequestParam(required = true, name = "idMarketplace") Long idMarketplace, @RequestParam(required = true, name = "idCategoria") Integer idCategoria) {
    	CategoriaCombinacaoTO categoriaCombinacaoPai = marketplaceService.buscaCategoriaCombinacaoPorId(idCategoria);
    	
    	List<CategoriaCombinacaoTO> tt = marketplaceService.buscaCategoriasFilhas(idMarketplace, Integer.valueOf(categoriaCombinacaoPai.getIdCategoriaPlataforma()));
        return tt;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vendedorCategoriaFilha", method = RequestMethod.GET)
    public List<CategoriaCombinacaoTO> getVendedorCategoriaFilha(@RequestParam(required = true, name = "idVendedor") Long idVendedor, @RequestParam(required = true, name = "idCategoria") Integer idCategoria) {
    	CategoriaCombinacaoTO categoriaCombinacaoPai = vendedorService.buscaCategoriaCombinacaoPorId(idCategoria);
    	
    	List<CategoriaCombinacaoTO> tt = vendedorService.buscaCategoriasFilhas(idVendedor, Integer.valueOf(categoriaCombinacaoPai.getIdCategoriaPlataforma()));
        return tt;
    }
    
    
}
