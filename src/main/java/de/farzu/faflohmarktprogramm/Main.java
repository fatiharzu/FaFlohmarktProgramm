package de.farzu.faflohmarktprogramm;

import de.farzu.faflohmarktprogramm.gui.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

    public class Main extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            SceneManager.getInstance().setAndConfigureMainStage(stage);
        }

        public static void main(String[] args) {
            launch();
        }
    }