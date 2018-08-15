package br.com.limaisaias.apipedido.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.limaisaias.apipedido.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService db;

	@Bean
	public boolean instantiateDatabase() {
		db.instantiateTestDatabase();
		return true;
	}

}
