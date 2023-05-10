package com.example.jakartaeelabs.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private static final Connection connection = Connect.connect();

    public static void createNewTables() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS students (\n"
                + "	groupId integer NOT NULL,\n"
                + "	id integer PRIMARY KEY,\n"
                + "	firstName text NOT NULL,\n"
                + "	lastName text NOT NULL\n"
                + ");"
                + "CREATE TABLE IF NOT EXISTS groups (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL\n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTables();
    }
}