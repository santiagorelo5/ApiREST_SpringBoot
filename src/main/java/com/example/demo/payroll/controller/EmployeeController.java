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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.payroll.entity.Employee;
import com.example.demo.payroll.service.EmployeeService;

@RestController
class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/api/employees")
  ResponseEntity<List<Employee>> all() {

    return new ResponseEntity<List<Employee>>(employeeService.all(), HttpStatus.OK);
  }
  // end::get-aggregate-root[]

  @PostMapping("/api/employees")
  ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {

    return new ResponseEntity<Employee>(employeeService.createEmployee(newEmployee), HttpStatus.OK);
  }

  // // Single item

  @GetMapping("/api/employees/{id}")
  ResponseEntity<Employee> one(@PathVariable Long id) {

    return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
  }

  @PutMapping("/api/employees/{id}")
  ResponseEntity<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return new ResponseEntity<Employee>(employeeService.updateEmployee(newEmployee, id), HttpStatus.OK);
  }

  @DeleteMapping("/api/employees/{id}")
  ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {

    employeeService.deleteEmployee(id);
    return new ResponseEntity<HttpStatus>(HttpStatus.OK);
  }
}
