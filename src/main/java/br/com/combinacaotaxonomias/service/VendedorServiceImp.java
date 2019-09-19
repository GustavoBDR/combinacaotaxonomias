package br.com.combinacaotaxonomias.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.VendedorDao;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;

@Service("vendedorService")
public class VendedorServiceImp implements VendedorService{
	
	@Resource 
	private VendedorDao vendedorDao;
	
	@Resource 
	private ConsumoApiService consumoApiService;	
	
	@Override
	public void inserirVendedor(Plataforma vendedor) {
		vendedorDao.inserirVendedor(vendedor);
		
		List<CategoriaResponse> categoriasResponse = consumoApiService.getCategorias(vendedor);
		List<Categoria> categorias = extrairCategorias(categoriasResponse);
		
		Integer idMarketplace = vendedorDao.getUltimoIdVendedor();
		
		inserirCategorias(categorias, idMarketplace);		
	}

	@Override
	public List<Plataforma> buscaTodosVendedores() {
		return vendedorDao.buscaTodosVendedores();
	}

	@Override
	public List<Plataforma> buscaVendedores(Plataforma vendedor) {
		return vendedorDao.buscaVendedores(vendedor);
	}

	@Override
	public Plataforma buscaVendedorPorId(Long id) {
		return vendedorDao.buscaVendedorPorId(id);
	}

	@Override
	public boolean isVendedor(Plataforma vendedor) {
		Plataforma v =  vendedorDao.buscaVendedorPorId(vendedor.getId());
		if (v.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void alterarVendedor(Plataforma vendedor) {
		vendedorDao.alterarVendedor(vendedor);		
	}
	
	public List<Categoria> extrairCategorias(List<CategoriaResponse> categoriasResponse) {
		
		List<Categoria> categoriasExtraidas = new ArrayList<Categoria>();
		
		
		for (CategoriaResponse categoriaResponse : categoriasResponse) {
			
			Categoria categoriaLinha = new Categoria(categoriaResponse.getLineId(),categoriaResponse.getLineName());
			Categoria categoriaFamilia = new Categoria(categoriaResponse.getFamilyId(),categoriaResponse.getFamilyName());
			Categoria categoriaGrupo = new Categoria(categoriaResponse.getGroupId(),categoriaResponse.getGroupName());
			
			categoriaFamilia.addTaxonomia(categoriaGrupo);
			categoriaLinha.addTaxonomia(categoriaFamilia);
			
			categoriasExtraidas.add(categoriaLinha);
		}
		
		return categoriasExtraidas;
	}
	
	public void inserirCategorias(List<Categoria> categorias, Integer idVendedor) {
		for (Categoria categoria : categorias) {
			Taxonomia linha = categoria;
			Taxonomia familia = categoria.getFilhoTaxonomia(0);
			Taxonomia grupo = familia.getFilhoTaxonomia(0);
			vendedorDao.inserirCategoria(linha, null, idVendedor);
			vendedorDao.inserirCategoria(familia, linha.getId(), idVendedor);
			vendedorDao.inserirCategoria(grupo, familia.getId(), idVendedor);
		}
	}	
}
