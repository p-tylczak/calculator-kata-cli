package com.autotrader.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculatorRegister {

    private static final AtomicInteger counter = new AtomicInteger();

    public Map<String, Calculator<?>> getAvailableCalculators() {
        Map<String, Calculator<?>> calcs = new HashMap<>();

        calcs.put(next(), new IntegerCalculator());
        calcs.put(next(), new StringCalculator());

        return calcs;
    }

    private String next() {
        return Integer.toString(counter.incrementAndGet());
    }
}
