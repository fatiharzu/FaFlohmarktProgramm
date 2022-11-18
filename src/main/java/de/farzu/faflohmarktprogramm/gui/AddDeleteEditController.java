package de.farzu.faflohmarktprogramm.gui;

import de.farzu.faflohmarktprogramm.logic.ProductHolder;
import de.farzu.faflohmarktprogramm.model.Products;
import de.farzu.faflohmarktprogramm.settings.AppTexts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Steuerlogik für die Hinzufügen-Löschen-Bearbeiten-Szene
 */
public class AddDeleteEditController implements Initializable {
    //    region Konstanten
    //    endregion


    //    region Attribute
    private String[] productSelection = {"Kleidung   ", "Spielzeug  ", "Kindermöbel", "Kinderbuch "};

    private Integer[] alterGroupSelection = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    @FXML
    private Button clearButton;
    @FXML
    private ChoiceBox<String> productChoiceBox;
    @FXML
    private ChoiceBox<Integer> alterGroupChoiceBox;
    @FXML
    public TextField txtSpecies;
    @FXML
    public TextField txtAlterGroup;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtDescription;
    @FXML
    public Label productTypeLabel;
    @FXML
    public Label alterGroupLabel;

    public Products selectedProduct;

    //    endregion


    //    regionKonstruktor

    //    endregion


    //    regionMethoden
    /**
     * Setzt das selektierte Produkt und füllt die Textfelder
     * mit den Werten seiner Eigenschaften
     *
     * @param selectedProduct : {@link Products} : In der Übersicht ausgewähltes Produkt
     */
    public void setSelectedProduct(Products selectedProduct){
        this.selectedProduct = selectedProduct;

        if (selectedProduct != null){
            txtSpecies.setText(selectedProduct.getSpecies());
            txtAlterGroup.setText(String.valueOf(selectedProduct.getAlterGroup()));
            txtName.setText(selectedProduct.getName());
            txtDescription.setText(selectedProduct.getDescription());
        }
    }
    /**
     * Speichert ein Produkt aus der Liste
     */
    @FXML
    private void saveProdukt() {
        if (selectedProduct != null) {

            if (textFieldIsNotBlankEmptyOrEqual(txtSpecies, selectedProduct.getSpecies()))
                selectedProduct.setSpecies(txtSpecies.getText());

            if (textFieldIsNotBlankEmptyOrEqual(txtName, selectedProduct.getName()))
                selectedProduct.setName(txtName.getText());

            if (textFieldIsNotBlankEmptyOrEqual(txtAlterGroup, String.valueOf(selectedProduct.getAlterGroup())))
                selectedProduct.setAlterGroup(Integer.parseInt(txtAlterGroup.getText()));

            if (textFieldIsNotBlankEmptyOrEqual(txtDescription, selectedProduct.getDescription()))
                selectedProduct.setDescription(txtDescription.getText());

            switchToSortScene();

            }else{
            try {
                Products newProduct = new Products(
                        txtSpecies.getText(),
                        Integer.parseInt(txtAlterGroup.getText()),
                        txtName.getText(),
                        txtDescription.getText()

                );
                ProductHolder.getInstance().getProducts().add(newProduct);
                switchToSortScene();
            }catch (NumberFormatException e){
                productTypeLabel.setText("Please enter Text");
                alterGroupLabel.setText("Please enter Numbers");
            }catch (Exception e){
                productTypeLabel.setText("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Gehen Sie mit dem Start-Button auf die Start szene
     */
    @FXML
    private void switchToStartScene() {
        SceneManager.getInstance().switchToStartScene();
    }

    /**
     * Gehen Sie mit dem Liste-Button auf die Listen szene
     */
    @FXML
    private void switchToSortScene() {SceneManager.getInstance().switchToSortScene();}

    /**
     * Löscht ein Produkt aus der Liste
     */
    @FXML
    private void conveyAnimal() {
        if (selectedProduct != null) {
            ProductHolder.getInstance().getProducts().remove(selectedProduct);

        }
        switchToSortScene();
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

    /**
     * Wählt den Produktwert der Schaltfläche Select Box aus
     * @param event
     */
    public void getProduct(ActionEvent event){
        String products = productChoiceBox.getValue();
        txtSpecies.setText(products);

    }

    /**
     * Wählt den Altergroup-Wert der Select Box-Schaltfläche aus
     * @param event
     */
    public void getAlterGroup(ActionEvent event){
        Integer alterGroup = alterGroupChoiceBox.getValue();
        txtAlterGroup.setText(String.valueOf(alterGroup));

    }

    /**
     * Leert Textfelder
     * @param event
     */
    public void setClearEmpty(ActionEvent event){

        txtSpecies.setText(AppTexts.EMPTY_TEXT);
        txtName.setText(AppTexts.EMPTY_TEXT);
        txtDescription.setText(AppTexts.EMPTY_TEXT);
        alterGroupChoiceBox.setValue(null);
        productChoiceBox.setValue("");
        txtAlterGroup.setText(String.valueOf(AppTexts.EMPTY_TEXT));
    }

    //    endregion

}
