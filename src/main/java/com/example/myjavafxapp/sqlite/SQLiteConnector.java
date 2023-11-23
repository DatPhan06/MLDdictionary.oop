package com.example.myjavafxapp.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnector {

    public static Connection connect() {

        String csvFile = "src/main/resources/csv/E-Edictionary.csv"; // Đường dẫn tới file CSV
        String jdbcUrl = "jdbc:sqlite:src/main/resources/engData.db"; // Đường dẫn tới cơ sở dữ liệu SQLite
        try {

            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(jdbcUrl);
            System.out.println("Kết nối database thành công.");
            return connection;


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
