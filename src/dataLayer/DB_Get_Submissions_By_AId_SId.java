package dataLayer;

import DAO.Entity.AssignmentSubmission;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Submissions_By_AId_SId {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public AssignmentSubmission getSubmission (String aId, String sId) {

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT answer " +
                    "FROM submission " +
                    "WHERE aId = " + Integer.parseInt(aId) + " " +
                    "AND " + Integer.parseInt(sId);
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                //assignmentSubmission.setFile(rs.getBlob("file").getBinaryStream());
                //assignmentSubmission.setFileName("filename");
                assignmentSubmission.setAnswers(rs.getString("answer"));

            }

            rs.close();
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

        return assignmentSubmission;
    }

}
