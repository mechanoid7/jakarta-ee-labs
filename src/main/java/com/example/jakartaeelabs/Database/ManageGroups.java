package com.example.jakartaeelabs.Database;

import java.sql.*;

public class ManageGroups {

    private final Connection connection = Connect.connect();

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

    public void selectAll() {
        String sql = "SELECT id, name FROM groups";

        try (Statement stmt = this.connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getGroup(int id) {
        String sql = "SELECT id, name "
                + "FROM groups WHERE id = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, id);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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