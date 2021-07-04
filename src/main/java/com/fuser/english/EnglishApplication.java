package com.fuser.english;

import com.fuser.english.entity.User;
import com.fuser.english.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnglishApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishApplication.class, args);
	}

}
