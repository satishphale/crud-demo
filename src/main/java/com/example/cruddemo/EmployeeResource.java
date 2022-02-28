package com.example.cruddemo;

import com.example.cruddemo.model.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")

public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees = employeeService.findEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable("id") Long id)
    {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateEmployee(@RequestBody Employee employee)
    {
        int updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
