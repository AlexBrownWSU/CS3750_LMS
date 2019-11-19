package dataLayer;

import DAO.Entity.AssignmentSubmission;

import java.sql.*;

public class DB_Submit_Assignment {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public boolean submitAssignment(AssignmentSubmission submission) {

        boolean submitSuccessful = false;

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "INSERT INTO submission "
                    + "(sId, filename, file)"
                    + "VALUES (\"" + submission.getsId() + "\", \"" + submission.getFileName() + "\", \"" + submission.getFile() + "\")";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                submitSuccessful = true;
            }

            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        System.out.println("Closing DB Connection");

        return submitSuccessful;

    }



}
