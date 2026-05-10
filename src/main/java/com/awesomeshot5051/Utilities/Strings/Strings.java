package com.awesomeshot5051.Utilities.Strings;

public class Strings {
    public static String toSentenceCase(String input) {
        if (input == null || input.isEmpty()) return input;

        // Capitalize first letter + lowercase the rest
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
