package com.awesomeshot5051.Utilities.Travel;

import javafx.animation.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.util.*;

import java.util.*;

import static com.awesomeshot5051.Utilities.Calcuations.TravelTimeCalculation.*;
import static com.awesomeshot5051.Utilities.GifLoading.LoadGifs.*;
import static com.awesomeshot5051.Variables.Variables.*;

public class Travel {
    public static void travelTo(String planet) {
        // The total sequence time based on your updated KeyFrames
        double rawSeconds = travelSeconds(planet);
        double totalSequenceTime = rawSeconds + 7.0;

        // 1. Save the original UI (Label + TextField)
        List<Node> originalUI = new ArrayList<>(getBottomBar().getChildren());

        // 2. Setup the Countdown Label
        Label countdownLabel = new Label(formatCountdown(totalSequenceTime));
        countdownLabel.setStyle("-fx-text-fill: #00FF00; -fx-font-family: 'Monospace'; -fx-font-size: 22px;");

        // Hijack the bottom bar
        getBottomBar().getChildren().setAll(countdownLabel);

        // 3. The Clock Timeline (Updates the text every second)
        double[] timeRemaining = {totalSequenceTime};
        Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), _ -> {
            timeRemaining[0]--;
            countdownLabel.setText(formatCountdown(timeRemaining[0]));
        }));
        clock.setCycleCount((int) totalSequenceTime);

        // 4. The Main Sequence (GIF Swaps)
        loadGif("EnteringHyperspace");
        clock.play();

        Timeline timeline = new Timeline(
                // After 4 seconds: Tunnel loop
                new KeyFrame(calculateDuration(4.0), _ -> loadGif("InHyperspace")),

                // After Trip + 4s: Start Exit
                new KeyFrame(calculateDuration(rawSeconds + 4.0), _ -> {
                    loadGif("exitingHyperspace");
                    TextField arrivingBar = new TextField("Now arriving at " + planet + "...");
                    arrivingBar.setEditable(false);
                    arrivingBar.setFocusTraversable(false);
                    arrivingBar.setAlignment(Pos.CENTER);
                    arrivingBar.setMinWidth(400);
                    arrivingBar.setStyle("-fx-background-color: transparent; -fx-text-fill: #00CCFF; " +
                            "-fx-font-size: 18px; -fx-font-weight: bold;");
                    getBottomBar().getChildren().setAll(arrivingBar);
                }),

                // After Trip + 7s: Arrive and Restore UI
                new KeyFrame(calculateDuration(rawSeconds + 7.0), _ -> {
                    loadGif(planet);
                    clock.stop();
                    getStage().setTitle("Currently orbiting: " + planet);
                    getBottomBar().getChildren().setAll(originalUI); // Bring back TextField
                })
        );

        timeline.setCycleCount(1);
        timeline.play();
    }

    // Formats seconds into T- HH:MM:SS
    private static String formatCountdown(double totalSeconds) {
        int s = (int) totalSeconds;
        int hours = s / 3600;
        int minutes = (s % 3600) / 60;
        int seconds = s % 60;
        return String.format("T- %02d:%02d:%02d", hours, minutes, seconds);
    }
}