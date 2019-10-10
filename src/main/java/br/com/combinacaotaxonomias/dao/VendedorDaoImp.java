package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.Taxonomia;

@Repository("vendedorDao")
public class VendedorDaoImp implements VendedorDao{
	
	private NamedParameterJdbcTemplate template; 
	
	public VendedorDaoImp(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}
 
	@Override
	public void inserirVendedor(Plataforma vendedor) {
		String sql = "INSERT INTO vendedor(nome, api_get_categoria, api_get_atributo, api_post_autenticacao, api_token_id, api_token_key) values (:nome,:urlAPIGetCategorias,:urlAPIGetAtributos,:urlApiPostAutenticacao,:apiTokenId,:apiTokenKey)";
	 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("nome", vendedor.getNome())
	    									.addValue("urlAPIGetCategorias", vendedor.getUrlAPIGetCategorias())
	    									.addValue("urlAPIGetAtributos", vendedor.getUrlAPIGetAtributos())
	    									.addValue("urlApiPostAutenticacao", vendedor.getUrlApiPostAutenticacao())
	    									.addValue("apiTokenId", vendedor.getApiTokenId())
	    									.addValue("apiTokenKey", vendedor.getApiTokenKey());

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
			sql.append(" and nome LIKE :nome ");
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
	    		.addValue("nome", "%" + vendedor.getNome() + "%")
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
		sql.append(",	   api_post_autenticacao as urlApiPostAutenticacao");
		sql.append(",      api_token_id as apiTokenId");
		sql.append(",      api_token_key as apiTokenKey");
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
		String sql = "UPDATE vendedor SET nome = :nome, api_get_categoria = :urlAPIGetCategorias, api_get_atributo = :urlAPIGetAtributos, api_post_autenticacao = :urlApiPostAutenticacao, api_token_id = :apiTokenId, api_token_key = :apiTokenKey WHERE id_vendedor = :id_vendedor";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("id_vendedor", vendedor.getId())
	    									.addValue("nome", vendedor.getNome())
	    									.addValue("urlAPIGetCategorias", vendedor.getUrlAPIGetCategorias())
	    									.addValue("urlAPIGetAtributos", vendedor.getUrlAPIGetAtributos())
	    									.addValue("urlApiPostAutenticacao", vendedor.getUrlApiPostAutenticacao())
	    									.addValue("apiTokenId", vendedor.getApiTokenId())
	    									.addValue("apiTokenKey", vendedor.getApiTokenKey());

	    template.update(sql,param);
	}

	@Override
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Integer idVendedor) {
		String sql = "INSERT INTO categoria_vendedor(codigo_categoria, nome, id_vendedor, id_categoria_pai) values (:idCategoria, :nomeCategoria, :idVendedor, :idCategoriaPai)";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("idCategoria", categoria.getId())
	    									.addValue("nomeCategoria", categoria.getNome())
	    									.addValue("idVendedor", idVendedor)
	    									.addValue("idCategoriaPai", idCategoriaPai);

	    template.update(sql,param);
	}

	@Override
	public Integer getUltimoIdVendedor() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT max(id_vendedor) as id");
		sql.append(" FROM vendedor");
	
	    SqlParameterSource param = new MapSqlParameterSource();	

	    List<Integer> id = template.queryForList(sql.toString(), param, Integer.class);
	    return id.get(0);
	}

	@Override
	public void inserirAtributo(Atributo atributo, Integer idVendedor) {
		String sql = "INSERT INTO atributo_vendedor(codigo_atributo, nome, tipo, id_categoria_vendedor, id_vendedor) values (:codigoAtributo, :nomeCategoria, :tipo, :idCategoriaPai, :idVendedor)";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("codigoAtributo", atributo.getId())
	    									.addValue("nomeCategoria", atributo.getNome())
	    									.addValue("tipo", atributo.getTipoAtributo().toString())
	    									.addValue("idCategoriaPai", atributo.getCategoriaId())	    									
	    									.addValue("idVendedor", idVendedor);


	    template.update(sql,param);	
	}	
}
