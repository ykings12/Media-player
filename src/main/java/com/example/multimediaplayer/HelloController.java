package com.example.multimediaplayer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    MediaPlayer player;

    @FXML
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

    private Boolean isMuted = true;
    @FXML
    private MediaView mediaView;

    @FXML
    private HBox mediaBarControl;
    @FXML
    private Button unmuteBtn;
    @FXML
    private Slider volumeSlider;

    @FXML
    private Label timeStamp;

    @FXML
    private MenuItem aboutUs;


    @FXML
    void openMediaMenu(ActionEvent event) {


        try {
            System.out.println("Open media clicked");
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);


            Media m = new Media(file.toURI().toURL().toString());
            mediaView.setPreserveRatio(true);
            mediaView.setFitHeight(1200);
            mediaView.setFitWidth(1000);


            if (player != null) {
                player.dispose();
            }

            player = new MediaPlayer(m);

            mediaView.setMediaPlayer(player);

            player.setOnReady(() -> {
                //when player gets ready;
                timeSlider.setMin(0);
                timeSlider.setMax(player.getMedia().getDuration().toSeconds());
                timeSlider.setValue(0);

                try {
                    playBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });


            player.setOnReady(() -> {
                //when player gets ready;
                timeSlider.setMin(0);
                timeSlider.setMax(player.getMedia().getDuration().toSeconds());
                timeSlider.setValue(0);

                try {
                    playBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });

            //listener on player...

            player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                    Duration d = player.getCurrentTime();
                    timeSlider.setValue(d.toSeconds());
//
                }
            });
            timeSlider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    double val = timeSlider.getValue();

                    if (timeSlider.isPressed()) {

                        player.seek(new Duration(val * 1000));
                    }
                    DecimalFormat dec = new DecimalFormat("#0.00");
                    timeStamp.setText(String.valueOf(dec.format(val)) + "/" + dec.format(player.getMedia().getDuration().toSeconds()));//timestamp

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setSpeed(MouseEvent event) {
        playbackSpeed p = new playbackSpeed(player, speedSlider);
        p.setSpeed();
    }


    @FXML
    void replay_click(ActionEvent event) throws FileNotFoundException {
        replay_click r = new replay_click(player, timeSlider, RepBtn);
        r.replay();

        playBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));


    }

    @FXML
    void exitPlayer(ActionEvent event) {

        new close_player();
    }

    @FXML
    void play(ActionEvent event) {
        play_pause p = new play_pause(player, playBtn);
        p.play();
    }

    @FXML
    void mute(ActionEvent event) {
        volumeSlider.setValue(0);

    }

    @FXML
    void volume_adjust(MouseEvent event) {
        volume_control v = new volume_control(player, volumeSlider, unmuteBtn);
        v.volume();
    }


    @FXML
    void about(ActionEvent event) {
        aboutsUs aboutus = new aboutsUs(aboutUs);
        aboutus.showInfo();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphics g = new graphics(playBtn, prevBtn, nextBtn, timeSlider, speedSlider, RepBtn, unmuteBtn);
        g.initialize();

    }

    @FXML
    void nextBtnClick(ActionEvent event) {
        forward f = new forward(player);
        f.for10Sec();
    }

    @FXML
    void prevBtnClick(ActionEvent event) {

        backward b = new backward(player);
        b.back10Sec();
    }


}
