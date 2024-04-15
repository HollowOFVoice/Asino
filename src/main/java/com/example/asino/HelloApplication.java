package com.example.asino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private FXMLLoader fxmlLoader;
    private static HelloController helloController;

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Азино 777");
        stage.setScene(scene);
        helloController = fxmlLoader.getController();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}