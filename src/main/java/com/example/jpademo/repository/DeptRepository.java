package com.example.jpademo.repository;

import com.example.jpademo.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {

}
