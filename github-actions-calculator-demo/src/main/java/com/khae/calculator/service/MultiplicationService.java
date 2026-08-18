package com.khae.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
    public double multiply(double first, double second) {
        return first * second;
    }
}
