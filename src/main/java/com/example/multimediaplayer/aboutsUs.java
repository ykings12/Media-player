package com.example.multimediaplayer;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class aboutsUs {
    @FXML
    private MenuItem aboutUs;

    public aboutsUs(MenuItem s) {
        this.aboutUs = s;
    }

    public void showInfo() {
        String info;
        info = " Developed by:\n";

        info += " Banoth Jithendra\n";
        info += "Yash Kumar Singh\n";
//        info+="\t \t&\n";
        info += "    Aman Kumar\n";
        info += "\u00A9 Media Player\n";
        Text textArea = new Text();
        textArea.setText(info);
        BorderPane pane = new BorderPane();
        textArea.setFont(new Font("Sans-Serif", 20));
        pane.setCenter(textArea);
        Stage stage = new Stage();
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("About Us");
        stage.setScene(scene);
        stage.show();

    }

}
