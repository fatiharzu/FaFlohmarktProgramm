package de.farzu.faflohmarktprogramm.logic.db;

import java.sql.Connection;
import java.util.List;

        /**
         * Interface, welches Methoden für CRUD-Operationen vordefiniert.
         * DAO - Data Access Object
         */
    public interface Dao <T>{
        /**
         * Methode zum Einfügen eines Objektes in die Datenbank
         *
         * @param dbConnection : {@link Connection} : Verbindung zur Datenbank
         * @param object : T: Zu erstellendes Objekt einer bestimmten Klasse
         */

        void create(Connection dbConnection, T object);
        /**
         * Methode zum Auslesen alles Objekte aus der Datenbank
         * @param dbConnection : {@link Connection} : Verbindung zur Datenbank
         * @return {@link List<T>} : Liste von Objekten aus der Datenbank
         */

        List<T> readAll(Connection dbConnection);

         /**
         * Methode zum Auslesen eines Objektes aus der Datenbank anhand der ID.
         *
         * @param dbConnection : {@link Connection} : Verbindung zur Datenbank
         * @param id : int: Id des auszulesenden Objektes
         * @return
         * */
        T read(Connection dbConnection, int id);

         /**
         * Methode zum Aktualisieren eines bestimmten Objektes in der Datenbank
         *
         * @param dbConnection : {@link Connection} : Verbindung zur Datenbank
         * @param object : T : Zu aktualisierendes Objekt einer bestimmten Klasse
         */
        void update(Connection dbConnection, T object);
          /**
          * Methode zum Löschen eines bestimmten Objektes aus der Datenbank
          *
          * @param dbConnection : {@link Connection} : Verbindung zur Datenbank
          * @param object : T: Zu löschendes Objekt einer bestimmten Klasse
          */
        void delete(Connection dbConnection, T object);
    }
