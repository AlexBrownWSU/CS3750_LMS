package dataLayer;

import DAO.ClassDAO;
import DAO.Entity.StudentEnrollment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Students_By_Class_Id {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public List<StudentEnrollment> getStudentClassById(int classId) {

        List<StudentEnrollment> enrollments = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT user.lName, user.fName, user.id, enrollment.class_id  " +
                    "FROM enrollment " +
                    "INNER JOIN  user ON user.id=enrollment.student_id " +
                    "WHERE enrollment.class_id = " + classId + " "+
                    "ORDER BY user.lName";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            //SELECT user.lName, user.fName, user.id, enrollment.class_id
            //FROM enrollment
            //INNER JOIN user ON user.id=enrollment.student_id
            //WHERE enrollment.class_id = 1
            //ORDER BY user.lName


            while (rs.next()) {

                StudentEnrollment studentEnrollment = new StudentEnrollment();

                studentEnrollment.setsId(rs.getInt("user.id"));
                studentEnrollment.setcId(rs.getInt("enrollment.class_id"));
                studentEnrollment.setsFName(rs.getString("user.fName"));
                studentEnrollment.setsLName(rs.getString("user.lName"));

                enrollments.add(studentEnrollment);

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

        return enrollments;
    }
}
