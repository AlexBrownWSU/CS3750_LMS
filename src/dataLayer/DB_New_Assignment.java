package dataLayer;

import DAO.Entity.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_New_Assignment {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public void writeNewAssignment(Assignment assignment) {

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "INSERT INTO Assignment "
                    + "(aName, tPoints, openDate, dueDate, classId)"
                    + "VALUES (\""
                    + assignment.getaName()
                    + "\", \"" + assignment.gettPoints()
                    + "\", \"" + assignment.getStartDate()
                    + "\", \"" + assignment.getDueDate()
                    + "\", \"" + assignment.getcId() + "\")";
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

        System.out.println("Closing DB COnnection");

    }

}
