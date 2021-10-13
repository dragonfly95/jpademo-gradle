package com.example.jpademo.repository;

import com.example.jpademo.domain.Salgrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalGradeRepository extends JpaRepository<Salgrade, Integer> {

}
