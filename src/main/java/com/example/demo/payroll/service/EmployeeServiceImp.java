package com.example.demo.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.payroll.entity.Employee;
import com.example.demo.payroll.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> all(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id){
        return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee updateEmployee(Employee newEmployee,Long id){
        return employeeRepository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return employeeRepository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return employeeRepository.save(newEmployee);
      });
    }

    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
