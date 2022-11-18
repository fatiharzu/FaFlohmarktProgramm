package de.farzu.faflohmarktprogramm.gui.listview;

import de.farzu.faflohmarktprogramm.model.Products;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

        /**
         * Baut die ListView mittels der hier
         * definierten Zellen {@link ListViewProductCell} auf.
         */
    public class ListViewProductCellFactory implements Callback<ListView<Products>, ListCell<Products>> {
        //    region Konstanten
        //    endregion

        //    region Attribute
        //    endregion

        //    regionKonstruktor
        //    endregion

        //    regionMethoden
            /**
             * Baut für jedes Element der ObservableList der ListView eine neue Zelle auf
             * und liefert diese zurück.
             *
             * @param productsListView : {@link ListView<Products>} : Listview mit der Liste der Product
             *
             * @return {@link ListViewProductCell}: Objekt der eigenen Zellen-Klasse
             */
        @Override
        public ListCell<Products> call(ListView<Products> productsListView) {
            return new ListViewProductCell();
        }
        //    endregion

    }
