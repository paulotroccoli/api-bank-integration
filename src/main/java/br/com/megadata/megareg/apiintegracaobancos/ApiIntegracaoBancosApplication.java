package br.com.megadata.megareg.apiintegracaobancos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiIntegracaoBancosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiIntegracaoBancosApplication.class, args);
	}

}
