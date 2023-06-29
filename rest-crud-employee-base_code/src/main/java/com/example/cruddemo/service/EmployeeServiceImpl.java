package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.dao.EmployeeDAOJpaImpl;
import com.example.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = employeeDAO.findById(theId);

        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = employeeDAO.save(theEmployee);

        return employee;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
