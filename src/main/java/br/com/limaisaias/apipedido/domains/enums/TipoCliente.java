package br.com.limaisaias.apipedido.domains.enums;

import lombok.Getter;

public enum TipoCliente {

	PessoaFisica(1, "Pessoa Física"), PessoaJuridica(2, "Pessoa Jurídica");

	@Getter
	private int cod;

	@Getter
	private String desc;

	private TipoCliente(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values())
			if (cod.equals(x.getCod())) {
				return x;
			}
		throw new IllegalAccessError("código inválido" + cod);
	}

}
