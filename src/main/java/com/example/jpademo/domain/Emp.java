package com.example.jpademo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Emp {

    @Id
    private Long empno;

    @Column(length=10, nullable =false)
    private String ename;

    @Column(length = 9)
    private String job;

    @ManyToOne
    @JoinColumn(name = "mgr")
    private Emp mgr;

    @OneToMany(mappedBy = "mgr")
    @JsonIgnore
    private List<Emp> staff = new ArrayList<Emp>();

    @Temporal(TemporalType.DATE)
    private Date hiredate;

    private Double sal;

    private Double comm;

}
