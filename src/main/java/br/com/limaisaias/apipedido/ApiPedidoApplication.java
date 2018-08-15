package br.com.limaisaias.apipedido;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LimaI
 ***/
@SpringBootApplication
public class ApiPedidoApplication implements CommandLineRunner {


	public static void main(final String[] args) {
		SpringApplication.run(ApiPedidoApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
//
	}
}
