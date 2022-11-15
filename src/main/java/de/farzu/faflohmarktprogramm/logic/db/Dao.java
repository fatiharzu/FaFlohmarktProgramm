package de.farzu.faflohmarktprogramm.logic.db;

import java.sql.Connection;
import java.util.List;

    public interface Dao <T>{

        void create(Connection dbConnection, T object);

        List<T> readAll(Connection dbConnection);


        T read(Connection dbConnection, int id);


        void update(Connection dbConnection, T object);

        void delete(Connection dbConnection, T object);
    }
