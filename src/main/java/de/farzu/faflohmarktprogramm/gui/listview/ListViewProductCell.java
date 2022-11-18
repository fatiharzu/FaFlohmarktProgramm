package de.farzu.faflohmarktprogramm.gui.listview;

import de.farzu.faflohmarktprogramm.model.Products;
import de.farzu.faflohmarktprogramm.settings.AppTexts;
import javafx.scene.control.ListCell;
        /**
         * Definiert eine Zelle, wie sie in der ListView
         * angezeigt werden soll.
         */
    public class ListViewProductCell extends ListCell<Products> {
    //    region Konstanten
    //    endregion

    //    region Attribute
    //    endregion

    //    regionKonstruktor
    //    endregion

    //    regionMethoden
        /**
         * Aktualisiert den Inhalt einer Zelle und zeigt ihn
         * auf die implementierte Art und Weise an. Die Zellen
         * werden von {@link ListViewProductCellFactory} aufgebaut.
         *
         * @param productToShow : {@link Products} : Das anzuzeigende Produkt
         * @param isEmpty: boolean: Gibt an, ob Zelle leer sein soll oder nicht
         */
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
