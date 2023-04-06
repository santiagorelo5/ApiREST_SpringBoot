package com.example.demo.payroll.service;

import com.example.demo.payroll.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> all();

    Employee createEmployee(Employee employee);

    Employee findById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);

}
