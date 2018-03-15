package com.example.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private Repository repository;

    @RequestMapping(value = "entities", method = RequestMethod.GET)
    public List<Employee> list()
    {
        return repository.findAll();
    }

    @RequestMapping("getEmployees")
    public List<Employee> getEmployees()
    {
        List<Employee> result = new ArrayList<>();

        result.add(new Employee("Jan", "Nowak", new BigDecimal("345.34")));
        result.add(new Employee("Maciek", "Kowalski", new BigDecimal("8949.688")));
        result.add(new Employee("Karol", "Kwiatkowski", new BigDecimal("6440.31")));

        return result;
    }
}
