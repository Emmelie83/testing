package com.example;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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

    @Test
    void givenNoEmployeesThenPayEmployeesShouldReturn0() {
        employeeRepository = new EmployeeRepositoryTestDouble();
        bankService = new BankServiceTestDouble();
        employees = new Employees(employeeRepository, bankService);

        int payments = employees.payEmployees();

        assertEquals(0, payments);
    }

    @Test
    void givenExceptionIsThrownThenPayEmployeesShouldReturn0() {
        BankService bankService = mock(BankService.class);
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        employees = new Employees(employeeRepository, bankService);

        List<Employee> mockEmployees = Arrays.asList(
                new Employee("1", 45000.0),
                new Employee("2", 58000.0)
        );

        when(employeeRepository.findAll()).thenReturn(mockEmployees);
        doThrow(new RuntimeException("Payment failed")).when(bankService).pay(anyString(), anyDouble());
        int payments = employees.payEmployees();

        assertEquals(0, payments);
        verify(bankService, times(2)).pay(anyString(), anyDouble());
    }

}