package br.com.dbc.vemser.pessoaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PessoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoApiApplication.class, args);
	}

}
