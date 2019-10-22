package br.com.combinacaotaxonomias.dao;

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

		String sql = "INSERT INTO combinacao(nome, descricao, id_marketplace, id_vendedor) values (:nome, :descricao, :id_marketplace, :id_vendedor)";
	    
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("nome", combinacao.getNome())
				.addValue("descricao", combinacao.getDescricao())
				.addValue("id_marketplace", combinacao.getIdMarketplace())
				.addValue("id_vendedor", combinacao.getIdVendedor());

	    template.update(sql,param);
	}

	@Override
	public Integer buscaUltimaCombinacaoCadastrada() {

		return null;
	}

}
