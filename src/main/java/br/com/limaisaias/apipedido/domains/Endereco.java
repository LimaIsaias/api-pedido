package br.com.limaisaias.apipedido.domains;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Endereco implements Serializable {

	private static final long serialVersionUID = 5118809257133340942L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String logradouro;

	private String numero;

	private String complemento;

	private String cep;

	private Cliente cliente;

	public Endereco(Integer id, String logradouro, String numero, String complemento, String cep, Cliente cliente) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cliente = cliente;
	}

	
}