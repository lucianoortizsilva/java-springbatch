package com.lucianoortizsilva.batch.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class ProdutoInput implements Serializable {

	private static final long serialVersionUID = -7210272980190151714L;
	private String descricao;
	private String ean;
	private Integer categoria;

}