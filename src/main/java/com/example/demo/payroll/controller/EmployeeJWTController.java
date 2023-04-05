package com.example.demo.payroll.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.payroll.entity.Employee;
import com.example.demo.payroll.service.EmployeeService;
import com.example.demo.payroll.utils.JWTUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

@RestController
class EmployeeJWTController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private JWTUtils jwtUtils;

  @GetMapping("/api/jwt/employees/token/{id}")
  ResponseEntity<Map<String, String>> createToken(@PathVariable Long id) {

    Employee employee = employeeService.findById(id);
    Map<String, String> response = new HashMap<String, String>();
    response.put("token", jwtUtils.generateToken(employee));
    return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/api/jwt/employees")
  ResponseEntity<?> all(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
    if (!jwtUtils.validateToken(token)) {
      return new ResponseEntity<String>("Invalid JWT", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<List<Employee>>(employeeService.all(), HttpStatus.OK);

  }
  // end::get-aggregate-root[]

  @PostMapping("/api/jwt/employees")
  ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee,
      @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
    if (!jwtUtils.validateToken(token)) {
      return new ResponseEntity<String>("Invalid JWT", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<Employee>(employeeService.createEmployee(newEmployee), HttpStatus.OK);

  }

  // // Single item

  @GetMapping("/api/jwt/employees/{id}")
  ResponseEntity<?> one(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
    if (!jwtUtils.validateToken(token)) {
      return new ResponseEntity<String>("Invalid JWT", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
  }

  @PutMapping("/api/jwt/employees/{id}")
  ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id,
      @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
    if (!jwtUtils.validateToken(token)) {
      return new ResponseEntity<String>("Invalid JWT", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<Employee>(employeeService.updateEmployee(newEmployee, id), HttpStatus.OK);

  }

  @DeleteMapping("/api/jwt/employees/{id}")
  ResponseEntity<?> deleteEmployee(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
    if (!jwtUtils.validateToken(token)) {
      employeeService.deleteEmployee(id);
      return new ResponseEntity<String>("Invalid JWT", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.OK);

  }
}
