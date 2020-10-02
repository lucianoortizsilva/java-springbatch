package com.lucianoortizsilva.cadastro.entity;

public enum Categoria {

	BEBIDA(1), BISCOITO(2), DOCE(3);

	private Integer codigo;

	private Categoria(final Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public static Categoria getByCodigo(final Integer codigo) {
		for (final Categoria categoria : Categoria.values()) {
			if (categoria.getCodigo().equals(codigo)) {
				return categoria;
			}
		}
		return null;
	}

}