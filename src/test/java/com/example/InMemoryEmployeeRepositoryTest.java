package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryEmployeeRepositoryTest {
    @Test
    void findAllShouldReturnAllEmployees() {
        Employee e1 = new Employee("1", 45000.0);
        Employee e2 = new Employee("2", 58000.0);
        EmployeeRepository repository = new InMemoryEmployeeRepository(Arrays.asList(e1, e2));

        List<Employee> result = repository.findAll();

        assertTrue(result.contains(e1));
        assertTrue(result.contains(e2));
    }

    @Test
    void saveShouldAddEmployeeToRepository() {

        EmployeeRepository repository = new InMemoryEmployeeRepository();
        Employee e = new Employee("1", 45000.0);

        repository.save(e);
        List<Employee> result = repository.findAll();

        assertTrue(result.contains(e));
    }



}