package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.common.TipoAtributo;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.CategoriaTO;
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
        StringBuilder sql = new StringBuilder();
        
		sql.append("SELECT id_marketplace as id");
		sql.append(",	   nome as nome");
		sql.append(",	   api_get_categoria as urlAPIGetCategorias");
		sql.append(",	   api_get_atributo as urlAPIGetAtributos");
		sql.append(" FROM marketplace");
        
        SqlParameterSource param = new MapSqlParameterSource();
        
        return template.query(sql.toString(), param, new BeanPropertyRowMapper(Plataforma.class));
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

	@Override
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Integer idMarketplace) {
		String sql = "INSERT INTO categoria_marketplace(codigo_categoria, nome, id_marketplace, id_categoria_pai) values (:idCategoria, :nomeCategoria, :idMarketplace, :idCategoriaPai)";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("idCategoria", categoria.getId())
	    									.addValue("nomeCategoria", categoria.getNome())
	    									.addValue("idMarketplace", idMarketplace)
	    									.addValue("idCategoriaPai", idCategoriaPai);

	    template.update(sql,param);
	}

	@Override
	public Integer getUltimoIdMarketplace() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT max(id_marketplace) as id");
		sql.append(" FROM marketplace");
	
	    SqlParameterSource param = new MapSqlParameterSource();	

	    List<Integer> id = template.queryForList(sql.toString(), param, Integer.class);
	    return id.get(0);
	}

	@Override
	public void inserirAtributo(Atributo atributo, Integer idMarketplace) {
		String sql = "INSERT INTO atributo_marketplace(codigo_atributo, nome, tipo, id_categoria_marketplace, id_marketplace) values (:codigoAtributo, :nomeCategoria, :tipo, :idCategoriaPai, :idMarketplace)";
		 		
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("codigoAtributo", atributo.getId())
	    									.addValue("nomeCategoria", atributo.getNome())
	    									.addValue("tipo", atributo.getTipoAtributo().toString())
	    									.addValue("idCategoriaPai", atributo.getCategoriaId())	    									
	    									.addValue("idMarketplace", idMarketplace);


	    template.update(sql,param);	
	}

	@Override
	public void inserirCategoriaTO(CategoriaTO categoria) {
		String sql = "INSERT INTO categoria_marketplace(codigo_categoria, nome, id_marketplace, id_categoria_pai) values (:idCategoria, :nomeCategoria, :idMarketplace, :idCategoriaPai)";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("idCategoria", categoria.getIdCategoria())
	    									.addValue("nomeCategoria", categoria.getNome())
	    									.addValue("idMarketplace", categoria.getIdMarketplace())
	    									.addValue("idCategoriaPai", categoria.getIdPai());

	    template.update(sql,param);
	}

	@Override
	public List<CategoriaTO> buscaCategoriasPorMarketplace(Integer idMarketplace) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT codigo_categoria as idCategoria ");
		sql.append(",	   nome as nome ");
		sql.append(",	   id_marketplace as idMarketplace ");
		sql.append(",	   id_categoria_pai as idPai ");	
		sql.append(" FROM categoria_marketplace ");
		sql.append(" WHERE 1=1 ");
		sql.append(" and id_categoria_pai is null ");
     	sql.append(" and id_marketplace = :id ");
		

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", idMarketplace);
	    
	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(CategoriaTO.class));
	}
}
