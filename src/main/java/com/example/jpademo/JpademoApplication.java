package com.example.jpademo;

import com.example.jpademo.domain.Salgrade;
import com.example.jpademo.repository.SalGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

}
