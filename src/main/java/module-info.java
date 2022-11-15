module de.farzu.faflohmarktprogramm {
    requires javafx.controls;
    requires org.mariadb.jdbc;
    requires javafx.fxml;
    requires java.sql;


    opens de.farzu.faflohmarktprogramm to javafx.fxml;
    exports de.farzu.faflohmarktprogramm;
    exports de.farzu.faflohmarktprogramm.gui;
    opens de.farzu.faflohmarktprogramm.gui to javafx.fxml;
}