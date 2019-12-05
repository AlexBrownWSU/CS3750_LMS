package dataLayer;

import DAO.ClassDAO;
import DAO.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Class_By_Instructor {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public List<ClassDAO> getClasses(String instructorId) {

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

            sql = "SELECT * FROM class WHERE instructorId = " + Integer.parseInt(instructorId);
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                ClassDAO classDAO = new ClassDAO();

                classDAO.setId(rs.getInt("id"));
                classDAO.setcName(rs.getString("class_name"));
                classDAO.setInstructorId(rs.getInt("instructorId"));
                classDAO.setMeetingTime(rs.getString("meeting_time"));

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
