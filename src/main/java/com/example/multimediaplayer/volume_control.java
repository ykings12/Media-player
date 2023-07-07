package com.example.multimediaplayer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.FileInputStream;

public class volume_control {
    @FXML
    private Button unmuteBtn;

    private Boolean isMuted = true;
    public Slider volumeSlider;
    public MediaPlayer player;

    public volume_control(MediaPlayer m, Slider s, Button unmuteBtn) {
        this.volumeSlider = s;
        this.player = m;
        this.unmuteBtn = unmuteBtn;

    }

    public void volume() {
        volumeSlider.setValue(player.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                player.setVolume(volumeSlider.getValue() / 100);
                if (player.getVolume() != 0.0) {

                    try {
                        unmuteBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/vol.png"))));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        unmuteBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/mute.png"))));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }


}
