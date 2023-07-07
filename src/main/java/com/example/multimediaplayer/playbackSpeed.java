package com.example.multimediaplayer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

public class playbackSpeed {
    Slider speedSlider;
    MediaPlayer player;

    public playbackSpeed(MediaPlayer m, Slider s) {
        this.player = m;
        this.speedSlider = s;
    }

    public void setSpeed() {
        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                double s = speedSlider.getValue();
                player.setRate(s);
            }
        });
    }
}
