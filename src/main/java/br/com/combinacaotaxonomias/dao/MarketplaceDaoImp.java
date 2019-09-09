package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Plataforma;

@Repository("marketplaceDao")
public class MarketplaceDaoImp implements MarketplaceDao{

	private NamedParameterJdbcTemplate template; 
	
	public MarketplaceDaoImp(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}
 
	@Override
	public void inserirMarketplace(Plataforma marketplace) {
		String sql = "INSERT INTO marketplace(nome, api_get_categoria, api_get_atributo, api_post_autenticacao, api_token_id, api_token_key) values (:nome,:urlAPIGetCategorias,:urlAPIGetAtributos,:urlApiPostAutenticacao,:apiTokenId,:apiTokenKey)";
	 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("nome", marketplace.getNome())
	    									.addValue("urlAPIGetCategorias", marketplace.getUrlAPIGetCategorias())
	    									.addValue("urlAPIGetAtributos", marketplace.getUrlAPIGetAtributos())
	    									.addValue("urlApiPostAutenticacao", marketplace.getUrlApiPostAutenticacao())
	    									.addValue("apiTokenId", marketplace.getApiTokenId())
	    									.addValue("apiTokenKey", marketplace.getApiTokenKey());

	    template.update(sql,param);
	}

	@Override
	public List<Plataforma> buscaTodosMarketplaces() {
        String sql = "SELECT * FROM marketplace";
        
        SqlParameterSource param = new MapSqlParameterSource();
        
        return template.query(sql, param, new BeanPropertyRowMapper(Plataforma.class));
	}

	@Override
	public List<Plataforma> buscaMarketplaces(Plataforma marketplace) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_marketplace as id");
		sql.append(",	   nome as nome");
		sql.append(",	   api_get_categoria as urlAPIGetCategorias");
		sql.append(",	   api_get_atributo as urlAPIGetAtributos");
		sql.append(" FROM marketplace");
		sql.append(" WHERE 1=1");

		if (marketplace.getId() != null) {
			sql.append(" and id_marketplace = :id ");
		}
		if (!marketplace.getNome().isEmpty()) {
			sql.append(" and nome LIKE :nome ");
		}
		if (!marketplace.getUrlAPIGetCategorias().isEmpty()) {
			sql.append(" and api_get_categoria = :urlAPIGetCategorias ");
		}
		if (!marketplace.getUrlAPIGetAtributos().isEmpty()) {
			sql.append(" and api_get_atributo = :urlAPIGetAtributos ");
		}
		sql.append(" order  by id_marketplace");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", marketplace.getId())
	    		.addValue("nome", "%" + marketplace.getNome() + "%")
				.addValue("urlAPIGetCategorias", marketplace.getUrlAPIGetCategorias())
				.addValue("urlAPIGetAtributos", marketplace.getUrlAPIGetAtributos());	

	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(Plataforma.class));
	}

	@Override
	public Plataforma buscaMarketplacePorId(Long id) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_marketplace as id");
		sql.append(",	   nome as nome");
		sql.append(",	   api_get_categoria as urlAPIGetCategorias");
		sql.append(",	   api_get_atributo as urlAPIGetAtributos");
		sql.append(",	   api_post_autenticacao as urlApiPostAutenticacao");
		sql.append(",      api_token_id as apiTokenId");
		sql.append(",      api_token_key as apiTokenKey");		
		sql.append(" FROM marketplace");
		sql.append(" WHERE 1=1");
     	sql.append(" and id_marketplace = :id");
		

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", id);
	    
	    List<Plataforma> marketplace = template.query(sql.toString(), param, new BeanPropertyRowMapper(Plataforma.class));
        return marketplace.isEmpty() ? null : marketplace.get(0);
	    
	}

	@Override
	public void alterarMarketplace(Plataforma marketplace) {
		String sql = "UPDATE marketplace SET nome = :nome, api_get_categoria = :urlAPIGetCategorias, api_get_atributo = :urlAPIGetAtributos, api_post_autenticacao = :urlApiPostAutenticacao, api_token_id = :apiTokenId, api_token_key = :apiTokenKey WHERE id_marketplace = :id_marketplace";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("id_marketplace", marketplace.getId())
	    									.addValue("nome", marketplace.getNome())
	    									.addValue("urlAPIGetCategorias", marketplace.getUrlAPIGetCategorias())
	    									.addValue("urlAPIGetAtributos", marketplace.getUrlAPIGetAtributos())
	    									.addValue("urlApiPostAutenticacao", marketplace.getUrlApiPostAutenticacao())
	    									.addValue("apiTokenId", marketplace.getApiTokenId())
	    									.addValue("apiTokenKey", marketplace.getApiTokenKey());	    								

	    template.update(sql,param);
	}	
}
