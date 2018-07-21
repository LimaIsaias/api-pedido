package br.com.limaisaias.apipedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.apipedido.domains.Cliente;
import br.com.limaisaias.apipedido.repository.ClienteRepository;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findByID(Integer id) {
		Optional<Cliente> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id:"+ id +" Tipo:"+Cliente.class.getName()));
	}
}
