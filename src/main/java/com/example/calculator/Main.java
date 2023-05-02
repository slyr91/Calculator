package com.example.calculator;/*
Arouchian, Daryl
9/30/2018
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        Initializer controller = loader.getController();
        primaryStage.setTitle("SimpleCalculator");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("taskbar-calculator.png")));
        primaryStage.setScene(new Scene(root));
        controller.init(primaryStage.getScene());
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
