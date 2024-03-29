package dataLayer;

import DAO.ClassDAO;

import java.sql.*;

public class DB_Get_Class_By_Id {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public ClassDAO getClassById(String instructorId) {

        ClassDAO classDAO = new ClassDAO();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT * FROM class WHERE id = " + Integer.parseInt(instructorId);
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                classDAO.setId(rs.getInt("id"));
                classDAO.setcName(rs.getString("class_name"));
                classDAO.setInstructorId(rs.getInt("instructorId"));
                classDAO.setMeetingTime(rs.getString("meeting_time"));

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

        return classDAO;
    }
}
