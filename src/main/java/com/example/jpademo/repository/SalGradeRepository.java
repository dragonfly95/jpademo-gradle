package com.example.jpademo.repository;

import com.example.jpademo.domain.Salgrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalGradeRepository extends JpaRepository<Salgrade, Integer> {

}
