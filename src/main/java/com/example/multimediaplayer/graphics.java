package com.example.multimediaplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class graphics {

    private Slider speedSlider;
    @FXML
    private Slider timeSlider;
    @FXML
    private Button nextBtn;

    @FXML
    private Button prevBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Button RepBtn;

    @FXML
    private Button unmuteBtn;

    graphics(Button playBtn, Button prevBtn, Button nextBtn, Slider timeSlider, Slider speedSlider, Button RepBtn, Button unmuteBtn) {
        this.playBtn = playBtn;
        this.prevBtn = prevBtn;
        this.nextBtn = nextBtn;
        this.timeSlider = timeSlider;
        this.speedSlider = speedSlider;
        this.RepBtn = RepBtn;
        this.unmuteBtn = unmuteBtn;
    }


    public void initialize() {
        try {
            playBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));
            prevBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/prev.png"))));
            nextBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/next.png"))));
            RepBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/Replay.jpeg"))));
            unmuteBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/vol.png"))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
