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

public class IntermediateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane intermediatePane;

    @FXML
    private Pagination paginationList;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView backHome, img01, img02, img03, img04, img05, img06, img07, img08, img09, img10;

    @FXML
    private final Navigation navigation = new NavigationImpl();

    private final PageContentProvider pageContentProvider = new PageContentImpl();

    @FXML
    void initialize() {
        backHome.setOnMouseClicked(mouseEvent -> navigation
                .switchToHomePage(intermediatePane, "/ru/dav/qigongapp/qigong-view.fxml"));

        ((PageContentImpl) pageContentProvider)
                .addImages(img01, img02, img03, img04, img05, img06, img07, img08, img09, img10);

        paginationList.setPageFactory(pageContentProvider::getPage);
    }
}
