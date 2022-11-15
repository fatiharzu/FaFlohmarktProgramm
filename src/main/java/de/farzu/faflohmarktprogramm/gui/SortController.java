package de.farzu.faflohmarktprogramm.gui;

import de.farzu.faflohmarktprogramm.gui.listview.ListViewProduktCellFactory;
import de.farzu.faflohmarktprogramm.logic.ProductHolder;
import de.farzu.faflohmarktprogramm.model.Products;
import de.farzu.faflohmarktprogramm.settings.AppSettings;
import de.farzu.faflohmarktprogramm.settings.AppTexts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.ResourceBundle;

public class SortController implements Initializable {

    //    region Konstanten
    //    endregion


    //    region Attribute
    @FXML
    private ListView<Products> productsListView;
    //    endregion


    //    regionKonstruktor
    //    endregion


    //    regionMethoden

    @FXML
    private void sortProductList(ActionEvent actionEvent) {

        if (actionEvent.getSource() instanceof Button sortButton) {
            switch (sortButton.getId()) {
                case AppSettings.BTN_SORT_SPECIES_ID -> ProductHolder.getInstance().sortBySpecies();
                case AppSettings.BTN_SORT_NAME_ID -> ProductHolder.getInstance().sortByName();
                case AppSettings.BTN_SORT_ALTER_GROUP_ID ->  ProductHolder.getInstance().sortByGroupAlter();
                default -> System.err.println(AppTexts.MSG_INVALID_SORT_BUTTON);
            }
        }
    }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            productsListView.setCellFactory(new ListViewProduktCellFactory());

        //   ObservableList<Products> productsObservableList = FXCollections.observableList(TestData.getTestProducts());


            productsListView.setItems(ProductHolder.getInstance().getProducts());

            productsListView.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() ==  AppSettings.DETAIL_CLICK_COUNT &&
                        mouseEvent.getButton() == MouseButton.PRIMARY){
                    Products selectedProduct = productsListView.getSelectionModel().getSelectedItem();
                    SceneManager.getInstance().switchToAddScene(selectedProduct);
                }
            });

            productsListView.setOnKeyPressed(keyEvent ->{
                if (keyEvent.getCode() == KeyCode.ENTER){
                    Products selectedProduct = productsListView.getSelectionModel().getSelectedItem();
                    SceneManager.getInstance().switchToAddScene(selectedProduct);
                }
            });

        }
        @FXML
        private void switchToStartScene() {
            SceneManager.getInstance().switchToStartScene();
        }

        @FXML
        private void switchToAddSceneForNewProduct() {
            SceneManager.getInstance().switchToAddScene(null);
        }



    //    endregion

}
