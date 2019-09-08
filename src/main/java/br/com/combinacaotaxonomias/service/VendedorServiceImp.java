package br.com.combinacaotaxonomias.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.combinacaotaxonomias.dao.VendedorDao;
import br.com.combinacaotaxonomias.model.Plataforma;

@Service("vendedorService")
public class VendedorServiceImp implements VendedorService{
	
	@Resource 
	private VendedorDao vendedorDao;
	
	
	@Override
	public void inserirVendedor(Plataforma vendedor) {
		vendedorDao.inserirVendedor(vendedor);
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
}
