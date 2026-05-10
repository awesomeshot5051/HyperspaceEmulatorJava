package com.awesomeshot5051.Utilities.GifLoading;

import javafx.scene.image.*;

import java.util.*;

import static com.awesomeshot5051.Variables.Variables.*;

public class LoadGifs {
    public static void loadGif(String gifName) {
        // 1. Ensure the extension is present
        if (!gifName.toLowerCase().endsWith(".gif")) gifName += ".gif";

        try {
            Image newImage = new Image(Objects.requireNonNull(LoadGifs.class.getResourceAsStream("/" + gifName)));
            setImage(newImage);

            // 2. If the ImageView doesn't exist, create it.
            // If it DOES exist, just update the image so the UI refreshes live.
            if (getImageView() == null) {
                ImageView view = new ImageView(getImage());
                view.setFitWidth(1920);
                view.setFitHeight(1080);
                view.setPreserveRatio(false);
                view.setSmooth(true);
                setImageView(view);
            } else getImageView().setImage(getImage());
        } catch (NullPointerException e) {
            System.err.println("Could not find GIF: " + gifName);
        }
    }
}