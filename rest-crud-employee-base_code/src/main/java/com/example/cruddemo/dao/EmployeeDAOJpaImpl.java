package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

//    define field for entitymanager
    private EntityManager entityManager;

//    set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

//        create a query
        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);

//        execute query and get result list
        List<Employee> employees = typedQuery.getResultList();

//        return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
//        get employee
        Employee employee = entityManager.find(Employee.class, theId);

//        return employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

//        save Employee
        Employee employee = entityManager.merge(theEmployee);

//        return the employee
        return employee;
    }

    @Override
    public void deleteById(int theId) {

//        find employee by id
        Employee employee = entityManager.find(Employee.class, theId);

//        remove employee
        entityManager.remove(employee);

    }
}
