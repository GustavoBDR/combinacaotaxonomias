package br.com.combinacaotaxonomias.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.common.TipoAtributo;
import br.com.combinacaotaxonomias.dao.VendedorDao;
import br.com.combinacaotaxonomias.helper.CategoriaHelper;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.AtributoResponse;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;

@Service("vendedorService")
public class VendedorServiceImp implements VendedorService{
	
	@Resource 
	private VendedorDao vendedorDao;
	
	@Resource 
	private ConsumoApiService consumoApiService;	
	
	private List<Integer> idCategorias = new ArrayList<Integer>();
	
	private CategoriaHelper categoriaHelper;
	
	@Override
	public void inserirVendedor(Plataforma vendedor) {
		vendedorDao.inserirVendedor(vendedor);
		
		List<CategoriaResponse> categoriasResponse = consumoApiService.getCategorias(vendedor);
		List<Categoria> categorias = extrairCategorias(categoriasResponse);
		
		Long idMarketplace = vendedorDao.getUltimoIdVendedor();
		
		inserirCategorias(categorias, idMarketplace);
		

		for (Integer idCategoria : idCategorias) {	
			List<AtributoResponse> atributosResponse = consumoApiService.getAtributos(vendedor, idCategoria);
			List<Atributo> atributos = extrairAtributos(atributosResponse, idCategoria);
			inserirAtributos(atributos, idMarketplace);
		}
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
			if (!idCategorias.contains(categoriaLinha.getId())) {
				idCategorias.add(categoriaLinha.getId());	
			}
			Categoria categoriaFamilia = new Categoria(categoriaResponse.getFamilyId(),categoriaResponse.getFamilyName());
			if (!idCategorias.contains(categoriaFamilia.getId())) {
				idCategorias.add(categoriaFamilia.getId());	
			}
			Categoria categoriaGrupo = new Categoria(categoriaResponse.getGroupId(),categoriaResponse.getGroupName());
			if (!idCategorias.contains(categoriaGrupo.getId())) {
				idCategorias.add(categoriaGrupo.getId());	
			}
			
			categoriaFamilia.addTaxonomia(categoriaGrupo);
			categoriaLinha.addTaxonomia(categoriaFamilia);
			
			categoriasExtraidas.add(categoriaLinha);
		}
		
		return categoriasExtraidas;
	}
	
	public void inserirCategorias(List<Categoria> categorias, Long idVendedor) {
		Map<Integer, CategoriaCombinacaoTO> CategoriaMap = new HashMap<Integer,CategoriaCombinacaoTO>();
		
		
		for (Categoria categoria : categorias) {
			Taxonomia linha = categoria;
			Taxonomia familia = categoria.getFilhoTaxonomia(0);
			Taxonomia grupo = familia.getFilhoTaxonomia(0);
			
			if (!CategoriaMap.containsKey(linha.getId())) {
				CategoriaMap.put(linha.getId(), categoriaHelper.toCategoriaTO(linha, null, idVendedor));
				vendedorDao.inserirCategoria(linha, null, idVendedor);
			}
			
			if (!CategoriaMap.containsKey(familia.getId())) {
				CategoriaMap.put(familia.getId(), categoriaHelper.toCategoriaTO(familia, linha.getId(), idVendedor));
				vendedorDao.inserirCategoria(familia, linha.getId(), idVendedor);
			}
			
			if (!CategoriaMap.containsKey(grupo.getId())) {
				CategoriaMap.put(grupo.getId(), categoriaHelper.toCategoriaTO(grupo, familia.getId(), idVendedor));
				vendedorDao.inserirCategoria(grupo, familia.getId(), idVendedor);
			}
		}
	}
	
	public List<Atributo> extrairAtributos(List<AtributoResponse> atributosResponse, Integer idCategoria) {
		
		List<Atributo> atributosExtraidos = new ArrayList<Atributo>();
		
		
		for (AtributoResponse atributoResponse : atributosResponse) {
			String key = atributoResponse.getAttributeType();
			TipoAtributo tipoAtributo = TipoAtributo.getTipo(key);
			
			Atributo atributo = new Atributo(atributoResponse.getAttributeId(), atributoResponse.getName(), idCategoria, tipoAtributo); 

			
			atributosExtraidos.add(atributo);
		}
		
		return atributosExtraidos;
	}
	
	public void inserirAtributos(List<Atributo> atributos, Long idMarketplace) {
		for (Atributo atributo : atributos) {
			vendedorDao.inserirAtributo(atributo, idMarketplace);
		}
	}

	@Override
	public List<CategoriaCombinacaoTO> buscaCategoriasPorVendedor(Long idVendedor) {
		return vendedorDao.buscaCategoriasPorVendedor(idVendedor);
	}

	@Override
	public List<CategoriaCombinacaoTO> buscaCategoriasFilhas(Long idVendedor, Integer idCategoriaPai) {
		return vendedorDao.buscaCategoriasFilhas(idVendedor, idCategoriaPai);
	}
	
	@Override
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idVendedor) {
		return vendedorDao.buscaAtributosPorCategoria(idCategoria, idVendedor);
	}

	@Override
	public CategoriaCombinacaoTO buscaCategoriaCombinacaoPorId(Integer idCategoria) {
		return vendedorDao.buscaCategoriaCombinacaoPorId(idCategoria);
	}
}
