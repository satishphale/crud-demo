package com.example.cruddemo;

import com.example.cruddemo.model.Employee;
import com.example.cruddemo.model.Profile;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeResource {
    private final EmployeeService employeeService;

    private final MultiTenantManager tenantManager;

    public EmployeeResource(EmployeeService employeeService, MultiTenantManager tenantManager)
    {
        this.employeeService = employeeService;
        this.tenantManager = tenantManager;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees = employeeService.findEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
//
//    @PutMapping("/update")
//    public ResponseEntity<?> updateConnection(@RequestBody final List<ConfigurationProperty> properies) {
//
//        return new ResponseEntity<> (HttpStatus.OK);
//        }

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

    @PostMapping(value="/connectToDb")
    public List<Employee> getAllEmployeeDetails1(@RequestBody Profile profile) throws Exception {

        //log.info("[i] Received add new tenant params request {}", dbProperty);


        String driver =profile.getDrivername();//"com.teradata.jdbc.TeraDriver";
        String tenantId = profile.getProfilename();//"DBS";//dbProperty.get("tenantId");
        String url = profile.getUrl();//"jdbc:teradata://sdt48259.labs.teradata.com/database=tacdb";//dbProperty.get("url");
        String username = profile.getUsername();//"dbc";//dbProperty.get("username");
        String password = profile.getPassword();//"dbc";//dbProperty.get("password");

        if (tenantId == null || url == null || username == null || password == null) {
            //log.error("[!] Received database params are incorrect or not full!");
            throw new Exception();
        }

        try {
            tenantManager.addTenant(tenantId,driver ,url, username, password);
            tenantManager.setCurrentTenant(tenantId);
            //log.info("[i] Loaded DataSource for tenant '{}'.", tenantId);

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return employeeService.findEmployees();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
