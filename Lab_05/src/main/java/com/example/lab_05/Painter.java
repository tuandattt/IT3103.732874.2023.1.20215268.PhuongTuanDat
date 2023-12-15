package com.example.lab_05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Painter extends Application {
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(new URL("file:" + "G:\\OOP_Lab\\IT3103.732874.2023.1.20215268.PhuongTuanDat\\Lab_05\\src\\main\\java\\com\\example\\lab_05\\Painter.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
