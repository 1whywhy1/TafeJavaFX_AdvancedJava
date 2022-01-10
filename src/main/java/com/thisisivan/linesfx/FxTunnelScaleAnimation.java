package com.thisisivan.linesfx;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ivan Karyakin
 */

public class FxTunnelScaleAnimation extends Application {

    private double stageHt, stageWd, midX, midY;
    private int number = 50;
    private double rad= 200f;
    private double radStep= 5f;
    private double scaleFrom = 0f;
    private double scaleTo = 10f;
    private double durationMills = 3000;
    private int cycleCount = 500;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The Tunnel");

        //create a group, all GUI elements will be added to this group
        //the group is then added to primaryStage
        Group grp = new Group();
        Scene newScene = new Scene(grp, 500, 500, Color.web("FF252526",1));

        stageHt = newScene.getHeight();
        stageWd = newScene.getWidth();

        //put circle in the center
        midX = stageWd/2;
        midY = stageHt/2;

        // declaring 50 circles
        Circle[] circles = new Circle[number];
        ScaleTransition[] scaleTransitions = new ScaleTransition[number];

        // setting up circles
        for (int i = 0; i < number; i++)
        {
            circles[i] = new Circle(midX,midY, rad,
                    Color.color(Math.random(), Math.random(), Math.random()));
            scaleTransitions[i] = new ScaleTransition(Duration.millis(durationMills), circles[i]);
            scaleTransitions[i].setFromX(scaleFrom);
            scaleTransitions[i].setFromY(scaleFrom);
            scaleTransitions[i].setToX(scaleTo);
            scaleTransitions[i].setToY(scaleTo);
            scaleTransitions[i].setCycleCount(cycleCount);
            scaleTransitions[i].setAutoReverse(true);
            scaleTransitions[i].play();
            grp.getChildren().add(circles[i]);
            rad -= radStep;
            //scaleTo *= scaleTo;
        }

        primaryStage.setScene(newScene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
