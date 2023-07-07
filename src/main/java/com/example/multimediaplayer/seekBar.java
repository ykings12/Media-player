//package com.example.multimediaplayer;
//
//import javafx.beans.Observable;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.Slider;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.DragEvent;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import javafx.util.Duration;
//
//import java.io.FileInputStream;
//import java.text.DecimalFormat;
//
//public class seekBar{
//
//    @FXML
//    private Label timeStamp;
//
//    @FXML
//    private Button playBtn;
//    @FXML
//    private MediaPlayer player;
//
//    private Slider timeSlider;
//
//    seekBar(MediaPlayer player, Slider timeSlider) {
//        this.player = player;
//        this.timeSlider = timeSlider;
//    }
//
//
//    public void seek() {
//        try {
//
//            //listener on player...
//
//
//                public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
//                    Duration d = player.getCurrentTime();
//                    timeSlider.setValue(d.toSeconds());
////                   timeStamp.textProperty().bind(Bindings.format("%f", d));
//                }
//            });
//            timeSlider.valueProperty().addListener(new ChangeListener<Number>() {
//                @Override
//                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                    double val = timeSlider.getValue();
//
//                    if(timeSlider.isPressed()){
//
//                        player.seek(new Duration(val*1000));
//                    }
//                    DecimalFormat dec = new DecimalFormat("#0.00");
//                    timeStamp.setText(String.valueOf(dec.format(val)) + "/" + dec.format(player.getMedia().getDuration().toSeconds()));//timestamp
//
//                }
//            });
//        }
//}