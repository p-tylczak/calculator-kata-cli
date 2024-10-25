package com.autotrader.calculator;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRegisterTest {

    private final CalculatorRegister calculatorRegister = new CalculatorRegister();

    @Test
    void getAvailableCalculators_shouldReturnIntegerCalculatorWithKey1() {
        Map<String, Calculator<?>> availableCalculators = calculatorRegister.getAvailableCalculators();

        assertTrue(availableCalculators.containsKey("1"));
        assertInstanceOf(IntegerCalculator.class, availableCalculators.get("1"));
    }

}
