package com.lucianoortizsilva.batch.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoOutput implements Serializable {

	private static final long serialVersionUID = -8665740626196988682L;
	private String descricao;
	private String ean;
	private Integer categoria;
	private String mensagem;
	private String status;

}