package com.example.demo.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.payroll.entity.Employee;
import com.example.demo.payroll.repository.EmployeeRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {
    return args -> {
      log.info("Preloading {}", repository.save(Employee.builder().name("BilboBaggins").role("burglar").build()));
      log.info("Preloading {}", repository.save(Employee.builder().name("FrodoBaggins").role("thief").build()));
    };
  }
}