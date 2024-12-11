package com.toondeboer.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputReader {
    public static String readInput(String fileName) {
        Path path = Path.of("src/main/resources/" + fileName);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            System.out.println("IO Exception for file: " + fileName + "\n" + e);
            return "";
        }
    }
}

