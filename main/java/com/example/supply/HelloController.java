package com.example.supply;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

//import java.awt.event.MouseEvent;
import java.io.IOException;
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(MouseEvent event) throws IOException {

       // welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println("hello is clicked");
    }
}