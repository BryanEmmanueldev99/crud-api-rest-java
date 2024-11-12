package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		String MyArray[] = {"ford","pepsi", "coca"};

		for(String marcas : MyArray) {
			    System.out.println(marcas);
		}
	}

}
