package com.khae.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class SubtractionService {
    public double subtract(double first, double second) {
        return first - second;
    }
}
