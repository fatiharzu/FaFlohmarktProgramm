package de.farzu.faflohmarktprogramm.gui;

import de.farzu.faflohmarktprogramm.logic.ProductHolder;
import de.farzu.faflohmarktprogramm.model.Products;
import de.farzu.faflohmarktprogramm.settings.AppTexts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    //    region Konstanten
    //    endregion


    //    region Attribute

    @FXML
    private Button clearButton;
    @FXML
    private ChoiceBox<String> productChoiceBox;
    @FXML
    private ChoiceBox<Integer> alterGroupChoiceBox;
    @FXML
    public TextField myTextField;
    @FXML
    public TextField txtAlterGroup;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtDescription;

    public Products selectedProduct;

    //    endregion


    //    regionKonstruktor
    private String[] productSelection = {"Kleidung", "Spielzeug", "Kindermöbel", "Kinderbuch"};

    private Integer[] alterGroupSelection = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    //    endregion


    //    regionMethoden
    public void setSelectedProduct(Products selectedProduct){
        this.selectedProduct = selectedProduct;

        if (selectedProduct != null){
            myTextField.setText(selectedProduct.getSpecies());
            txtAlterGroup.setText(String.valueOf(selectedProduct.getAlterGroup()));
            txtName.setText(selectedProduct.getName());
            txtDescription.setText(selectedProduct.getDescription());
        }
    }
    @FXML
    private void saveAnimal() {
        if (selectedProduct != null) {

            if (textFieldIsNotBlankEmptyOrEqual(myTextField, selectedProduct.getSpecies()))
                selectedProduct.setSpecies(myTextField.getText());

            if (textFieldIsNotBlankEmptyOrEqual(txtName, selectedProduct.getName()))
                selectedProduct.setName(txtName.getText());

            if (textFieldIsNotBlankEmptyOrEqual(txtAlterGroup, String.valueOf(selectedProduct.getAlterGroup())))
                selectedProduct.setAlterGroup(Integer.parseInt(txtAlterGroup.getText()));

            if (textFieldIsNotBlankEmptyOrEqual(txtDescription, selectedProduct.getDescription()))
                selectedProduct.setDescription(txtDescription.getText());

        } else {

            Products newProduct = new Products(
                    myTextField.getText(),
                    Integer.parseInt(txtAlterGroup.getText()),
                    txtName.getText(),
                    txtDescription.getText()
            );

          ProductHolder.getInstance().getProducts().add(newProduct);
        }

        switchToStartScene();
    }

    @FXML
    private void switchToStartScene() {
        SceneManager.getInstance().switchToStartScene();
    }

    @FXML
    private void switchToSortScene() {SceneManager.getInstance().switchToSortScene();}

    @FXML
    private void conveyAnimal() {
        if (selectedProduct != null) {
            ProductHolder.getInstance().getProducts().remove(selectedProduct);
            switchToSortScene();
        }
    }

    private boolean textFieldIsNotBlankEmptyOrEqual(TextField textField, String attributeValue) {
        return !textField.getText().isBlank() &&
                !textField.getText().isEmpty() &&
                !textField.getText().equals(attributeValue);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productChoiceBox.getItems().addAll(productSelection);
        productChoiceBox.setOnAction(this::getProduct);
        alterGroupChoiceBox.getItems().addAll(alterGroupSelection);
        alterGroupChoiceBox.setOnAction(this::getAlterGroup);
        clearButton.setOnAction(this::setClearEmpty);

    }
    public void getProduct(ActionEvent event){
        String products = productChoiceBox.getValue();
        myTextField.setText(products);

    }

    public void getAlterGroup(ActionEvent event){
        Integer alterGroup = alterGroupChoiceBox.getValue();
        txtAlterGroup.setText(String.valueOf(alterGroup));

    }

    public void setClearEmpty(ActionEvent event){

        myTextField.setText(AppTexts.EMPTY_TEXT);
        txtName.setText(AppTexts.EMPTY_TEXT);
        txtDescription.setText(AppTexts.EMPTY_TEXT);
        alterGroupChoiceBox.setValue(null);
        productChoiceBox.setValue(" ");
        txtAlterGroup.setText(String.valueOf(AppTexts.EMPTY_TEXT));
    }
    //    endregion

}
