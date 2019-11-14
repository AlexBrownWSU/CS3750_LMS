package dataLayer;

import DAO.Entity.Assignment;
import DAO.Entity.SubmitAssignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Submitted_Assignments {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public List<SubmitAssignment> getSubAssignByUserAndClassId(int classId, int userId){
        List<SubmitAssignment> SubmittedAssignmentsList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT submitted.*, assignment.*  FROM submitted " +
                    " JOIN assignment ON submitted.aId = assignment.idAssignment " +
                    " WHERE submitted.userId = " + userId +
                    " AND assignment.classId = " + classId +
                    " ORDER BY submitted.aId";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                SubmitAssignment assignment = new SubmitAssignment();

                assignment.setAId(rs.getInt("aId"));
                assignment.setUId(rs.getInt("userId"));
                assignment.setaName(rs.getString("aName"));
                assignment.settPoints(rs.getInt("tPoints"));
                assignment.setGrade(rs.getInt("grade"));
                assignment.setStartDate(rs.getString("openDate"));
                assignment.setDueDate(rs.getString("dueDate"));
                assignment.setSubmissionDate(rs.getString("submitted_date"));

                SubmittedAssignmentsList.add(assignment);

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

        return SubmittedAssignmentsList;
    }
}
