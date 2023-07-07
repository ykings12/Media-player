package com.example.multimediaplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.FileInputStream;


public class play_pause {
    @FXML
    public Button buttons;
    public MediaPlayer player;

    public play_pause(MediaPlayer m, Button b) {
        this.buttons = b;
        this.player = m;

    }


    public void play() {
        try {
            MediaPlayer.Status status = player.getStatus();

            if (status == MediaPlayer.Status.PLAYING) {
                player.pause();
                buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));

            } else {

                player.play();
                buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/pause.png"))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
