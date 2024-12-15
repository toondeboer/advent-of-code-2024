package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day07 extends Solution {
    List<Equation> equations;

    public Day07() {
        super("07");
    }

    @Override
    public long solvePart1(String input) {
        parseInput(input);
        return calculateTrueResults();
    }

    @Override
    public long solvePart2(String input) {
        return 0;
    }

    private void parseInput(String input) {
        String[] lines = input.split("\\n");
        List<Equation> equations = new ArrayList<>();

        for (String line : lines) {
            String[] strings = line.split(": ");
            long testValue = Long.parseLong(strings[0]);

            List<Integer> values = new ArrayList<>();
            String[] valuesStrings = strings[1].split(" ");
            for (String s : valuesStrings) {
                values.add(Integer.parseInt(s));
            }

            equations.add(new Equation(testValue, values));
        }

        this.equations = equations;
    }

    private long calculateTrueResults() {
        long sum = 0;
        for (Equation equation : equations) {
            if (madeTrue(equation)) {
                sum += equation.testValue;
            }
        }
        return sum;
    }

    private boolean madeTrue(Equation equation) {
        String[] operators = new String[]{"+", "*"};

        return calculateEquations(equation.testValue, equation.values, operators, 0);
    }

    private boolean calculateEquations(long testValue, List<Integer> values, String[] operators, long sum) {
        List<Integer> copyValues = new ArrayList<>(values);
        if (copyValues.isEmpty()) {
            return sum == testValue;
        }

        int nextValue = copyValues.removeFirst();

        if (sum == 0) {
            return calculateEquations(testValue, copyValues, operators, nextValue);
        }

        for (String operator : operators) {
            long nextSum = calculate(sum, nextValue, operator);
            if (calculateEquations(testValue, copyValues, operators, nextSum)) {
                return true;
            }
        }
        return false;
    }

    private long calculate(long sum, int nextValue, String operator) {
        switch (operator) {
            case "+" -> {
                return sum + nextValue;
            }
            case "*" -> {
                return sum * nextValue;
            }
        }
        return sum;
    }
}

class Equation {
    long testValue;
    List<Integer> values;

    Equation(long testValue, List<Integer> values) {
        this.testValue = testValue;
        this.values = values;
    }
}
