package com.example.demo.payroll.controllers;

class EmployeeNotFoundException extends RuntimeException {

  EmployeeNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}