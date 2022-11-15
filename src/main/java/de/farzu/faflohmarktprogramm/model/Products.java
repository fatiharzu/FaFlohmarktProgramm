package de.farzu.faflohmarktprogramm.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



    public class Products {
        //    region Konstanten
        public static final String STD_STRING_VALUE = "noValueSetYet";
        public static final int STD_INT_VALUE = -1;
        //    endregion


        //    region Attribute
        private int id;
        private StringProperty species;
        private IntegerProperty alterGroup;
        private StringProperty name;
        private StringProperty description;
        //    endregion


        //    regionKonstruktor

        public Products() {
            species = new SimpleStringProperty(STD_STRING_VALUE);
            alterGroup = new SimpleIntegerProperty(STD_INT_VALUE);
            name = new SimpleStringProperty(STD_STRING_VALUE);
            description = new SimpleStringProperty(STD_STRING_VALUE);
        }

        public Products(String species, int alterGroup, String name, String description) {
            this.species = new SimpleStringProperty(species);
            this.alterGroup = new SimpleIntegerProperty(alterGroup);
            this.name = new SimpleStringProperty(name);
            this.description = new SimpleStringProperty(description);
        }
        //    endregion


        //    regionMethoden
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSpecies() {
            return species.get();
        }

        public StringProperty speciesProperty() {
            return species;
        }

        public void setSpecies(String species) {
            this.species.set(species);
        }

        public int getAlterGroup() {
            return alterGroup.get();
        }

        public IntegerProperty alterGroupProperty() {
            return alterGroup;
        }

        public void setAlterGroup(int alterGroup) {
            this.alterGroup.set(alterGroup);
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getDescription() {
            return description.get();
        }

        public StringProperty descriptionProperty() {
            return description;
        }

        public void setDescription(String description) {
            this.description.set(description);
        }

        @Override
        public String toString() {
            return "Products{" +
                    "species=" + species +
                    ", alterGroup=" + alterGroup +
                    ", name=" + name +
                    ", description=" + description +
                    '}';
        }
        //    endregion
    }