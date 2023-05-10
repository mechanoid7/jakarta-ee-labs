package com.example.jakartaeelabs.Database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connect {

    static String projectPath = System.getenv("PROJECT_PATH");
    public static final String DB_PATH = "jdbc:sqlite:" + projectPath + "\\src\\main\\resources\\main.db";

    public static Connection connect() {
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(DB_PATH);
            System.out.println("Connected to database: " + DB_PATH);
        } catch (Exception e) {
            System.out.println("Can't connect to database: " + DB_PATH);
            System.out.println(e.getMessage());
        }
        return connect;
    }
}
