package com.autotrader.calculator;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRegisterTest {

    private CalculatorRegister calculatorRegister = new CalculatorRegister();

    @Test
    public void getAvailableCalculators_shouldReturnIntegerCalculatorWithKey1() {
        Map<String, Calculator> availableCalculators = calculatorRegister.getAvailableCalculators();

        assertTrue(availableCalculators.containsKey("1"));
        assertTrue(availableCalculators.get("1") instanceof IntegerCalculator);
    }

}