package com.example.jpademo;

import com.example.jpademo.domain.Salgrade;
import com.example.jpademo.repository.SalGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Autowired
	private SalGradeRepository salGradeRepository;

	@Override
	public void run(String... args) throws Exception {
		Salgrade salgr = Salgrade.builder()
				.hisal(Double.valueOf(10))
				.losal(Double.valueOf(1))
				.build();
		salGradeRepository.save(salgr);

		List<Salgrade> all = salGradeRepository.findAll();
		all.forEach(salgrade -> {
			System.out.println("salgrade = " + salgrade);
		});
	}
}
