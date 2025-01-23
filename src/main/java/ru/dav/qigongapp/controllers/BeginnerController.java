package ru.dav.qigongapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import ru.dav.qigongapp.models.Navigation;
import ru.dav.qigongapp.models.NavigationImpl;
import ru.dav.qigongapp.models.PageContentImpl;
import ru.dav.qigongapp.models.PageContentProvider;

public class BeginnerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    AnchorPane beginnerPane;

    @FXML
    Pagination paginationList;

    @FXML
    StackPane stackPane;

    @FXML
    ImageView backHome;
    @FXML
    ImageView img01;
    @FXML
    ImageView img02;
    @FXML
    ImageView img03;
    @FXML
    ImageView img04;
    @FXML
    ImageView img05;
    @FXML
    ImageView img06;
    @FXML
    ImageView img07;
    @FXML
    ImageView img08;
    @FXML
    ImageView img09;
    @FXML
    ImageView img10;

    @FXML
    final Navigation navigation = new NavigationImpl();

    private final PageContentProvider pageContentProvider = new PageContentImpl();

    @FXML
    void initialize() {
        backHome.setOnMouseClicked(mouseEvent -> navigation
                .switchToHomePage(beginnerPane, "/ru/dav/qigongapp/qigong-view.fxml"));

        // Инициализация изображений в PageContentProvider
        ((PageContentImpl) pageContentProvider)
                .addImages(img01, img02, img03, img04, img05, img06, img07, img08, img09, img10);

        paginationList.setPageFactory(pageContentProvider::getPage);
    }
}
