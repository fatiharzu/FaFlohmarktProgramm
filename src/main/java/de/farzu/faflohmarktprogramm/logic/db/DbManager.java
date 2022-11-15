package de.farzu.faflohmarktprogramm.logic.db;

import de.farzu.faflohmarktprogramm.model.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

    public class DbManager {
        //    region Konstanten

        private static final String SERVER_IP = "localhost";

        private static final String DB_NAME = "products";

        private static final String DB_USER_NAME = "root";
        private static final String DB_USER_PASSWORD = "";

            private static final String CONNECTION_URL = "jdbc:mariadb://" +
                    SERVER_IP + "/" + DB_NAME;
        //    endregion

        //    region Attribute
            private static DbManager instance;
            private final DaoProducts daoProducts;


        //    endregion

        //    regionKonstruktor
            public DbManager() {
                daoProducts = new DaoProducts();
            }
        //    endregion

        //    regionMethoden
        public static synchronized DbManager getInstance() {
            if (instance == null) instance = new DbManager();
            return instance;
        }


        private Connection getConnection() {
            Connection dbConnection = null;

            try {
                dbConnection = DriverManager.getConnection(CONNECTION_URL, DB_USER_NAME, DB_USER_PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dbConnection;
        }

        public void insertDataRecord(Object object){
            if (object instanceof Products product) daoProducts.create(getConnection(), product);

        }

        public List<Products> realAllDataRecords() {

            return daoProducts.readAll(getConnection());
        }

        public void updateDataRecord(Object object){
            if (object instanceof Products product) daoProducts.update(getConnection(), product);
        }
        public void deleteDataRecord(Object object){
            if(object instanceof Products product) daoProducts.delete(getConnection(), product);
        }



        //    endregion

    }
