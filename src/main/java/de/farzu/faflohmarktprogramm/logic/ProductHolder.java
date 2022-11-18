package de.farzu.faflohmarktprogramm.logic;

import de.farzu.faflohmarktprogramm.logic.db.DbManager;
import de.farzu.faflohmarktprogramm.model.Products;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import java.util.Comparator;
        /**
         * Klasse, welche alle Produkten als ObservableList bereitstellt
         */

    public class ProductHolder {
    //    region Konstanten
    //    endregion


    //    region Attribute
        private static ProductHolder instance;
        private ObservableList<Products> products;
    //    endregion


    //    regionKonstruktor

        public ProductHolder() {
            products = FXCollections.observableArrayList(products ->
                    new Observable[] {products.speciesProperty(), products.alterGroupProperty(),
                    products.nameProperty(), products.descriptionProperty()
            });

            products.addAll(DbManager.getInstance().realAllDataRecords());

            products.addListener(new ListChangeListener<Products>() {
                @Override
                public void onChanged(Change<? extends Products> change) {

                    System.out.println(change);

                    while(change.next()){

                        if (change.wasAdded()){
                            Products productToInsert = change.getAddedSubList().get(0);
                            DbManager.getInstance().insertDataRecord(productToInsert);

                        } else if (change.wasRemoved()) {
                            Products productToDelete = change.getRemoved().get(0);
                            DbManager.getInstance().deleteDataRecord(productToDelete);
                        } else if (change.wasUpdated()) {
                            int updateIndex = change.getFrom();
                            Products productToUpdate = change.getList().get(updateIndex);
                            DbManager.getInstance().updateDataRecord(productToUpdate);
                        }
                    }
                }
            });
        }

        //    endregion


        //    regionMethoden
        public ObservableList<Products> getProducts() {
            return products;
        }
        public static synchronized ProductHolder getInstance(){
            if(instance== null) instance = new ProductHolder();
            return instance;
        }

        public void sortBySpecies(){
            products.sort(Comparator.comparing(Products::getSpecies));
        }
        public void sortByGroupAlter(){
            products.sort(Comparator.comparing(Products::getAlterGroup));
        }
        public void sortByName(){
            products.sort(Comparator.comparing(Products::getName));
        }

        //    endregion

    }
