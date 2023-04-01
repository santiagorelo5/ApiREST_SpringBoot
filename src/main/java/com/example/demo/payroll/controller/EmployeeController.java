package com.example.demo.payroll.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.payroll.entity.Employee;
import com.example.demo.payroll.service.EmployeeService;

@RestController
class EmployeeController {
  
  @Autowired
  private EmployeeService employeeService;

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/api/employees")
  List<Employee> all() {
    return employeeService.all();
  }
  // end::get-aggregate-root[]

  @PostMapping("/api/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return employeeService.createEmployee(newEmployee);
  }

  // // Single item
  
  @GetMapping("/api/employees/{id}")
  Employee one(@PathVariable Long id) {
    
    return employeeService.findById(id);
  }

  @PutMapping("/api/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return employeeService.updateEmployee(newEmployee,id);
  }

  @DeleteMapping("/api/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
  }
}
