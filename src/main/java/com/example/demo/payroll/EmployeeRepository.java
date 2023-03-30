package com.example.demo.payroll;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.payroll.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}