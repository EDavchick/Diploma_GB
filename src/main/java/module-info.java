module ru.dav.qigongapp {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.media;


    opens ru.dav.qigongapp to javafx.fxml;
    opens ru.dav.qigongapp.controllers to javafx.fxml;
    opens ru.dav.qigongapp.models to javafx.fxml;
    exports ru.dav.qigongapp;
    exports ru.dav.qigongapp.controllers;
    exports ru.dav.qigongapp.models;
}