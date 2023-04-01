package com.example.demo.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.payroll.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}