package com.example.multimediaplayer;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class forward {
    MediaPlayer player;

    public forward(MediaPlayer m){
        this.player=m;
    }

    public void for10Sec(){
        double d = player.getCurrentTime().toSeconds();
        d = d+10;
        player.seek(new Duration(d*1000));
    }

}
