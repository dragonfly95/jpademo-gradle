package com.example.jpademo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dept {

    @Id
    private Long deptno;

    @Column(length = 14, nullable = false)
    private String dname;

    @Column(length = 13)
    private String loc;

}

