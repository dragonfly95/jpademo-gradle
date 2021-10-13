package com.example.jpademo.repository;

import com.example.jpademo.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
    // nothing
}
