package com.example.cruddemo.service;

import com.example.cruddemo.exception.UserNotFoundException;
import com.example.cruddemo.model.Employee;
import com.example.cruddemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;



//    public void addEmployee1(Employee employee)
//    {
//        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//        employee.setEmployeecode(UUID.randomUUID().toString());
//
//        session.insert("com.example.cruddemo.util.EmployeeMapper.insertEmployee",employee);
//
//        session.commit();
//        session.close();
//    }

    public void addEmployee(Employee employee)
    {
         employeeRepo.insert(employee);
         return;
    }
    public List<Employee> findEmployees()
    {
        return employeeRepo.findAll();
    }

    public int updateEmployee(Employee employee)
    {
        return employeeRepo.update(employee);
    }

    public Employee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id "+id+" was not found."));
    }


    public void deleteEmployee(Long id)
    {
        employeeRepo.deleteEmployeeById(id);
    }
}
