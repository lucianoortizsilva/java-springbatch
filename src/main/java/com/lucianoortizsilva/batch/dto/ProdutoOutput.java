package com.lucianoortizsilva.batch.dto;

import java.io.Serializable;

import com.lucianoortizsilva.batch.enumeration.Categoria;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProdutoOutput implements Serializable {

	private static final long serialVersionUID = -8665740626196988682L;
	private String descricao;
	private String ean;
	private Categoria categoria;
	private String categoriaTexto;

	public ProdutoOutput(final Categoria c) {
		this.categoriaTexto = c.name();
	}

}