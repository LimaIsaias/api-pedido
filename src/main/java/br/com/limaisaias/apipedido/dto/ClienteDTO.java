package br.com.limaisaias.apipedido.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.limaisaias.apipedido.domains.Cliente;
import br.com.limaisaias.apipedido.services.validations.ClienteUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ClienteUpdate
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -2536874001888292823L;

	private Integer id;

	@NotEmpty(message = "Campo nome é obrigatório")
	@Length(min = 5, max = 120, message = "Campo Nome deve ter entre 5 e 80 caracteres")
	private String nome;

	@NotEmpty(message = "Campo email é obrigatório")
	@Length(min = 5, max = 100, message = "Campo Nome deve ter entre 5 e 80 caracteres")
	@Email
	private String email;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}

}
