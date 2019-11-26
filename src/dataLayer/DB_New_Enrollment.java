package dataLayer;

import DAO.Entity.StudentEnrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_New_Enrollment {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public void writeNewEnrollment(StudentEnrollment studentEnrollment) {

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        String sql2 = "";


        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();


            sql = "INSERT INTO enrollment "
                    + "(student_id, class_id) "
                    + "VALUES ( " + studentEnrollment.getsId() + ", " + studentEnrollment.getcId() + " )";
            System.out.println("sql");

            stmt.executeUpdate(sql);

            sql2 = "UPDATE class SET enrollments = enrollments + 1 "
                    + "WHERE id = " + studentEnrollment.getcId();

            stmt.executeUpdate(sql2);

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
