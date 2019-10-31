package com.autotrader.calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorRegister {

    public Map<String, Calculator> getAvailableCalculators() {
        Map<String, Calculator> calcs = new HashMap<>();

        calcs.put("1", new IntegerCalculator());

        return calcs;
    }
}
