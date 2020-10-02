package com.lucianoortizsilva.produto.batch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BatchOutputProduto implements Serializable {

	private static final long serialVersionUID = -8665740626196988682L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String descricao;

	@Column(length = 13)
	private String ean;

	@Column(length = 40)
	private String mensagem;

	@Column(length = 14)
	private String status;

	@Column
	private Integer categoria;

}