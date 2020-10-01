package com.lucianoortizsilva.cadastro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lucianoortizsilva.cadastro.model.Categoria;
import com.lucianoortizsilva.cadastro.model.Produto;
import com.lucianoortizsilva.cadastro.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProdutoRepository produtoRepository; 

	@Transactional
	public void cadastrarProdutos() {
		final List<Produto> produtos = new ArrayList<>();
		final String sql = "SELECT id, descricao, ean, mensagem, status, categoria time FROM PRODUTO_OUTPUT where status = 'AGUARDANDO'";
	    this.jdbcTemplate.query(sql,(rs, row) -> create(rs)).forEach(i -> produtos.add(i));;
	    this.produtoRepository.saveAll(produtos);
    }
	
	private Produto create(final ResultSet rs) throws SQLException {
		final Produto produto = new Produto();
		produto.setEan(rs.getString("ean"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setCategoria(Categoria.getByCodigo(rs.getInt("categoria")));
		return produto;
	}
	
}