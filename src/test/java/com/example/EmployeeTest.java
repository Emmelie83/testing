package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmployeeTest {

    Employee employee = new Employee("2632", 43000);

    @Test
    void givenIdSetTo2632ThenGetIdShouldReturn2632() {
        employee.setId("2633");
        assertThat(employee.getId()).isEqualTo("2633");
    }

}