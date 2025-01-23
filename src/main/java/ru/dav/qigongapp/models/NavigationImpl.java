package ru.dav.qigongapp.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class NavigationImpl implements Navigation {
    @Override
    public void switchPage(AnchorPane paneId, String fxmlPath) {
        try {
            // Проверка пути к FXML-файлу
            URL resource = getClass().getResource(fxmlPath);
            if (resource == null) {
                throw new IllegalArgumentException("FXML file not found: " + fxmlPath);
            }
//            System.out.println("Путь к FXML: " + fxmlPath);
            AnchorPane newPage = FXMLLoader.load(resource);
            paneId.getChildren().setAll(newPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void switchToHomePage(AnchorPane paneId, String fxmlPath) {
        switchPage(paneId, fxmlPath);
    }
}
