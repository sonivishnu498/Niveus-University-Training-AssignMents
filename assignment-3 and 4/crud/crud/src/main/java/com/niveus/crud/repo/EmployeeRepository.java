package com.niveus.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niveus.crud.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
