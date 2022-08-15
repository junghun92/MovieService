package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.movie.config.MyBatisConfig;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

}
