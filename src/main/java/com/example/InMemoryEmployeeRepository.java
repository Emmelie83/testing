package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final Map<String, Employee> employeeMap;

    public InMemoryEmployeeRepository() {
        this.employeeMap = new HashMap<>();
    }

    public InMemoryEmployeeRepository(List<Employee> initialEmployees) {
        this();
        initialEmployees.forEach(this::save);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee save(Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return employee;
    }
}
