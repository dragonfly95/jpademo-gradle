package com.example.jpademo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salgrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer grade;

    @Column(nullable = false)
    private Double losal;

    @Column(nullable = false)
    private Double hisal;
}

