/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thisisivan.linesfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Ivan Karyakin
 */
public class FxLines extends Application {

    double smoothStep = 0.1;


    Line line1;
    Pane root = new Pane();
    int x1, x2, y1, y2;
    int delta = 12;

    @Override
    public void start(Stage primaryStage) {
        x1 = 10; x2 = 10; y1 =100; y2 = 150;
        Button btn = new Button();
        btn.setStyle("-fx-border-width: 1; -fx-border-color: #FFE7E7E8; -fx-background-color: #252526;-fx-font-family-name: korolev;-fx-font-size: 20;-fx-text-fill: #FFE7E7E8");
        btn.setText("Draw the spiral");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                x1 += delta;
//                y2 += delta;
//                Line line = new Line(x1,y1,x2,y2);
//                line.setStroke(Color.web("#FFE7E7E8",1));
//                line.setStrokeWidth(2);
//                root.getChildren().add(line);
                initialize();
            }
        });
        root.setStyle("-fx-background-color: #252526");
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Draw spiral on click");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void initialize(){
        for (double i = 0; i<100; i=i + smoothStep) {
            Line line = new Line(getSpiralXValue(i), getSpiralYValue(i), getSpiralXValue(i + smoothStep), getSpiralYValue(i + smoothStep));
            line.setStroke(Color.web("#FFE7E7E8",1));
            line.setStrokeWidth(3);
            root.getChildren().add(line);
        }

    }

    public double getSpiralXValue(double x)
    {
        return 2 * x * Math.cos(x) + 250;
    }

    public double getSpiralYValue(double y)
    {
        return 2 * y * Math.sin(y) + 250;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
