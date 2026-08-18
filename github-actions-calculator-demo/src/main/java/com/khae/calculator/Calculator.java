package com.khae.calculator;

import com.khae.calculator.service.AdditionService;
import com.khae.calculator.service.DivisionService;
import com.khae.calculator.service.MultiplicationService;
import com.khae.calculator.service.SubtractionService;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private final AdditionService additionService;
    private final SubtractionService subtractionService;
    private final MultiplicationService multiplicationService;
    private final DivisionService divisionService;

    public Calculator(AdditionService additionService,
                      SubtractionService subtractionService,
                      MultiplicationService multiplicationService,
                      DivisionService divisionService) {
        this.additionService = additionService;
        this.subtractionService = subtractionService;
        this.multiplicationService = multiplicationService;
        this.divisionService = divisionService;
    }

    public double add(double first, double second) {
        return additionService.add(first, second);
    }

    public double subtract(double first, double second) {
        return subtractionService.subtract(first, second);
    }

    public double multiply(double first, double second) {
        return multiplicationService.multiply(first, second);
    }

    public double divide(double first, double second) {
        return divisionService.divide(first, second);
    }
}
