package br.com.limaisaias.apipedido.dto;

import java.io.Serializable;

import br.com.limaisaias.apipedido.domains.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 160478844819066156L;

	private Integer id;
	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

}
