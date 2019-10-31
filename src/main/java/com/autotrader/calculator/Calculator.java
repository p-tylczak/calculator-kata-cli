package com.autotrader.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public interface Calculator<T> {

    String calculatorType();

    T add(T one, T other);

    T subtract(T one, T other);

    T multiply(T one, T other);

    T divide(T one, T other);

    default String addOperator() {
        return "+";
    }

    default String subtractOperator() {
        return "-";
    }

    default String multiplyOperator() {
        return "*";
    }

    default String divideOperator() {
        return "/";
    }

    T parse(String input);

    default BiFunction<T, T, T> getOperatorFunction(String operator) {
        Map<String, BiFunction<T, T, T>> operatorMap = new HashMap<>();
        operatorMap.put(addOperator(), this::add);
        operatorMap.put(subtractOperator(), this::subtract);
        operatorMap.put(multiplyOperator(), this::multiply);
        operatorMap.put(divideOperator(), this::divide);

        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unrecognised operator '%s'", operator)));
    }
}
