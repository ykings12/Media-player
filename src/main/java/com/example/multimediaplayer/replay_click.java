package com.example.multimediaplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class replay_click {
    @FXML
    public MediaPlayer player;

    @FXML
    public Slider timeSlider;

    @FXML
    public Button RepBtn;
    @FXML
    public Button playBtn;

    @FXML
    public play_pause playans;

    replay_click(MediaPlayer mm, Slider ss, Button pp) {
        this.player = mm;
        this.timeSlider = ss;
        this.RepBtn = pp;
    }

    public void replay() throws FileNotFoundException {

        try {
            MediaPlayer.Status status = player.getStatus();
            playans = new play_pause(player, playBtn);
            if (status == MediaPlayer.Status.PLAYING) {

                playans.play();

                player.seek(new Duration(0));
                timeSlider.setValue(0);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}