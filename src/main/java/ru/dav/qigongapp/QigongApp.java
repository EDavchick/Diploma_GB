package ru.dav.qigongapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

public class QigongApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("qigong-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent windowEvent) {
//                Platform.exit();
////                System.exit(0);
//                windowEvent.consume();
//            }
//        });
    }

    public static void main(String[] args) {
        launch();
    }
}