package de.farzu.faflohmarktprogramm.gui.listview;

import de.farzu.faflohmarktprogramm.model.Products;
import de.farzu.faflohmarktprogramm.settings.AppTexts;
import javafx.scene.control.ListCell;

    public class ListViewProdukCell extends ListCell<Products> {
    //    region Konstanten
    //    endregion

    //    region Attribute
    //    endregion

    //    regionKonstruktor
    //    endregion

    //    regionMethoden
        @Override
        protected void updateItem(Products productToShow, boolean isEmpty) {
            super.updateItem(productToShow, isEmpty);

            if (isEmpty && productToShow == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(String.format(AppTexts.PRODUCT_FORMAT_STRING, productToShow.getSpecies(),  productToShow.getAlterGroup(),
                        productToShow.getName(), productToShow.getDescription()));
            }
        }
    //    endregion

}
