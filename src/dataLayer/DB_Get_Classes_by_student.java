package dataLayer;

import DAO.ClassDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Classes_by_student {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public List<ClassDAO> getClassesByStudent(String studentId) {

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

            sql =   " SELECT class.*, user.lName, user.fName " +
                    " FROM class " +
                    " JOIN enrollment ON class.id=enrollment.class_id " +
                    "JOIN user ON enrollment.student_id = user.id" +
                    " WHERE enrollment.student_id =" + studentId +
                    " ORDER BY class.id";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                ClassDAO classDAO = new ClassDAO();

                classDAO.setId(rs.getInt("class.id"));
                classDAO.setcName(rs.getString("class.class_name"));
                classDAO.setInstructorId(rs.getInt("class.instructorId"));
                classDAO.setMeetingTime(rs.getString("class.meeting_time"));
                classDAO.setEnrollments(rs.getInt("class.enrollments"));

                classes.add(classDAO);

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
