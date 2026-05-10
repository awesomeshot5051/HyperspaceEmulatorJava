package com.awesomeshot5051.Variables;

import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Variables {
    private static Image image;
    private static ImageView imageView;
    private static Stage stage;
    private static HBox bottomBar;

    public static Image getImage() {
        return image;
    }

    public static void setImage(Image Image) {
        image = Image;
    }

    public static ImageView getImageView() {
        return imageView;
    }

    public static void setImageView(ImageView ImageView) {
        imageView = ImageView;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage Stage) {
        stage = Stage;
    }

    public static HBox getBottomBar() {
        return bottomBar;
    }

    public static void setBottomBar(HBox bar) {
        bottomBar = bar;
    }
}
