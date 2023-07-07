package com.example.multimediaplayer;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class backward {
    MediaPlayer player;

    public backward(MediaPlayer m){
        this.player=m;
    }

    public void back10Sec(){
        double d = player.getCurrentTime().toSeconds();
        d = d-10;
        player.seek(new Duration(d*1000));
    }

}
