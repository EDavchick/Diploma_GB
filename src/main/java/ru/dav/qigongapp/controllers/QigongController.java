package ru.dav.qigongapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ru.dav.qigongapp.models.Navigation;
import ru.dav.qigongapp.models.NavigationImpl;

public class QigongController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button btnAdvanced, btnBeginner, btnIntermediate, btnMeditation, btnLogin;

    @FXML
    private ImageView logo, imgCentral, instagramLink, telegramLink;

    @FXML
    private Navigation navigation;

    @FXML
    void initialize() {
//        System.out.println("mainPane: " + mainPane);
        navigation = new NavigationImpl();
        btnBeginner.setOnAction(actionEvent -> navigation
                .switchPage(mainPane, "/ru/dav/qigongapp/beginnerPage.fxml"));
        btnIntermediate.setOnAction(actionEvent -> navigation
                .switchPage(mainPane, "/ru/dav/qigongapp/intermediatePage.fxml"));
        btnAdvanced.setOnAction(actionEvent -> navigation
                .switchPage(mainPane, "/ru/dav/qigongapp/advancedPage.fxml"));
        btnMeditation.setOnAction(actionEvent -> navigation
                .switchPage(mainPane, "/ru/dav/qigongapp/meditationPage.fxml"));

    }

}
