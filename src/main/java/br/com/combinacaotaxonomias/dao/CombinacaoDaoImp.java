package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Combinacao;
import br.com.combinacaotaxonomias.model.CombinacaoAtributo;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;

@Repository("combinacaoDao")
public class CombinacaoDaoImp implements CombinacaoDao{

	private NamedParameterJdbcTemplate template; 
	
	public CombinacaoDaoImp(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}
	
	@Override
	public void inserirCombinacao(Combinacao combinacao) {

		String sql = "INSERT INTO combinacao (nome, descricao, id_marketplace, id_vendedor) values (:nome, :descricao, :idMarketplace, :idVendedor)";
		
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("nome", combinacao.getNome())
				.addValue("descricao", combinacao.getDescricao())
				.addValue("idMarketplace", combinacao.getIdMarketplace())
				.addValue("idVendedor", combinacao.getIdVendedor());

	    template.update(sql,param);
	}
	
	@Override
	public void inserirCombinacaoCategoria(Combinacao combinacao) {

		//String sql = "INSERT INTO combinacao_categoria(id_combinacao, id_categoria_marketplace, id_categoria_vendedor) values ()";
	    
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO combinacao_categoria(id_combinacao,  ");
		sql.append("								 id_categoria_marketplace, ");
		sql.append("								 id_categoria_vendedor, ");
		sql.append("								 id_categoria_pai_marketplace, ");
		sql.append("								 id_categoria_pai_vendedor) ");
		sql.append("VALUES");
		sql.append("(:idCombinacao, :idCategoriaLinhaMarketplace, :idCategoriaLinhaVendedor, null, null), ");
		sql.append("(:idCombinacao, :idCategoriaFamiliaMarketplace, :idCategoriaFamiliaVendedor, :idCategoriaLinhaMarketplace, :idCategoriaLinhaVendedor), ");
		sql.append("(:idCombinacao, :idCategoriaGrupoMarketplace, :idCategoriaGrupoVendedor, :idCategoriaFamiliaMarketplace, :idCategoriaFamiliaVendedor) ");
		
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("idCombinacao", combinacao.getId())
				.addValue("idCategoriaLinhaMarketplace", combinacao.getIdLinhaMarketplace())
				.addValue("idCategoriaLinhaVendedor", combinacao.getIdLinhaVendedor())
				.addValue("idCategoriaFamiliaMarketplace", combinacao.getIdFamiliaMarketplace())
				.addValue("idCategoriaFamiliaVendedor", combinacao.getIdFamiliaVendedor())
				.addValue("idCategoriaGrupoMarketplace", combinacao.getIdGrupoMarketplace())
				.addValue("idCategoriaGrupoVendedor", combinacao.getIdGrupoVendedor());
		
	    template.update(sql.toString(),param);
	}	

	@Override
	public Long buscaUltimaCombinacaoCadastrada() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT max(id_combinacao) as id");
		sql.append(" FROM combinacao");
	
	    SqlParameterSource param = new MapSqlParameterSource();	

	    List<Long> id = template.queryForList(sql.toString(), param, Long.class);
	    return id.get(0);
	}

	@Override
	public void inserirCombinacaoAtributos(Long idCombinacaoCategoria, CombinacaoAtributo combinacaoAtributo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO combinacao_atributo (id_combinacao_categoria,  ");
		sql.append("								 id_atributo_marketplace, ");
		sql.append("								 id_atributo_vendedor) ");
		sql.append(" VALUES ");
		sql.append("(:idCombinacaoCategoria, :idAtributoMarketplace, :idAtributoVendedor) ");
	
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("idCombinacaoCategoria", idCombinacaoCategoria)
				.addValue("idAtributoMarketplace", combinacaoAtributo.getIdAtributoMarketplace())
				.addValue("idAtributoVendedor", combinacaoAtributo.getIdAtributoVendedor());
		
	    template.update(sql.toString(),param);
	}

	@Override
	public Long buscaUltimaCombinacaoCategoriaCadastrada() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT max(id_combinacao_categoria) as id");
		sql.append(" FROM combinacao_categoria");
	
	    SqlParameterSource param = new MapSqlParameterSource();	

	    List<Long> id = template.queryForList(sql.toString(), param, Long.class);
	    return id.get(0);
	}

	@Override
	public List<CombinacaoTO> buscaCombinacao(CombinacaoTO combinacaoTO) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_combinacao as idCombinacao");
		sql.append(",	   nome as nome");		
		sql.append(",	   descricao as descricao");
		sql.append(" FROM combinacao");
		sql.append(" WHERE 1=1");

		if (combinacaoTO.getNome() != null) {
			sql.append(" and nome LIKE :nome ");
		}
		if (combinacaoTO.getDescricao() != null) {
			sql.append(" and descricao LIKE :descricao ");
		}

		sql.append(" order  by 1");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("nome", "%" + combinacaoTO.getNome() + "%")
	    		.addValue("descricao", "%" + combinacaoTO.getDescricao() + "%");	

	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(CombinacaoTO.class));
	}

	@Override
	public CombinacaoTO buscaCombinacaoPorId(Long id) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_combinacao as idCombinacao ");
		sql.append(",	   nome as nome ");
		sql.append(",	   descricao as descricao ");
		sql.append(",	   id_marketplace as idMarketplace ");
		sql.append(",	   id_vendedor as idVendedor ");	
		sql.append(" FROM combinacao");
		sql.append(" WHERE 1=1");
		sql.append(" and id_combinacao LIKE :id ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", id);

	    List<CombinacaoTO> combinacaoTO = template.queryForList(sql.toString(), param, CombinacaoTO.class);
	    return combinacaoTO.get(0);
	}
}
