package com.autotrader.calculator;

public class IntegerCalculator implements Calculator<Integer> {

    public String calculatorType() {
        return "Integer Calculator";
    }

    public Integer add(Integer one, Integer other) {
        return one + other;
    }

    public Integer subtract(Integer one, Integer other) {
        return one - other;
    }

    public Integer multiply(Integer one, Integer other) {
        return one * other;
    }

    public Integer divide(Integer one, Integer other) {
        return one / other;
    }

    @Override
    public Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
