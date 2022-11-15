        package de.farzu.faflohmarktprogramm.gui;

        import de.farzu.faflohmarktprogramm.Main;
        import de.farzu.faflohmarktprogramm.model.Products;
        import de.farzu.faflohmarktprogramm.settings.AppTexts;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

        import java.io.IOException;

        public class SceneManager {
        //    region Konstanten

        //    endregion

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
             Image icon = new Image("C:\\Users\\toni\\Desktop\\Alfatraining Projects\\FaFlohmarktProgramm\\src\\main\\java\\de\\farzu\\faflohmarktprogramm\\assets\\icon\\icon.jpg");
             mainStage.getIcons().add(icon);
             switchToStartScene();
         }

         public void switchToSortScene() {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/sort-layout.fxml"));
             try {
                 Scene sortScene = new Scene(fxmlLoader.load());
                 switchScene(sortScene);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

         public void switchToStartScene() {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/start-layout.fxml"));
             try {
                 Scene startScene = new Scene(fxmlLoader.load());
                 switchScene(startScene);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

         public void switchToAddScene(Products selectedProduct) {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/add-layout.fxml"));
             try {
                 Scene addScene = new Scene(fxmlLoader.load());
                 AddController addController = fxmlLoader.getController();
                 addController.setSelectedProduct(selectedProduct);

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
