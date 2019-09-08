package br.com.combinacaotaxonomias.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.combinacaotaxonomias.dao.VendedorDao;
import br.com.combinacaotaxonomias.model.Plataforma;


@Controller
public class TesteBancoController {
		
	@Resource 
	private VendedorDao vendedorDao;
	
	
	@RequestMapping("testebanco")
	public String testeBanco(Model model) {
			
		List<Plataforma> vendedores = vendedorDao.buscaTodosVendedores();
		
		model.addAttribute("vendedores", vendedores);
		
		return "testebanco";
	}
}
