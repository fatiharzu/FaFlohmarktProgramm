package de.farzu.faflohmarktprogramm.logic.db;

import de.farzu.faflohmarktprogramm.model.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
        /**
         * Baut Verbindungen zu Datenbanken auf
         * und stellt die jeweiligen Dao-Objekte Bereit um
         * auf einzelne Tabellen zuzugreifen
         */

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
            /**
             * Baut eine Verbindung zur Datenbank auf und
             * gibt diese zurück
             *
             * @return {@link Connection} : Verbindung zur Datenbank
             */

        private Connection getConnection() {
            Connection dbConnection = null;

            try {
                dbConnection = DriverManager.getConnection(CONNECTION_URL, DB_USER_NAME, DB_USER_PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dbConnection;
        }

            /**
             * Leitet das Einfügen eines Datensatzes für das übergebene Objekt ein.
             * Dafür wird geprüft, um welche Instanz es sich genau handelt.
             *
             * @param object : {@link Object} : Das einzufügende Objekt
             */

        public void insertDataRecord(Object object){
            if (object instanceof Products product) daoProducts.create(getConnection(), product);

        }

            /**
             * Liest alle Tiere aus der Datenbank aus und gibt
             * sie als Liste zurück
             *
             * @return {@link List<Products>} : Liste aller Tiere in der Datenbank
             */

        public List<Products> realAllDataRecords() {

            return daoProducts.readAll(getConnection());
        }

            /**
             * Leitet das Aktualisieren eines Datensatzes für das übergebene Objekt ein.
             * Dafür wird geprüft, um welche Instanz es sich genau handelt.
             */

        public void updateDataRecord(Object object){
            if (object instanceof Products product) daoProducts.update(getConnection(), product);
        }

            /**
             * Leitet das Löschen eines Datensatzes für das übergebene Objekt ein.
             * Dafür wird geprüft, um welche Instanz es sich genau handelt.
             */
        public void deleteDataRecord(Object object){
            if(object instanceof Products product) daoProducts.delete(getConnection(), product);
        }



        //    endregion

    }
