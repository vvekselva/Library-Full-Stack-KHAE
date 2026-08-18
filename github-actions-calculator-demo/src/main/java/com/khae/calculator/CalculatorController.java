package com.khae.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/add")
    public Map<String, Double> add(@RequestParam double first, @RequestParam double second) {
        return Map.of("result", calculator.add(first, second));
    }

    @GetMapping("/subtract")
    public Map<String, Double> subtract(@RequestParam double first, @RequestParam double second) {
        return Map.of("result", calculator.subtract(first, second));
    }

    @GetMapping("/multiply")
    public Map<String, Double> multiply(@RequestParam double first, @RequestParam double second) {
        return Map.of("result", calculator.multiply(first, second));
    }

    @GetMapping("/divide")
    public Map<String, Double> divide(@RequestParam double first, @RequestParam double second) {
        return Map.of("result", calculator.divide(first, second));
    }
}
