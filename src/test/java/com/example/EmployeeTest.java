package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EmployeeTest {

    Employee employee = new Employee("2632", 43000);

    @Test
    void givenIdSetTo2633ThenGetIdShouldReturn2633() {
        employee.setId("2633");
        assertThat(employee.getId()).isEqualTo("2633");
    }

    @Test
    void givenSalarySetTo50000ThenGetSalaryShouldReturn50000() {
        employee.setSalary(50000);
        assertThat(employee.getSalary()).isEqualTo(50000);
    }

    @Test
    void givenEmployeeIsNotPaidThenIsPaidShouldReturnFalse() {
        assertFalse(employee.isPaid());
    }



}