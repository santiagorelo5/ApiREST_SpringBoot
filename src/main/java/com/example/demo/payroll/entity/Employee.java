package com.example.demo.payroll.entity;

// import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String name;
  private String role;

  // @Override
  // public boolean equals(Object o) {

  //   if (this == o)
  //     return true;
  //   if (!(o instanceof Employee))
  //     return false;
  //   Employee employee = (Employee) o;
  //   return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
  //       && Objects.equals(this.role, employee.role);
  // }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(this.id, this.name, this.role);
  // }

  // @Override
  // public String toString() {
  //   return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
  // }
}