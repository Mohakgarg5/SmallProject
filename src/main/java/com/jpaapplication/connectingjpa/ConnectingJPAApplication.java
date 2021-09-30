package com.jpaapplication.connectingjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ConnectingJPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectingJPAApplication.class, args);
	}

}
/**
 *
 * Add Service Layer
 * Validations for phoneNumber, Email, Zipcode
 * Use DTO in Controller
 *
 */