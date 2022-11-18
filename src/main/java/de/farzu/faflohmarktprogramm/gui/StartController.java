package de.farzu.faflohmarktprogramm.gui;

import de.farzu.faflohmarktprogramm.settings.AppTexts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class StartController  {

    /**
     * Gehen Sie mit dem Erstellt-Button auf die Erstellt szene
     */
    @FXML
    private void switchToAddSceneForNewProduct() {
        SceneManager.getInstance().switchToAddScene(null);
    }

    /**
     * Gehen Sie mit dem Liste-Button auf die Listenszene
     */
    @FXML
    private void switchToSortScene(){
        SceneManager.getInstance().switchToSortScene();
    }

    /**
     * Enthält eine Schaltfläche für kurze Informationen über das Programm.
     */
    @FXML
    private void appAbout(){
        final String msg = AppTexts.MSG_ALERT;
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.setTitle(AppTexts.ALERT_TITLE);
        alert.setHeaderText(null);
        alert.showAndWait();
    }


}