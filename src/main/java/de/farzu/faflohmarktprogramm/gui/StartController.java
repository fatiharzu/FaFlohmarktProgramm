package de.farzu.faflohmarktprogramm.gui;

import javafx.fxml.FXML;

public class StartController  {

    @FXML
    private void switchToAddSceneForNewProduct() {
        SceneManager.getInstance().switchToAddScene(null);
    }

    @FXML
    private void switchToSortScene(){
        SceneManager.getInstance().switchToSortScene();
    }


}