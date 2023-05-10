package com.example.jakartaeelabs.Database;

import com.example.jakartaeelabs.Models.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageGroups {

    private final static String DB_FIELD_ID = "id";
    private final static String DB_FIELD_NAME = "name";

    public static void insert(String name) {
        String sql = "INSERT INTO groups(name) VALUES(?)";

        try (Connection connection = Connect.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(int id, String name) {
        String sql = "UPDATE groups SET name = ? "
                + "WHERE id = ?";

        try (Connection connection = Connect.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM groups WHERE id = ?";

        try (Connection connection = Connect.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Group> getAllGroups() {
        String sql = "SELECT id, name FROM groups";
        List<Group> groups = new ArrayList<>();

        try (Connection connection = Connect.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // loop through the result set
            while (rs.next()) {
                groups.add(new Group(rs.getInt(DB_FIELD_ID), rs.getString(DB_FIELD_NAME)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groups;
    }

    public static Group getGroupById(int id) {
        String sql = "SELECT id, name "
                + "FROM groups WHERE id = ?";

        Group group = null;

        try (Connection connection = Connect.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, id);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                group = new Group(rs.getInt(DB_FIELD_ID), rs.getString(DB_FIELD_NAME));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return group;
    }

    public static void main(String[] args) {
//        ManageGroups app = new ManageGroups();
        // insert three new rows
//        app.insert("IO-21mn");
//        app.insert("IO-21mp");
//        app.insert("IV-81");
//        app.update(1, "IV-33");
//        app.delete(6);
//        app.selectAll();
        System.out.println(ManageGroups.getGroupById(2).getName());
        List<Group> groups = ManageGroups.getAllGroups();
        for (int i = 0; i < groups.size(); i++) {
            System.out.println(">>> " + groups.get(i).getName());
        }
    }
}