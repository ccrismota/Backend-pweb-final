package com.fatec.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaApplication {
public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
		System.out.println("Backend fitfood rodando com sucesso!!!Localhost:8090");
	}

}
