package com.toondeboer.solutions;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    public static void run() {
        String input = InputReader.readInput("day03.txt");

        int[] sum = solve(input);

        System.out.println("Day 3: part 1: " + sum[0] + ", part 2: " + sum[1]);
    }

    public static int[] solve(String input) {
        List<String> multiplicationsPart1 = getMultiplicationStrings(input);
        int sumPart1 = sumOfMultiplications(multiplicationsPart1);

        int sumPart2 = sumOfMultiplicationsPart2(input);

        return new int[]{sumPart1, sumPart2};
    }

    private static List<String> getMultiplicationStrings(String input) {
        List<String> multiplications = new ArrayList<>();

        String multiplicationRegex = "mul\\(\\d+,\\d+\\)";
        Pattern pattern = Pattern.compile(multiplicationRegex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            multiplications.add(matcher.group());
        }
        return multiplications;
    }

    private static int sumOfMultiplications(List<String> multiplications) {
        int sum = 0;
        for (String mul : multiplications) {
            sum += multiply(mul);
        }
        return sum;
    }

    private static int multiply(String mul) {
        String[] numbers = mul.replace("mul(", "")
                .replace(")", "")
                .split(",");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        return (a * b);
    }

    private static int sumOfMultiplicationsPart2(String input) {
        int sum = 0;

        String multiplicationRegex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Pattern pattern = Pattern.compile(multiplicationRegex);
        Matcher matcher = pattern.matcher(input);

        boolean enabled = true;
        while (matcher.find()) {
            String matchedString = matcher.group();
            if (matchedString.equals("do()")) {
                enabled = true;
                continue;
            }
            if (matchedString.equals("don't()")) {
                enabled = false;
                continue;
            }
            if (enabled) {
                sum += multiply(matchedString);
            }
        }

        return sum;
    }
}
