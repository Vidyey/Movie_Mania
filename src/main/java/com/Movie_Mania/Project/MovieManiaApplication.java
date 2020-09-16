package com.Movie_Mania.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.Movie_Mania.Project.repo")
@SpringBootApplication
public class MovieManiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieManiaApplication.class, args);
		System.out.println("lets start");
	}

}
