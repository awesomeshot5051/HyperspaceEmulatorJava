package com.awesomeshot5051;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.*;

import static com.awesomeshot5051.Utilities.GifLoading.LoadGifs.*;
import static com.awesomeshot5051.Utilities.Strings.Strings.*;
import static com.awesomeshot5051.Utilities.Travel.Travel.*;
import static com.awesomeshot5051.Variables.Variables.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        loadGif("Start");
        createUI();
        BorderPane root = new BorderPane();
        StackPane imageContainer = new StackPane(getImageView());
        root.setCenter(imageContainer);
        root.setBottom(getBottomBar());
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("/Styles.css")).toExternalForm()
        );
        setStage(primaryStage);
        primaryStage.setTitle("Hyperspace Emulator");
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    private void createUI() {
        TextField inputField = new TextField();
        inputField.setMaxWidth(300);
        Label inputLabel = new Label("Where do you want to go in our Solar System?");
        inputLabel.setLabelFor(inputField);
        setBottomBar(new HBox(15));
        getBottomBar().setPadding(new Insets(20));
        getBottomBar().setAlignment(Pos.CENTER);
        getBottomBar().getChildren().addAll(inputLabel, inputField);
        setupInput(inputField);
    }

    private void setupInput(TextField inputField) {
        inputField.setOnAction(_ -> {
            travelTo(toSentenceCase(inputField.getText()));
        });
    }

}
