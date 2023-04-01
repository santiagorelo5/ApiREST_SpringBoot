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
  private EmployeeService employeeDao;

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<Employee> all() {
    return employeeDao.all();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return employeeDao.createEmployee(newEmployee);
  }

  // // Single item
  
  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {
    
    return employeeDao.findById(id);
      // .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return employeeDao.updateEmployee(newEmployee,id);
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    employeeDao.deleteEmployee(id);
  }
}
