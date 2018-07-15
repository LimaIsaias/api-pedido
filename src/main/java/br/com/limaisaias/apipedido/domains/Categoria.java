package br.com.limaisaias.apipedido.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "categoria", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }, name = "categoria_id"))
public class Categoria implements Serializable {

	private static final long serialVersionUID = 6955446611987775356L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<>();

	public Categoria() {
	}

	public Categoria(Integer id, String nome) {
		setId(id);
		setNome(nome);
	}

}
