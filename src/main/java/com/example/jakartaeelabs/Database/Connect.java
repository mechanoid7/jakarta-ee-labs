package com.example.jakartaeelabs.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
    public static final String DB_PATH = "jdbc:sqlite:src\\main\\java\\com\\example\\jakartaeelabs\\database\\main.db";

    public static Connection connect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(DB_PATH);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }
}
