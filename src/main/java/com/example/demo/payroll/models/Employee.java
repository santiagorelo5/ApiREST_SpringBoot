package com.example.demo.payroll.models;

// import java.util.Objects;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@ToString @EqualsAndHashCode
public class Employee {

  @Id 
  @Getter @Setter @Column(name= "id")
  @GeneratedValue
  private Long id;
  
  @Getter @Setter @Column(name= "name")
  private String name;

  @Getter @Setter @Column(name= "role")
  private String role;

  public Employee() {}

  public Employee(String name, String role) {

    this.name = name;
    this.role = role;
  }

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