package de.farzu.faflohmarktprogramm.gui.listview;

import de.farzu.faflohmarktprogramm.model.Products;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


    public class ListViewProduktCellFactory implements Callback<ListView<Products>, ListCell<Products>> {
        //    region Konstanten
        //    endregion

        //    region Attribute
        //    endregion

        //    regionKonstruktor
        //    endregion

        //    regionMethoden
        @Override
        public ListCell<Products> call(ListView<Products> productsListView) {
            return new ListViewProdukCell();
        }
        //    endregion

    }
