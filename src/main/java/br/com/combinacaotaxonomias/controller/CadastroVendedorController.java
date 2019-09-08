package br.com.combinacaotaxonomias.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.TokenApiRequest;
import br.com.combinacaotaxonomias.model.TokenApiResponse;
import br.com.combinacaotaxonomias.service.ConsumoApiService;
import br.com.combinacaotaxonomias.service.VendedorService;

//https://mdbootstrap.com/snippets/jquery/pjoter-2-0/747937
@Controller
public class CadastroVendedorController {

    @Autowired
    private VendedorService vendedorService;
    
    @Autowired
    private ConsumoApiService consumoApiService;

	@RequestMapping(value = "/cadastrovendedor", method = RequestMethod.GET)
	public String getCadastroVendedor(Model model){
		
		Plataforma vendedor = new Plataforma();
		model.addAttribute("vendedor", vendedor);
		return "cadastroVendedor";
	}
	
	@RequestMapping(value = "/salvacadastrovendedor", method = RequestMethod.POST)
	public String postCadastroVendedor(Plataforma vendedor){
		if (vendedor.getId() != null) {
			vendedorService.alterarVendedor(vendedor);
		}
		else {
			vendedorService.inserirVendedor(vendedor);	
		}
		return "index";
	}

	@RequestMapping(value = "/consultatodosvendedores", method = RequestMethod.GET)
	public String getConsultaTodosVendedores(Model model){
		
		List<Plataforma> vendedores = vendedorService.buscaTodosVendedores();	
		model.addAttribute("vendedores", vendedores);
		return "testebanco";
	}
	
	@RequestMapping(value = "/vendedor", method = RequestMethod.GET)
	public String getVendedor(Model model, Plataforma vendedor) {
		if (!vendedor.isEmpty()) {
			model.addAllAttributes(getAtributosBusca(vendedor));
		}
		model.addAttribute("vendedor", vendedor);
		
		return "buscaVendedor";
	}
	
	@RequestMapping(value = "/editarVendedor/{id}", method = RequestMethod.GET)
	public String getEditarVendedor(@PathVariable Long id, Model model) {
		
		Plataforma vendedor = vendedorService.buscaVendedorPorId(id);
		model.addAttribute("vendedor", vendedor);
		
		return "cadastroVendedor";
	}	
	
    public Map<String, Object> getAtributosBusca(Plataforma vendedor) {
        Map<String, Object> atributosVendedor = new HashMap<>();
        List<Plataforma> vendedores = vendedorService.buscaVendedores(vendedor);
        if (vendedores == null) {
        	atributosVendedor.put("erroBusca", " Nenhum registro encontrado. ");
        } else {
        	atributosVendedor.put("resultadoBuscaVendedores", vendedores);
        }
        
        return atributosVendedor;
    }
    

	public String salvaCategoriasVendedor() {
    	TokenApiResponse response = consumoApiService.getAutenticacao("https://api.marketplace.colombo.com.br/v1/authentication", "KPEMTHNFEVVAFIUKAQRC", "KveplnQA9srpvevqcGGXroJjQm3Z24JFdsD4ZIQ9");
    	
    	
    	
		return "index";
	}	
}
