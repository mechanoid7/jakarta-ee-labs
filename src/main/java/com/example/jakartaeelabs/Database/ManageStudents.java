package com.example.jakartaeelabs.Database;

import java.sql.*;

public class ManageStudents {

    private final Connection connection = Connect.connect();

    public void insert(int groupid, String firstName, String lastName) {
        String sql = "INSERT INTO students(groupid,firstName,lastName) VALUES(?,?,?)";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, groupid);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, int groupid, String firstName, String lastName) {
        String sql = "UPDATE students SET groupid = ? , "
                + "firstName = ?, "
                + "lastName = ? "
                + "WHERE id = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, groupid);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

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
        String sql = "SELECT groupid, id, firstName, lastName FROM students";

        try (Statement stmt = this.connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("groupid") + "\t" +
                        rs.getInt("id") + "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getStudent(int id) {
        String sql = "SELECT groupid, id, firstName, lastName "
                + "FROM students WHERE id = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, id);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("groupid") + "\t" +
                        rs.getInt("id") + "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        ManageStudents app = new ManageStudents();
        // insert three new rows
//        app.insert(1,"Raw", "Raw");
//        app.insert(1,"Semifinis", "Apple");
//        app.insert(1,"Finished", "Grey");
//        app.update(1,2, "Kolya", "Born");
//        app.delete(3);
//        app.selectAll();
        app.getStudent(1);
    }

}