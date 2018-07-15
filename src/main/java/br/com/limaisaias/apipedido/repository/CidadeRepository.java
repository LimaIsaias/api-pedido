package br.com.limaisaias.apipedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.limaisaias.apipedido.domains.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
