package dataLayer;

import DAO.Entity.GradedSubmission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Grade_Submission {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public void grade(GradedSubmission gradedSubmission) {

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "INSERT INTO gradedSubmission "
                    + "(aId, sId, grade)"
                    + " VALUES (\""
                    + gradedSubmission.getaId() + "\", \""
                    + gradedSubmission.getsId() + "\", \""
                    + gradedSubmission.getGrade() + "\")";

            System.out.println("sql");

            stmt.executeUpdate(sql);

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

    }

}
