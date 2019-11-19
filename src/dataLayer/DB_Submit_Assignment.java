package dataLayer;


import DAO.Entity.SubmitAssignment;
import DAO.Entity.AssignmentSubmission;

import java.io.File;
import java.io.InputStream;
import java.sql.*;

public class DB_Submit_Assignment {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";



    public boolean submitAssignment(SubmitAssignment submission) {

        InputStream submissionFile = submission.getFile();

        boolean submitSuccessful = false;

        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statement...");


            sql = "INSERT INTO submission "
                    + "(aId, answer, sId, filename, file, submissionDate, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            System.out.println("sql");

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, submission.getaId());
            stmt.setString(2, submission.getAnswers());
            stmt.setInt(3, submission.getsId());
            stmt.setString(4, submission.getFileName());

            //Add file as Blob
            if (submissionFile != null) {
                // fetches input stream of the upload file for the blob column
                stmt.setBlob(5, submissionFile);
            }

            stmt.setString(6, submission.getSubmissionDate());

            if (submission.isStatus()) {
                stmt.setInt(7, 1);
            } else {
                stmt.setInt(7, 0);
            }

            // sends the statement to the database server
            int row = stmt.executeUpdate();
            if (row > 0) {
                submitSuccessful = true;
            }

            //ResultSet rs =
            //stmt.executeUpdate(sql);

            /*if (rs.next()) {
                submitSuccessful = true;
            }*/

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
