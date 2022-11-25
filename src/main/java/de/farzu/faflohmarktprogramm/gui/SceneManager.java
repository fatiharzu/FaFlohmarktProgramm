        package de.farzu.faflohmarktprogramm.gui;

        import de.farzu.faflohmarktprogramm.Main;
        import de.farzu.faflohmarktprogramm.model.Products;
        import de.farzu.faflohmarktprogramm.settings.AppTexts;
        import de.farzu.faflohmarktprogramm.settings.AppUrl;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

        import java.io.IOException;
        /**
         * Singleton, welcher zuständig für das Wechseln der Szenen ist.
         */
        public class SceneManager {

        //    region Attribute
        private Stage mainStage;
        private static SceneManager instance;
        //    endregion

        //    regionKonstruktor
        private SceneManager() {}
        //    endregion

        //    regionMethoden
        public static synchronized SceneManager getInstance() {
            if (instance == null) instance = new SceneManager();
            return instance;
        }

         public void setAndConfigureMainStage(Stage stage) {
             mainStage = stage;
             mainStage.setTitle(AppTexts.APP_NAME);
             Image icon = new Image(AppUrl.MAIN_SCENE_IMAGE);
             mainStage.getIcons().add(icon);
             switchToStartScene();
         }
            /**
             * Gehen Sie mit dem Start-Button auf die Startszene
             */

         public void switchToSortScene() {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(AppUrl.FXML_SORT));
             try {
                 Scene sortScene = new Scene(fxmlLoader.load());
                 switchScene(sortScene);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
            /**
             * Gehen Sie mit dem Erstellt-Button auf die Erstellt szene
             */
         public void switchToStartScene() {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(AppUrl.FXML_START));
             try {
                 Scene startScene = new Scene(fxmlLoader.load());
                 switchScene(startScene);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

            /**
             * Um die Produktmitglieder zu ändern oder zu löschen, gehen Sie mit dem Produkt auf die Produkterstelltszene.
             * @param selectedProduct
             */
         public void switchToAddScene(Products selectedProduct) {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(AppUrl.FXML_ADD_EDIT_DELETE));
             try {
                 Scene addScene = new Scene(fxmlLoader.load());
                 AddDeleteEditController addDeleteEditController = fxmlLoader.getController();
                 addDeleteEditController.setSelectedProduct(selectedProduct);

                 switchScene(addScene);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         private void switchScene(Scene scene) {
              mainStage.setScene(scene);
              mainStage.show();
         }


        //    endregion

 }
