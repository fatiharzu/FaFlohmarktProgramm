package de.farzu.faflohmarktprogramm.test;

import de.farzu.faflohmarktprogramm.model.Products;

import java.util.ArrayList;
import java.util.List;

    public class TestData {
    //    region Konstanten
        private static final int PRODUCT_AMOUNT =20;
    //    endregion


    //    region Attribute
    //    endregion


    //    regionKonstruktor

        public TestData() {
        }

    //    endregion


    //    regionMethoden
        public static List<Products> getTestProducts() {

            List<Products> productList = new ArrayList<Products>();

            Products produktOne = new Products("Spielzeug",10,"Auto","Product1");
            productList.add(produktOne);
            Products produktTwo = new Products("Spielzeug",5,"Puppy","Product2");
            productList.add(produktTwo);
            Products produktThree = new Products("Spielzeug",8,"Lego","Product3");
            productList.add(produktThree);
            Products produktFour = new Products("Kleidung",2,"Shirt","Product4");
            productList.add(produktFour);
            Products produktFive = new Products("Kleidung",8,"Jake","Product5");
            productList.add(produktFive);
            Products produktSix = new Products("Spielzeug",13,"Lego Duplo","Product6");
            productList.add(produktSix);
            Products produktSeven = new Products("Kleidung",11,"Hose","Product7");
            productList.add(produktSeven);




            return productList;
        }
    //    endregion

    }
