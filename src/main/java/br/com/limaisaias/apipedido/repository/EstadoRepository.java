package br.com.limaisaias.apipedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.limaisaias.apipedido.domains.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
}
