package com.lucianoortizsilva.produto.batch.enumeration;

public enum Status {

	/**
	 * 
	 * Quando o arquivo CSV foi processado sem erros, porem ainda não foi cadastrado
	 * na tabela produto.
	 * 
	 */
	AGUARDANDO,
	
	
	
	/**
	 * 
	 * Quando o Produto foi cadastrado na tabela PRODUTO
	 * 
	 */
	FINALIZADO,
	
	
	
	/**
	 * 
	 * Quando aconteceu algum erro no processamento do arquivo CSV
	 * 
	 */
	ERRO;

	private Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}

}