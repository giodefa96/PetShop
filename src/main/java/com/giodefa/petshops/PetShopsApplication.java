package com.giodefa.petshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.giodefa.model")
public class PetShopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopsApplication.class, args);
	}

}
