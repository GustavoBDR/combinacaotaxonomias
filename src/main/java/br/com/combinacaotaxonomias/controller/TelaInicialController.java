package br.com.combinacaotaxonomias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TelaInicialController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
