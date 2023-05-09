package com.example.jakartaeelabs.Database;

import com.example.jakartaeelabs.Models.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageGroups {

    private final Connection connection = Connect.connect();
    private final static String DB_FIELD_ID = "id";
    private final static String DB_FIELD_NAME = "name";

    public void insert(String name) {
        String sql = "INSERT INTO groups(name) VALUES(?)";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, String name) {
        String sql = "UPDATE groups SET name = ? "
                + "WHERE id = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM groups WHERE id = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Group> getAllGroups() {
        String sql = "SELECT id, name FROM groups";
        List<Group> groups = new ArrayList<>();

        try (Statement stmt = this.connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                groups.add(new Group(rs.getInt(DB_FIELD_ID), rs.getString(DB_FIELD_NAME)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groups;
    }

    public Group getGroup(int id) {
        String sql = "SELECT id, name "
                + "FROM groups WHERE id = ?";

        Group group = null;

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {

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
        ManageGroups app = new ManageGroups();
        // insert three new rows
//        app.insert("IO-21mn");
//        app.insert("IO-21mp");
//        app.insert("IV-81");
//        app.update(1, "IV-33");
//        app.delete(6);
//        app.selectAll();
        app.getGroup(2);
    }

}