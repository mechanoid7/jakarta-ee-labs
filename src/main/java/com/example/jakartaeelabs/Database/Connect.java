package com.example.jakartaeelabs.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

    static String projectPath = System.getenv("PROJECT_PATH");
    public static final String DB_PATH = "jdbc:sqlite:" + projectPath + "\\src\\main\\resources\\main.db";


//    String path = getServletContext().getRealPath("/");
//    String dbPath = path + "src/main/java/com/example/jakartaeelabs/Database/main.db";
//    String connectionString = "jdbc:sqlite:" + dbPath;

    public static Connection connect() {
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println(">>>>>>> " + projectPath);
            connect = DriverManager.getConnection(DB_PATH);
            System.out.println("Connected to database: " + DB_PATH);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connect;
    }
}
