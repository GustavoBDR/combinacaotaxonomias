package br.com.combinacaotaxonomias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.combinacaotaxonomias.model.Plataforma;

@Controller
public class CadastroCombinacaoController {
	
	@RequestMapping(value = "/cadastrocombinacaocategoria", method = RequestMethod.GET)
	public String getCadastroMarketplace(Model model){
		Plataforma vendedor = new Plataforma();
		model.addAttribute("vendedor", vendedor);

		return "cadastroCombinacaoCategoria";
	}
}
