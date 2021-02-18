package com.autotrader.calculator;

import java.util.Map;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "";
        String firstOperand;
        String secondOperand;
        Calculator selectedCalculator;

        Map<String, Calculator<?>> calculatorMap = new CalculatorRegister().getAvailableCalculators();

        System.out.println("Please select a calculator type and hit enter.");

        for (Map.Entry<String, Calculator<?>> calculator : calculatorMap.entrySet()) {
            System.out.println(String.format("[%s] %s", calculator.getKey(), calculator.getValue().calculatorType()));
        }

        while (!calculatorMap.containsKey(input)) {
            input = in.nextLine();
        }

        selectedCalculator = calculatorMap.get(input);

        System.out.println("You have selected " + selectedCalculator.calculatorType() + "\n");
        System.out.println("Please provide an input and hit enter.");

        do {
            System.out.print("Select first operand: ");
            firstOperand = in.nextLine();

            System.out.println("\nSelect operator:\n" + getAvailableOperands(selectedCalculator));
            System.out.print("Select operator: ");
            input = in.nextLine();

            System.out.print("Select second operand: ");
            secondOperand = in.nextLine();

            System.out.println();

            Object result = selectedCalculator.getOperatorFunction(input)
                    .apply(selectedCalculator.parse(firstOperand), selectedCalculator.parse(secondOperand));

            System.out.println("Result: " + result);

            System.out.println("\nContinue? [y/n]");
            input = in.nextLine();
        } while (input.equals("y"));
    }

    private static String getAvailableOperands(Calculator<?> calculator) {
        return String.format("[%s]: addition\n[%s]: subtraction\n[%s]: multiplication\n[%s]: division",
                calculator.addOperator(), calculator.subtractOperator(), calculator.multiplyOperator(), calculator.divideOperator());
    }

}
