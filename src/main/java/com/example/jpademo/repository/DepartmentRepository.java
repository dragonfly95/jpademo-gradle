package com.example.jpademo.repository;

import com.example.jpademo.domain.Department;
import com.example.jpademo.dto.DeptEmpDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {

//    @Query("select new com.example.jpademo.dto.DeptEmpDto(d.name, e.name, e.email, e.address)" +
//            "from Department d left join d.employees e")
    @Query("select new map(d.name, e.name, e.email, e.address)" +
            "from Department d left join d.employees e")
    List<?> fetchEmpDeptDataLeftJoin();
}