package com.bricevassail.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe servant de point d'entrée à Spring Boot.
 */
@SpringBootApplication
public class EmployeeApplication {

	/**
	 * Méthode de lancement de l'application.
	 * @param args : CLI arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
