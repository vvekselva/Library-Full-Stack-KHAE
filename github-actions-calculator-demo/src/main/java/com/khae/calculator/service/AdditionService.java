package com.khae.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class AdditionService {
    public double add(double first, double second) {
        return first + second;
    }
}
