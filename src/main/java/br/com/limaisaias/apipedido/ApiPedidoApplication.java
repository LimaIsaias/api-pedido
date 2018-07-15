package br.com.limaisaias.apipedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.domains.Cidade;
import br.com.limaisaias.apipedido.domains.Estado;
import br.com.limaisaias.apipedido.domains.Produto;
import br.com.limaisaias.apipedido.repository.CategoriaRepository;
import br.com.limaisaias.apipedido.repository.CidadeRepository;
import br.com.limaisaias.apipedido.repository.EstadoRepository;
import br.com.limaisaias.apipedido.repository.ProdutoRepository;

/**
 * @author LimaI
 ***/
@SpringBootApplication
public class ApiPedidoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(final String[] args) {
		SpringApplication.run(ApiPedidoApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

		// Mock Domains
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 1000.00);
		Produto produto3 = new Produto(null, "Mouse", 10.00);

		Categoria categoria1 = new Categoria(null, "Informatica");
		Categoria categoria2 = new Categoria(null, "Escritorio");

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().add(produto2);
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		Estado estado1 = new Estado(null, "Ceará");
		Estado estado2 = new Estado(null, "São Paulo");
		Estado estado3 = new Estado(null, "Minas Gerais");

		Cidade cidade1 = new Cidade(null, "Fortaleza", estado1);
		Cidade cidade2 = new Cidade(null, "Caucaia", estado1);
		Cidade cidade3 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade4 = new Cidade(null, "Santos", estado2);
		Cidade cidade5 = new Cidade(null, "Belo Horizonte", estado3);

		// Persistence
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		categoriaRepository.flush();
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		produtoRepository.flush();
		estadoRepository.saveAll(Arrays.asList(estado1, estado2, estado3));
		estadoRepository.flush();
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4, cidade5));
		cidadeRepository.flush();

	}
}
