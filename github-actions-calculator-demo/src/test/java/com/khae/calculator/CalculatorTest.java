package com.khae.calculator;

import com.khae.calculator.service.AdditionService;
import com.khae.calculator.service.DivisionService;
import com.khae.calculator.service.MultiplicationService;
import com.khae.calculator.service.SubtractionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @Mock
    private AdditionService additionService;

    @Mock
    private SubtractionService subtractionService;

    @Mock
    private MultiplicationService multiplicationService;

    @Mock
    private DivisionService divisionService;

    @InjectMocks
    private Calculator calculator;

    @Test
    void addDelegatesToAdditionService() {
        when(additionService.add(10, 5)).thenReturn(15.0);

        double result = calculator.add(10, 5);

        assertEquals(15.0, result);
        verify(additionService).add(10, 5);
        verifyNoInteractions(subtractionService, multiplicationService, divisionService);
    }

    @Test
    void subtractDelegatesToSubtractionService() {
        when(subtractionService.subtract(10, 5)).thenReturn(5.0);

        double result = calculator.subtract(10, 5);

        assertEquals(5.0, result);
        verify(subtractionService).subtract(10, 5);
        verifyNoInteractions(additionService, multiplicationService, divisionService);
    }

    @Test
    void multiplyDelegatesToMultiplicationService() {
        when(multiplicationService.multiply(10, 5)).thenReturn(50.0);

        double result = calculator.multiply(10, 5);

        assertEquals(50.0, result);
        verify(multiplicationService).multiply(10, 5);
        verifyNoInteractions(additionService, subtractionService, divisionService);
    }

    @Test
    void divideDelegatesToDivisionService() {
        when(divisionService.divide(10, 5)).thenReturn(2.0);

        double result = calculator.divide(10, 5);

        assertEquals(2.0, result);
        verify(divisionService).divide(10, 5);
        verifyNoInteractions(additionService, subtractionService, multiplicationService);
    }
}
