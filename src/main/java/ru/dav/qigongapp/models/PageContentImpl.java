package ru.dav.qigongapp.models;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageContentImpl implements PageContentProvider {

    private List<ImageView> images;

    // Создаем список изображений здесь
    public PageContentImpl() {
        images = new ArrayList<>();
    }

    @Override
    public void setPageImages(List<ImageView> images) {
        this.images = images;
    }

    @Override
    public StackPane getPage(int pageIndex) {
        StackPane pageContent = new StackPane();

        if (images == null || images.isEmpty() || pageIndex < 0 || pageIndex >= images.size()) {
            Label placeholder = new Label("No image available");
            pageContent.getChildren().add(placeholder);
            return pageContent;
        }

        ImageView selectedImage = images.get(pageIndex);

//      Скрываем все изображения, кроме выбранного
        for (ImageView image : images) {
            image.setVisible(false);
        }
//         Делаем выбранное изображение видимым и настраиваем ImageView
        selectedImage.setVisible(true);
        selectedImage.setFitWidth(366);
        selectedImage.setFitHeight(250);
        selectedImage.setPreserveRatio(true);

//         Добавим imgView на Страницу Контента
        pageContent.getChildren().add(selectedImage);
        return pageContent;
    }

    //     Метод для первоначальной инициализации изображений
    public void addImages(ImageView... images) {
        Collections.addAll(this.images, images);
    }
}
