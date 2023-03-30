package com.example.demo.payroll.dao;

import com.example.demo.payroll.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImp implements EmployeeDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> all(){
        String query = "FROM Employee";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employee createEmployee(Employee employee){
        return entityManager.merge(employee);
    }

    @Override
    public Employee findById(Long id){
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(Long id){
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
