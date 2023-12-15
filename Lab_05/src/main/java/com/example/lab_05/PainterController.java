package com.example.lab_05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.w3c.dom.events.MouseEvent;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    public void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }

    public void drawingAreaMouseDragged(javafx.scene.input.MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
