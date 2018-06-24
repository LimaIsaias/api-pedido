package br.com.limaisaias.apipedido.domains;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Categoria implements Serializable {

	private static final long serialVersionUID = 6955446611987775356L;

	public Categoria() {

	}

	public Categoria(Integer id, String nome) {
		setId(id);
		setNome(nome);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String nome;
}
