package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Taxonomia;
import br.com.combinacaotaxonomias.model.to.AtributoTO;
import br.com.combinacaotaxonomias.model.to.CategoriaCombinacaoTO;
import br.com.combinacaotaxonomias.common.TipoAtributo;
import br.com.combinacaotaxonomias.model.Atributo;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
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
	public void inserirCategoria(Taxonomia categoria, Integer idCategoriaPai, Long idMarketplace) {
		String sql = "INSERT INTO categoria_marketplace(codigo_categoria, nome, id_marketplace, id_categoria_pai) values (:idCategoria, :nomeCategoria, :idMarketplace, :idCategoriaPai)";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("idCategoria", categoria.getId())
	    									.addValue("nomeCategoria", categoria.getNome())
	    									.addValue("idMarketplace", idMarketplace)
	    									.addValue("idCategoriaPai", idCategoriaPai);

	    template.update(sql,param);
	}

	@Override
	public Long getUltimoIdMarketplace() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT max(id_marketplace) as id");
		sql.append(" FROM marketplace");
	
	    SqlParameterSource param = new MapSqlParameterSource();	

	    List<Long> id = template.queryForList(sql.toString(), param, Long.class);
	    return id.get(0);
	}

	@Override
	public void inserirAtributo(Atributo atributo, Long idMarketplace) {
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
	public void inserirCategoriaTO(CategoriaCombinacaoTO categoria) {
		String sql = "INSERT INTO categoria_marketplace(codigo_categoria, nome, id_marketplace, id_categoria_pai) values (:idCategoria, :nomeCategoria, :idMarketplace, :idCategoriaPai)";
		 
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("idCategoria", categoria.getIdCategoriaPlataforma())
	    									.addValue("nomeCategoria", categoria.getNome())
	    									.addValue("idMarketplace", categoria.getIdPlataforma())
	    									.addValue("idCategoriaPai", categoria.getIdPai());

	    template.update(sql,param);
	}

	@Override
	public List<CategoriaCombinacaoTO> buscaCategoriasPorMarketplace(Long idMarketplace) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_categoria_marketplace as idCategoria");
		sql.append(",      codigo_categoria as idCategoriaPlataforma ");
		sql.append(",	   nome as nome ");
		sql.append(",	   id_marketplace as idPlataforma ");
		sql.append(",	   id_categoria_pai as idPai ");	
		sql.append(" FROM categoria_marketplace ");
		sql.append(" WHERE 1=1 ");
		sql.append(" and id_categoria_pai is null ");
     	sql.append(" and id_marketplace = :id ");
		

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", idMarketplace);
	    
	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(CategoriaCombinacaoTO.class));
	}

	@Override
	public List<CategoriaCombinacaoTO> buscaCategoriasFilhas(Long idMarketplace, Integer idCategoriaPai) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_categoria_marketplace as idCategoria ");
		sql.append(",	   codigo_categoria as idCategoriaPlataforma ");
		sql.append(",	   nome as nome ");
		sql.append(",	   id_marketplace as idPlataforma ");
		sql.append(",	   id_categoria_pai as idPai ");	
		sql.append(" FROM categoria_marketplace ");
		sql.append(" WHERE 1=1 ");
		sql.append(" and id_categoria_pai = :idCategoriaPai ");
     	sql.append(" and id_marketplace = :idMarketplace ");
		

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idMarketplace", idMarketplace)
	    		.addValue("idCategoriaPai", idCategoriaPai);
	    
	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(CategoriaCombinacaoTO.class));
	}

	@Override
	public List<AtributoTO> buscaAtributosPorCategoria(Integer idCategoria, Long idMarketplace) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT am.id_atributo_marketplace as idAtributo ");
		sql.append(" ,     am.codigo_atributo as idPlataforma");
		sql.append(" ,	   am.nome as nome ");
		sql.append(" ,	   am.id_categoria_marketplace as categoriaId  ");
		sql.append(" ,	   am.tipo as tipoAtributo ");
		sql.append("  FROM atributo_marketplace am ");
		sql.append("  inner join categoria_marketplace cm on (cm.codigo_categoria = am.id_categoria_marketplace) and (cm.id_marketplace = am.id_marketplace) ");
		sql.append("  WHERE 1=1 ");
		sql.append("  and cm.id_categoria_marketplace = :idCategoria ");
		sql.append("  and am.id_marketplace = :idMarketplace ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idMarketplace", idMarketplace)
	    		.addValue("idCategoria", idCategoria);
	    
	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(AtributoTO.class));
	}

	@Override
	public CategoriaCombinacaoTO buscaCategoriaCombinacaoPorId(Integer idCategoria) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_categoria_marketplace as idCategoria ");
		sql.append(",	   codigo_categoria as idCategoriaPlataforma ");
		sql.append(",	   nome as nome ");
		sql.append(",	   id_marketplace as idPlataforma ");
		sql.append(",	   id_categoria_pai as idPai ");	
		sql.append(" FROM categoria_marketplace ");
		sql.append(" WHERE 1=1 ");
		sql.append(" and id_categoria_marketplace = :idCategoria ");
		

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idCategoria", idCategoria);
	    
	    List<CategoriaCombinacaoTO> categoriaCombinacaoTO = template.query(sql.toString(), param, new BeanPropertyRowMapper(CategoriaCombinacaoTO.class));
	    return categoriaCombinacaoTO.isEmpty() ? null : categoriaCombinacaoTO.get(0);
	}	
}
