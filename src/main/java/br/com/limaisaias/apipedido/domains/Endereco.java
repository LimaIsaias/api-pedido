package br.com.limaisaias.apipedido.domains;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	@JoinColumn(name  = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name  = "cidade_id")
	private Cidade cidade ;
	
	public Endereco(Integer id, String logradouro, String numero, String complemento, String cep, Cliente cliente, Cidade cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	
}