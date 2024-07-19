package com.xillinha.meuslivros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MeusLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeusLivrosApplication.class, args);
	}

}
