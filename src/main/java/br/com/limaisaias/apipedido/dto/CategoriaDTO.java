package br.com.limaisaias.apipedido.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.limaisaias.apipedido.domains.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 160478844819066156L;

	private Integer id;
	@NotEmpty(message = "Campo nome é obrigatório")
	@Length(min = 5, max = 80, message = "Campo Nome deve ter entre 5 e 80 caracteres")
	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

}
