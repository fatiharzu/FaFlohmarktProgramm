package de.farzu.faflohmarktprogramm.logic.db;

import de.farzu.faflohmarktprogramm.model.Products;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class DaoProducts implements Dao<Products> {
    //    region Konstanten
        public static final String TBL_NAME = "products";

            public static final String COL_ID = "pk_id";
            public static final String COL_SPECIES = "species";
            public static final String COL_NAME = "name";
            public static final String COL_ALTER_GROUP = "alterGroup";
            public static final String COL_DESCRIPTION = "description";
            public static final String STATEMENT_INSERT_PRODUCTS = "INSERT INTO products (species, alterGroup, name, description) VALUES (?,?,?,?)";
            public static final String STATEMENT_SELECT_ALL_PRODUCTS = "SELECT * FROM products";
            public static final String STATEMENT_DELETE_PRODUCT = "DELETE FROM products WHERE pk_id = ?";
            public static final String STATEMENT_UPDATE_PRODUCT = "UPDATE products SET species = ?, alterGroup = ?, name = ?, description = ? WHERE pk_id = ?";
        //    endregion


        //    region Attribute
        //    endregion


        //    regionKonstruktor
        //    endregion


        //    regionMethoden
        @Override
        public void create(Connection dbConnection, Products products){
            PreparedStatement statement = null;

            try {
                statement = dbConnection.prepareStatement(STATEMENT_INSERT_PRODUCTS, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, products.getSpecies());
                statement.setInt(2, products.getAlterGroup());
                statement.setString(3, products.getName());
                statement.setString(4,products.getDescription());
                statement.executeUpdate();

                ResultSet resultSet = statement.getGeneratedKeys();
                int insertId;

                if(resultSet.next()){
                    insertId = resultSet.getInt("insert_id");
                }
            }catch (Exception e){
            e.printStackTrace();
            }finally {
                try {
                    if (statement != null) statement.close();
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public List<Products> readAll(Connection dbConnection) {
            List<Products> products = new ArrayList<>();

            Statement statement = null;

            try {

                statement = dbConnection.createStatement();
                ResultSet resultSet = statement.executeQuery(STATEMENT_SELECT_ALL_PRODUCTS);

                while (resultSet.next()) {
                    Products product = new Products(
                            resultSet.getString(COL_SPECIES),
                            resultSet.getInt(COL_ALTER_GROUP),
                            resultSet.getString(COL_NAME),
                            resultSet.getString(COL_DESCRIPTION)
                    );
                    product.setId(resultSet.getInt(COL_ID));

                    products.add(product);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return products;
        }

        @Override
        public Products read(Connection dbConnection, int id) {
            return null;
        }


        @Override
        public void update(Connection dbConnection, Products product) {
            PreparedStatement statement = null;

            try {

                statement = dbConnection.prepareStatement(STATEMENT_UPDATE_PRODUCT);
                statement.setString(1, product.getSpecies());
                statement.setInt(2, product.getAlterGroup());
                statement.setString(3, product.getName());
                statement.setString(4, product.getDescription());
                statement.setInt(5, product.getId());

                statement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void delete(Connection dbConnection, Products product) {
            PreparedStatement statement = null;

            try {

                statement = dbConnection.prepareStatement(STATEMENT_DELETE_PRODUCT);
                statement.setInt(1, product.getId());

                statement.execute();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //    endregion

    }
