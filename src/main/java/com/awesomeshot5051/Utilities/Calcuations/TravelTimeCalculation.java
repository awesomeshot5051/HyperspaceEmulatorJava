package com.awesomeshot5051.Utilities.Calcuations;

import com.awesomeshot5051.Utilities.Travel.*;
import javafx.util.*;

import static com.awesomeshot5051.Utilities.PlanetData.PlanetInformation.*;

public class TravelTimeCalculation {
    static final double SECONDS_IN_MINUTE = 60.0;
    static final double SECONDS_IN_HOUR = 3600.0;
    static final double SECONDS_IN_DAY = 86400.0;
    private static final double SPEED_FACTOR = 508550.8;

    public static double travelSeconds(String planet) {
        return planetDistances.getOrDefault(planet, 0.0) * SPEED_FACTOR;
    }

    // This stays for your UI label
    public static String calculateTime(String planet) {
        double totalSeconds = travelSeconds(planet);
        TIME_UNIT unit = convertUnit(totalSeconds);
        String output = "Traveling to " + planet + ". It will take ~ ";

        return switch (unit) {
            case DAYS -> output + String.format("%.2f Days", totalSeconds / SECONDS_IN_DAY);
            case HOURS -> output + String.format("%.2f Hours", totalSeconds / SECONDS_IN_HOUR);
            case MINUTES -> output + String.format("%.2f Minutes", totalSeconds / SECONDS_IN_MINUTE);
            default -> output + String.format("%.2f Seconds", totalSeconds);
        };
    }

    public static TIME_UNIT convertUnit(double rawSeconds) {
        if (rawSeconds >= SECONDS_IN_DAY) return TIME_UNIT.DAYS; // Fixed: was returning SECONDS
        if (rawSeconds >= SECONDS_IN_HOUR) return TIME_UNIT.HOURS;
        if (rawSeconds >= SECONDS_IN_MINUTE) return TIME_UNIT.MINUTES;
        return TIME_UNIT.SECONDS;
    }

    // Fix: We pass the RAW seconds here so it can decide the unit correctly
    public static Duration calculateDuration(double rawSeconds) {
        TIME_UNIT unit = convertUnit(rawSeconds);
        return switch (unit) {
            case DAYS -> Duration.hours((rawSeconds / SECONDS_IN_DAY) * 24);
            case HOURS -> Duration.hours(rawSeconds / SECONDS_IN_HOUR);
            case MINUTES -> Duration.minutes(rawSeconds / SECONDS_IN_MINUTE);
            default -> Duration.seconds(rawSeconds);
        };
    }
}