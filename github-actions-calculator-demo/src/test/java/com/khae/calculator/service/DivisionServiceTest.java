package com.khae.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionServiceTest {

    private final DivisionService divisionService = new DivisionService();

    @Test
    void dividesTwoNumbers() {
        assertEquals(2.0, divisionService.divide(10, 5));
    }

    @Test
    void rejectsDivisionByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> divisionService.divide(10, 0));

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
