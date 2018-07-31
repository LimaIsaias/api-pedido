package br.com.limaisaias.apipedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.apipedido.domains.Pedido;
import br.com.limaisaias.apipedido.repository.PedidoRepository;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido find(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id:"+ id +" Tipo:"+Pedido.class.getName()));
	}

}
