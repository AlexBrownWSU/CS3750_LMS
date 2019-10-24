package dataLayer;

import DAO.ClassDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Classes_All {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public List<ClassDAO> getClasses() {

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

            sql = "SELECT class.id, class.instructorId, class.class_name, class.meeting_Time, class.enrollments, user.lName, user.fName " +
                            "FROM class " +
                            "INNER JOIN user ON user.id=class.instructorId " +
                            "ORDER BY user.lName ";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                ClassDAO classDAO = new ClassDAO();

                classDAO.setId(rs.getInt("class.id"));
                classDAO.setcName(rs.getString("class.class_name"));
                classDAO.setInstructorId(rs.getInt("class.instructorId"));
                classDAO.setMeetingTime(rs.getString("class.meeting_time"));
                classDAO.setiLName(rs.getString("user.lName"));
                classDAO.setiFName(rs.getString("user.fName"));
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
