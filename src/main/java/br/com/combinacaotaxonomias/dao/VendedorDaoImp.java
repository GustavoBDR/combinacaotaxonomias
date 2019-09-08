package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Plataforma;

@Repository("vendedorDao")
public class VendedorDaoImp implements VendedorDao{
	
	private NamedParameterJdbcTemplate template; 
	
	public VendedorDaoImp(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}
 
	@Override
	public void inserirVendedor(Plataforma vendedor) {
		String sql = "INSERT INTO vendedor(nome, api_get_categoria, api_get_atributo) values (:nome,:urlAPIGetCategorias,:urlAPIGetAtributos)";
	 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("nome", vendedor.getNome())
	    									.addValue("urlAPIGetCategorias", vendedor.getUrlAPIGetCategorias())
	    									.addValue("urlAPIGetAtributos", vendedor.getUrlAPIGetAtributos());

	    template.update(sql,param);
	}

	@Override
	public List<Plataforma> buscaTodosVendedores() {
        String sql = "SELECT * FROM vendedor";
        
        SqlParameterSource param = new MapSqlParameterSource();
        
        return template.query(sql, param, new BeanPropertyRowMapper(Plataforma.class));
	}

	@Override
	public List<Plataforma> buscaVendedores(Plataforma vendedor) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_vendedor as id");
		sql.append(",	   nome as nome");
		sql.append(",	   api_get_categoria as urlAPIGetCategorias");
		sql.append(",	   api_get_atributo as urlAPIGetAtributos");
		sql.append(" FROM vendedor");
		sql.append(" WHERE 1=1");

		if (vendedor.getId() != null) {
			sql.append(" and id_vendedor = :id ");
		}
		if (!vendedor.getNome().isEmpty()) {
			sql.append(" and nome = :nome ");
		}
		if (!vendedor.getUrlAPIGetCategorias().isEmpty()) {
			sql.append(" and api_get_categoria = :urlAPIGetCategorias ");
		}
		if (!vendedor.getUrlAPIGetAtributos().isEmpty()) {
			sql.append(" and api_get_atributo = :urlAPIGetAtributos ");
		}
		sql.append(" order  by id_vendedor");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", vendedor.getId())
	    		.addValue("nome", vendedor.getNome())
				.addValue("urlAPIGetCategorias", vendedor.getUrlAPIGetCategorias())
				.addValue("urlAPIGetAtributos", vendedor.getUrlAPIGetAtributos());	

	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(Plataforma.class));
	}

	@Override
	public Plataforma buscaVendedorPorId(Long id) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_vendedor as id");
		sql.append(",	   nome as nome");
		sql.append(",	   api_get_categoria as urlAPIGetCategorias");
		sql.append(",	   api_get_atributo as urlAPIGetAtributos");
		sql.append(" FROM vendedor");
		sql.append(" WHERE 1=1");
     	sql.append(" and id_vendedor = :id");
		

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", id);
	    
	    List<Plataforma> vendedor = template.query(sql.toString(), param, new BeanPropertyRowMapper(Plataforma.class));
        return vendedor.isEmpty() ? null : vendedor.get(0);
	    
	}

	@Override
	public void alterarVendedor(Plataforma vendedor) {
		String sql = "UPDATE vendedor SET nome = :nome, api_get_categoria = :urlAPIGetCategorias, api_get_atributo = :urlAPIGetAtributos WHERE id_vendedor = :id_vendedor";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("id_vendedor", vendedor.getId())
	    									.addValue("nome", vendedor.getNome())
	    									.addValue("urlAPIGetCategorias", vendedor.getUrlAPIGetCategorias())
	    									.addValue("urlAPIGetAtributos", vendedor.getUrlAPIGetAtributos());

	    template.update(sql,param);
	}	
	
	
}
