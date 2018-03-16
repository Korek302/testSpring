package com.example.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    Repository repository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return repository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee)
    {
        return repository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Integer employeeId)
    {
        return repository.findById(employeeId).get();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable(value="id") Integer employeeId, @Valid @RequestBody Employee employeeDetails)
    {
        Employee employee = repository.findById(employeeId).get();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setSalary(employeeDetails.getSalary());

        Employee updatedEmployee = repository.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value="id") Integer employeeId)
    {
        Employee employee = repository.findById(employeeId).get();
        repository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
