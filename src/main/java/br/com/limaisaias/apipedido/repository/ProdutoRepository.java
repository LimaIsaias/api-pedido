package br.com.limaisaias.apipedido.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.domains.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome,List<Categoria> categorias,
			Pageable pageRequest);

}
