package ru.dav.qigongapp.models;

import javafx.scene.layout.AnchorPane;

public interface Navigation {
    /** Switch to the specified page.
     * @param paneId ID of the anchor pane to replace.
     * @param fxmlPath Path to the FXML file to load.
     */
    void switchPage(AnchorPane paneId, String fxmlPath);

    /** Switch to the home page.
     * @param paneId ID of the anchor pane to replace.
     * @param fxmlPath Path to the FXML home page file to load.
     */
    void switchToHomePage(AnchorPane paneId, String fxmlPath);
}
