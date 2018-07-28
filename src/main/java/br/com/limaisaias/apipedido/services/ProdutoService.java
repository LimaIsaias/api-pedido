package br.com.limaisaias.apipedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.apipedido.domains.Produto;
import br.com.limaisaias.apipedido.repository.ProdutoRepository;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findByID(Integer id) {
		Optional<Produto> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id:" + id + " Tipo:" + Produto.class.getName()));
	}

}
