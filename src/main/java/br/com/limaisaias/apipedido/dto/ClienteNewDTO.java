package br.com.limaisaias.apipedido.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 3008074129247829077L;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 5, max = 120, message = "Campo Nome deve ter entre 5 e 80 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String cpfCnpj;
	private Integer tipo;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String logradouro;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String numero;
	private String complemento;
	private String bairro;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String cep;

	private String telefone1;
	private String telefone2;
	private String telefone3;

	private Integer cidadeID;
}
