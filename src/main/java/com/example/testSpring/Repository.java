package com.example.testSpring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Employee, Integer>
{
    List<Employee> findByName(String name);
}
