package com.autotrader.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator implements Calculator<String> {

    public String calculatorType() {
        return "String Calculator";
    }

    public String add(String one, String other) {
        return one + other;
    }

    public String subtract(String one, String other) {
        return one.contains(other)
                ? one.replace(other, "")
                : one;
    }

    public String multiply(String one, String other) {
        return StringUtils.repeat(one, other.length());
    }

    public String divide(String one, String other) {
        int count = other.length();
        int index = 0;

        List<String> strings = new ArrayList<>();
        while (index < one.length()) {
            strings.add(one.substring(index, Math.min(index + count, one.length())));
            index += count;
        }

        return StringUtils.join(strings, " ");
    }

    @Override
    public String parse(String input) {
        return input;
    }
}
