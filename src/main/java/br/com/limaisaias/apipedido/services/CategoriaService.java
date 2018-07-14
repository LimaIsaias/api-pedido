package br.com.limaisaias.apipedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.repository.CategoriaRepository;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public CategoriaService() {
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria findByID(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id:"+ id +" Tipo:"+Categoria.class.getName()));
	}

}
