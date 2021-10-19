package com.example.jpademo.repository;

import com.example.jpademo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Iterable<Person> findTop5By();
}
