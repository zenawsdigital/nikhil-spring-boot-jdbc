package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.pojo")
@SpringBootApplication(scanBasePackages = "com.example")
public class NikhilSpringBootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(NikhilSpringBootJdbcApplication.class, args);
		System.out.println("Spring Boot Application started ....");
	}

}
