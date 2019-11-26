package dataLayer;

import DAO.Entity.FileSubmission;

import java.io.InputStream;
import java.sql.*;


public class DB_Get_File {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public FileSubmission getSubmissionFile (String aId, String sId) {

        FileSubmission fileSubmission = new FileSubmission();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT filename, file " +
                    "FROM submission " +
                    "WHERE aId = " + Integer.parseInt(aId) + " " +
                    "AND sId = " + Integer.parseInt(sId);

            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                // gets file name and file blob data
                fileSubmission.setFilename(rs.getString("filename"));
                fileSubmission.setFile(rs.getBlob("file"));
                fileSubmission.setFileInput(rs.getBlob("file").getBinaryStream());
                fileSubmission.setFileLength(rs.getBlob("file").getBinaryStream().available());

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

        return fileSubmission;
    }
}
