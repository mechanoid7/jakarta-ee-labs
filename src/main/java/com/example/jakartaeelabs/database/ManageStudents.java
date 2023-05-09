import java.sql.*;

public class ManageStudents {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src\\main\\java\\com\\example\\jakartaeelabs\\database\\new.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(int groupid, String firstName, String lastName) {
        String sql = "INSERT INTO students(groupid,firstName,lastName) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
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

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAll(){
        String sql = "SELECT groupid, id, firstName, lastName FROM students";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("groupid") +  "\t" +
                        rs.getInt("id") +  "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getStudent(int id){
        String sql = "SELECT groupid, id, firstName, lastName "
                + "FROM students WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,id);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("groupid") +  "\t" +
                        rs.getInt("id") + "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
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