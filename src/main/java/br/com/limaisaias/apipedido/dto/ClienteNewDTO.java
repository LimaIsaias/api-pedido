package br.com.limaisaias.apipedido.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 3008074129247829077L;

	private String nome;
	private String email;
	private String cpfCnpj;
	private Integer tipo;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	private String telefone1;
	private String telefone2;
	private String telefone3;

	private Integer cidadeID;
}
