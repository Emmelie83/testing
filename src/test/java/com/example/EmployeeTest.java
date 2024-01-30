package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void givenEmployeeIsPaidThenIsPaidShouldReturnTrue() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void toStringShouldReturnEmployeeAsString() {
        assertThat(employee.toString()).hasToString("Employee [id=2632, salary=43000.0]");
    }


}