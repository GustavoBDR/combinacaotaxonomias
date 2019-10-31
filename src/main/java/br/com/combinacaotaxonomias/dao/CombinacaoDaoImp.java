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
import br.com.combinacaotaxonomias.model.to.CombinacaoAtributoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTO;
import br.com.combinacaotaxonomias.model.to.CombinacaoTaxonomiaTO;

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
				.addValue("idCombinacao", combinacao.getIdCombinacao())
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
	public void inserirCombinacaoAtributos(Long idCombinacao, CombinacaoAtributo combinacaoAtributo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO combinacao_atributo (id_combinacao,  ");
		sql.append("								 id_atributo_marketplace, ");
		sql.append("								 id_atributo_vendedor) ");
		sql.append(" VALUES ");
		sql.append("(:idCombinacao, :idAtributoMarketplace, :idAtributoVendedor) ");
	
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("idCombinacao", idCombinacao)
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
	public Combinacao buscaCombinacaoPorId(Long id) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_combinacao as idCombinacao ");
		sql.append(",	   nome as nome ");
		sql.append(",	   descricao as descricao ");
		sql.append(",	   id_marketplace as idMarketplace ");
		sql.append(",	   id_vendedor as idVendedor ");	
		sql.append(" FROM combinacao");
		sql.append(" WHERE 1=1");
		sql.append(" and id_combinacao = :id ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", id);

	    List<Combinacao> combinacao = template.query(sql.toString(), param, new BeanPropertyRowMapper(Combinacao.class));
        return combinacao.isEmpty() ? null : combinacao.get(0);
	}
	
	@Override
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoId(Long id) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT linha.id_combinacao_categoria as idCombinacaoCategoria ");
		sql.append(" , 	    linha.id_combinacao as idCombinacao ");
		sql.append(" , 	    linha.id_categoria_marketplace as idLinhaMarketplace ");
		sql.append(" ,      linha.id_categoria_vendedor as idLinhaVendedor ");
		sql.append(" , 	    familia.id_categoria_marketplace as idFamiliaMarketplace ");
		sql.append(" ,      familia.id_categoria_vendedor as idFamiliaVendedor ");
		sql.append(" , 	    grupo.id_categoria_marketplace as idGrupoMarketplace ");
		sql.append(" ,      grupo.id_categoria_vendedor as idGrupoVendedor ");
		sql.append(" FROM combinacao_categoria linha ");
		sql.append(" inner join combinacao_categoria familia on (familia.id_categoria_pai_marketplace = linha.id_categoria_marketplace  and ");
		sql.append(" 										     familia.id_categoria_pai_vendedor    = linha.id_categoria_vendedor and ");
		sql.append(" 										     familia.id_combinacao 				  = linha.id_combinacao) ");
		sql.append(" inner join combinacao_categoria grupo   on (grupo.id_categoria_pai_marketplace   = familia.id_categoria_marketplace  and ");
		sql.append(" 										     grupo.id_categoria_pai_vendedor      = familia.id_categoria_vendedor and ");
		sql.append(" 										     grupo.id_combinacao                  = familia.id_combinacao) ");	 
		sql.append(" WHERE linha.id_combinacao = :id ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", id);

	    List<Combinacao> combinacao = template.query(sql.toString(), param, new BeanPropertyRowMapper(Combinacao.class));
        return combinacao.isEmpty() ? null : combinacao.get(0);
	}

	@Override
	public Combinacao buscaCombinacaoCategoriaPorCombinacaoIdCompleto(Long id) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT linha.id_combinacao as idCombinacao ");
		sql.append(" ,      c.nome as nome ");
		sql.append(" ,      c.descricao as descricao ");
		sql.append(" ,      c.id_marketplace as idMarketplace ");
		sql.append(" ,      c.id_vendedor as idVendedor ");
		sql.append(" ,      linha.id_combinacao_categoria as idCombinacaoCategoria ");
		sql.append(" , 	    linha.id_categoria_marketplace as idLinhaMarketplace ");
		sql.append(" ,      linha.id_categoria_vendedor as idLinhaVendedor ");
		sql.append(" , 	    familia.id_categoria_marketplace as idFamiliaMarketplace ");
		sql.append(" ,      familia.id_categoria_vendedor as idFamiliaVendedor ");
		sql.append(" , 	    grupo.id_categoria_marketplace as idGrupoMarketplace ");
		sql.append(" ,      grupo.id_categoria_vendedor as idGrupoVendedor ");
		sql.append(" FROM combinacao_categoria linha ");
		sql.append(" inner join combinacao_categoria familia on (familia.id_categoria_pai_marketplace = linha.id_categoria_marketplace  and ");
		sql.append(" 										     familia.id_categoria_pai_vendedor    = linha.id_categoria_vendedor and ");
		sql.append(" 										     familia.id_combinacao 				  = linha.id_combinacao) ");
		sql.append(" inner join combinacao_categoria grupo on (grupo.id_categoria_pai_marketplace = familia.id_categoria_marketplace  and ");
		sql.append(" 										   grupo.id_categoria_pai_vendedor    = familia.id_categoria_vendedor and ");
		sql.append(" 										   grupo.id_combinacao                = familia.id_combinacao) ");
		sql.append(" inner join combinacao c on (c.id_combinacao = linha.id_combinacao)  ");
		sql.append(" inner join marketplace m on (m.id_marketplace = c.id_marketplace) ");
		sql.append(" inner join vendedor v on (v.id_vendedor = c.id_vendedor) ");
		sql.append(" WHERE linha.id_combinacao = :id ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", id);

	    List<Combinacao> combinacao = template.query(sql.toString(), param, new BeanPropertyRowMapper(Combinacao.class));
        return combinacao.isEmpty() ? null : combinacao.get(0);
	}

	@Override
	public void updateCombinacao(Combinacao novaCombinacao) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE combinacao ");
		sql.append("   SET nome= :nome ");
		sql.append(", 	   descricao= :descricao ");
		sql.append("WHERE id_combinacao = :idCombinacao ");		
		
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("nome", novaCombinacao.getNome())
	    									.addValue("descricao", novaCombinacao.getDescricao())
	    									.addValue("idCombinacao", novaCombinacao.getIdCombinacao());   								

	    template.update(sql.toString(),param);
	}

	@Override
	public void deleteCombinacaoAtributos(Combinacao novaCombinacao) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM combinacao_atributo ");
		sql.append("  WHERE id_combinacao = :idCombinacao ");;		
		
	    SqlParameterSource param = new MapSqlParameterSource()
	    									.addValue("idCombinacao", novaCombinacao.getIdCombinacaoCategoria());   								

	    template.update(sql.toString(),param);
	}

	@Override
	public List<Combinacao> buscaCombinacaoPorIdMarketplace(Long idMarketplace) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT id_combinacao as idCombinacao ");
		sql.append(" , 		nome as nome ");
		sql.append(" ,		descricao as descricao ");
		sql.append(" ,	 	id_marketplace as idMarketplace ");
		sql.append(" , 		id_vendedor as idVendedor ");
		sql.append(" FROM combinacao ");
		sql.append(" WHERE id_marketplace = :idMarketplace ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idMarketplace", idMarketplace);

	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(Combinacao.class));
	}	
	
	@Override
	public List<Combinacao> buscaCombinacaoPorIdVendedor(Long idVendedor) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT id_combinacao as idCombinacao ");
		sql.append(" , 		nome as nome ");
		sql.append(" ,		descricao as descricao ");
		sql.append(" ,	 	id_marketplace as idMarketplace ");
		sql.append(" , 		id_vendedor as idVendedor ");
		sql.append(" FROM combinacao ");
		sql.append(" WHERE id_marketplace = :idVendedor ");
		
	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idVendedor", idVendedor);

	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(Combinacao.class));
	}
	
	@Override
	public List<Combinacao> buscaCombinacaoPorIdMarketplaceCompleto(Long idMarketplace) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT linha.id_combinacao as idCombinacao ");
		sql.append(" ,      c.nome as nome ");
		sql.append(" ,      c.descricao as descricao ");
		sql.append(" ,      c.id_marketplace as idMarketplace ");
		sql.append(" ,      c.id_vendedor as idVendedor ");
		sql.append(" ,      linha.id_combinacao_categoria as idCombinacaoCategoria ");
		sql.append(" , 	    linha.id_categoria_marketplace as idLinhaMarketplace ");
		sql.append(" ,      linha.id_categoria_vendedor as idLinhaVendedor ");
		sql.append(" , 	    familia.id_categoria_marketplace as idFamiliaMarketplace ");
		sql.append(" ,      familia.id_categoria_vendedor as idFamiliaVendedor ");
		sql.append(" , 	    grupo.id_categoria_marketplace as idGrupoMarketplace ");
		sql.append(" ,      grupo.id_categoria_vendedor as idGrupoVendedor ");
		sql.append(" FROM combinacao_categoria linha ");
		sql.append(" inner join combinacao_categoria familia on (familia.id_categoria_pai_marketplace = linha.id_categoria_marketplace  and ");
		sql.append(" 										     familia.id_categoria_pai_vendedor    = linha.id_categoria_vendedor and ");
		sql.append(" 										     familia.id_combinacao 				  = linha.id_combinacao) ");
		sql.append(" inner join combinacao_categoria grupo on (grupo.id_categoria_pai_marketplace = familia.id_categoria_marketplace  and ");
		sql.append(" 										   grupo.id_categoria_pai_vendedor    = familia.id_categoria_vendedor and ");
		sql.append(" 										   grupo.id_combinacao                = familia.id_combinacao) ");
		sql.append(" inner join combinacao c on (c.id_combinacao = linha.id_combinacao)  ");
		sql.append(" inner join marketplace m on (m.id_marketplace = c.id_marketplace) ");
		sql.append(" inner join vendedor v on (v.id_vendedor = c.id_vendedor) ");
		sql.append(" WHERE c.id_marketplace = :idMarketplace ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idMarketplace", idMarketplace);

	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(Combinacao.class));
	}

	@Override
	public List<CombinacaoTaxonomiaTO> buscaCombinacaoTaxonomiaPorIdMarketplace(Long idMarketplace) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT linha.id_combinacao as idCombinacao, ");
	    sql.append("        c.nome as nome, ");
	    sql.append("        c.descricao as descricao, ");
	    sql.append("        c.id_marketplace as idMarketplace, ");
	    sql.append("        c.id_vendedor as idVendedor, ");
	    sql.append("        linha.id_categoria_marketplace as idLinhaMarketplace, ");
	    sql.append("        linhacm.nome as nomeLinhaMarketplace,    ");
	    sql.append("        familia.id_categoria_marketplace as idFamiliaMarketplace, ");
	    sql.append("        familiacm.nome as nomeFamiliaMarketplace,          ");
	    sql.append("        grupo.id_categoria_marketplace as idGrupoMarketplace, ");
	    sql.append("        grupocm.nome as nomeGrupoMarktetplace,       ");
	    sql.append("        linha.id_categoria_vendedor as idLinhaVendedor, ");
	    sql.append("        linhacv.nome as nomeLinhaVendedor,         ");
	    sql.append("        familia.id_categoria_vendedor as idFamiliaVendedor, ");
	    sql.append("        familiacv.nome as nomeFamiliaVendedor,     ");
	    sql.append("        grupo.id_categoria_vendedor as idGrupoVendedor, ");
	    sql.append("        grupocv.nome as nomeGrupoVendedor ");
	    sql.append("   FROM combinacao c ");
	    sql.append("   INNER JOIN combinacao_categoria linha on (linha.id_combinacao = c.id_combinacao) ");
	    sql.append("   INNER JOIN combinacao_categoria familia on (familia.id_categoria_pai_marketplace = linha.id_categoria_marketplace and ");
	    sql.append("                         familia.id_categoria_pai_vendedor = linha.id_categoria_vendedor and  ");
	    sql.append("                           familia.id_combinacao = linha.id_combinacao) ");
	    sql.append("   INNER JOIN combinacao_categoria grupo on (grupo.id_categoria_pai_marketplace = familia.id_categoria_marketplace and ");
	    sql.append("                       grupo.id_categoria_pai_vendedor = familia.id_categoria_vendedor and  ");
	    sql.append("                         grupo.id_combinacao = familia.id_combinacao) ");
	    sql.append("   INNER JOIN categoria_marketplace linhacm on (linhacm.id_categoria_marketplace = linha.id_categoria_marketplace) ");
	    sql.append("   INNER JOIN categoria_marketplace familiacm on (familiacm.id_categoria_marketplace = familia.id_categoria_marketplace) ");
	    sql.append("   INNER JOIN categoria_marketplace grupocm on (grupocm.id_categoria_marketplace = grupo.id_categoria_marketplace) ");
	    sql.append("   INNER JOIN categoria_vendedor linhacv on (linhacv.id_categoria_vendedor = linha.id_categoria_vendedor) ");
	    sql.append("   INNER JOIN categoria_vendedor familiacv on (familiacv.id_categoria_vendedor = familia.id_categoria_vendedor) ");
	    sql.append("   INNER JOIN categoria_vendedor grupocv on (grupocv.id_categoria_vendedor = grupo.id_categoria_vendedor) ");
	    sql.append("   where c.id_marketplace = :idMarketplace ");

	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idMarketplace", idMarketplace);
	    
	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(CombinacaoTaxonomiaTO.class));
	}

	@Override
	public List<CombinacaoAtributoTO> buscaCombinacaoTaxonomiaAtributos(String idCombinacao) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select  ca.id_combinacao as idCombinacao ");
	    sql.append(" ,       am.codigo_atributo as idAtributoMarketplace ");
	    sql.append(" ,       am.nome as nomeAtributoMarketplace ");
	    sql.append(" ,       am.tipo as tipoAtributoMarketplace ");
	    sql.append(" ,       av.codigo_atributo as idAtributoVendedor ");
	    sql.append(" ,       av.nome as nomeAtributoVendedor ");
	    sql.append(" ,       av.tipo as tipoAtributoVendedor ");
	    sql.append("   from combinacao_atributo ca ");
	    sql.append("   inner join atributo_marketplace am on (am.id_atributo_marketplace = ca.id_atributo_marketplace) ");
	    sql.append("   inner join atributo_vendedor av on (av.id_atributo_vendedor = ca.id_atributo_vendedor) ");
	    sql.append("  where ca.id_combinacao = :idCombinacao ");
	    
	    SqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("idCombinacao", Long.valueOf(idCombinacao));
	    
	    return template.query(sql.toString(), param, new BeanPropertyRowMapper(CombinacaoAtributoTO.class));
	}	
}
