package com.toondeboer.day03;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    public static void run() {
        String input = InputReader.readInput("day03.txt");

        int sum = solve(input);

        System.out.println("Day 3: " + sum);
    }

    public static int solve(String input) {
        List<String> multiplications = getMultiplicationStrings(input);

        return sumOfMultiplications(multiplications);
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
            String[] numbers = mul.replace("mul(", "")
                    .replace(")", "")
                    .split(",");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            sum += (a * b);
        }
        return sum;
    }
}
