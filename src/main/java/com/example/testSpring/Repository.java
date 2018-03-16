package com.example.testSpring;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Integer>
{
    //List<Employee> findByName(String name);
}
