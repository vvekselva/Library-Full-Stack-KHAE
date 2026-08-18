package com.khae.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {
    public double divide(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return first / second;
    }
}
