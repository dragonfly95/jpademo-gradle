package com.example.jpademo;

import com.example.jpademo.domain.Salgrade;
import com.example.jpademo.dto.DeptEmpDto;
import com.example.jpademo.repository.DepartmentRepository;
import com.example.jpademo.repository.SalGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void run(String... args) throws Exception {
		List<?> deptEmpDtos = departmentRepository.fetchEmpDeptDataLeftJoin();
		deptEmpDtos.stream().forEach(l -> System.out.println("l = " + l));
	}
}
