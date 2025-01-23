package ru.dav.qigongapp.models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.util.List;

public interface PageContentProvider {
    StackPane getPage(int pageIndex);
    void setPageImages(List<ImageView> images);
}
