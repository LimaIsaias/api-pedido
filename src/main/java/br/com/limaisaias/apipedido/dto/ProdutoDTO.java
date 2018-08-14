package br.com.limaisaias.apipedido.dto;

import java.io.Serializable;

import br.com.limaisaias.apipedido.domains.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = -1990099450644589603L;

	private Integer id;

	private String nome;

	private Double preco;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

}
