package com.example.demo.payroll.dao;

import com.example.demo.payroll.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao {
    List<Employee> all();
    
    Employee createEmployee(Employee employee);

    Employee findById(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);
    
}
