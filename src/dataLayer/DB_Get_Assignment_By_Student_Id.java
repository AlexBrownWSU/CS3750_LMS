package dataLayer;

import DAO.Entity.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Assignment_By_Student_Id {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public List<Assignment> getAssignmentByStudentId ( int studentId) {

        int size = 0;

        List<Assignment> assignments = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT Assignment.aName, Assignment.tPoints, Assignment.openDate, Assignment.dueDate, Assignment.classId, Assignment.idassignment "
                + "FROM Assignment "
                + "INNER JOIN Enrollment ON Enrollment.class_Id=Assignment.classId "
                + "WHERE Enrollment.student_id = " + studentId +
                    " And Assignment.idassignment not in " +
                    " ( select aId " +
                    " from Submission" +
                    " where sId = "+ studentId +
                    " ) "
                + "ORDER BY Assignment.dueDate";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                Assignment assignment = new Assignment();

                assignment.setcId(rs.getInt("classId"));
                assignment.setaId(rs.getInt("idassignment"));
                assignment.setaName(rs.getString("aName"));
                assignment.setcId(rs.getInt("tPoints"));
                assignment.setStartDate(rs.getString("openDate"));
                assignment.setDueDate(rs.getString("dueDate"));

                assignments.add(assignment);

                size++;

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

        return assignments;

    }
}
