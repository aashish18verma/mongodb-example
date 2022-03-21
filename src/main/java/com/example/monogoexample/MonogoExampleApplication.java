package com.example.monogoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories("com.example.monogoexample.repository")
@SpringBootApplication
public class MonogoExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonogoExampleApplication.class, args);
	}

}
