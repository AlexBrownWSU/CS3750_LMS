package dataLayer;

import DAO.ClassDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Enrollments_By_Student_Id {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public List<ClassDAO> getEnrollmentsByStudentId(int studentId) {

        List<ClassDAO> classes = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT class.id, class.instructorId, class.class_name, class.meeting_time, class.enrollments FROM class "
                    + "INNER JOIN  enrollment ON enrollment.class_id=class.id "
                    + "WHERE enrollment.student_id = " + studentId;

            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                ClassDAO myClass = new ClassDAO();

                myClass.setEnrollments(rs.getInt("class.enrollments"));
                myClass.setCrn(rs.getString("class.id"));
                myClass.setMeetingTime(rs.getString("class.meeting_Time"));
                myClass.setInstructorId(rs.getInt("class.instructorId"));
                myClass.setcName(rs.getString("class.class_name"));

                classes.add(myClass);

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

        return classes;
    }

}
