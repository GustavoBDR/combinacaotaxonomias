package br.com.combinacaotaxonomias.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.combinacaotaxonomias.model.Combinacao;

@Repository("combinacaoDao")
public class CombinacaoDaoImp implements CombinacaoDao{

	private NamedParameterJdbcTemplate template;
	
	@Override
	public void inserirCombinacao(Combinacao combinacao) {

		String sql = "INSERT INTO combinacao(nome, descricao, id_marketplace, id_vendedor) values (:nome, :descricao, :idMarketplace, :idVendedor)";
	    
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
		sql.append("(:id_combinacao, :idCategoriaLinhaMarketplacem, :idCategoriaLinhaVendedor, null, null), ");
		sql.append("(:id_combinacao, :idCategoriaFamiliaMarketplace, :idCategoriaFamiliaVendedor, :idCategoriaLinhaMarketplacem, :idCategoriaLinhaVendedor), ");
		sql.append("(:id_combinacao, :idCategoriaGrupoMarketplace, :idCategoriaGrupoVendedor, :idCategoriaFamiliaMarketplace, :idCategoriaFamiliaVendedor) ");
		
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id_combinacao", combinacao.getId())
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

}
