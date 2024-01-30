package com.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeesTest {
    EmployeeRepositoryTestDouble employeeRepository;
    BankServiceTestDouble bankService;
    Employees employees;

    @Test
    void givenTwoEmployeesThenPayEmployeesShouldReturn2() {
        employeeRepository = new EmployeeRepositoryTestDouble();
        bankService = new BankServiceTestDouble();
        employees = new Employees(employeeRepository, bankService);
        employeeRepository.save(new Employee("1", 45000.0));
        employeeRepository.save(new Employee("2", 58000.0));

        int payments = employees.payEmployees();

        assertEquals(2, payments);
    }

}