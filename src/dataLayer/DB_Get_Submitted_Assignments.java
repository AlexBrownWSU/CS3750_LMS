package dataLayer;


import DAO.Entity.AssignmentSubmission;


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

    public List<AssignmentSubmission> getSubAssignByUserAndClassId(int classId, int userId){
        List<AssignmentSubmission> SubmittedAssignmentsList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT submission.*, assignment.*, gradedSubmission.grade FROM submission " +
                    " JOIN assignment ON submission.aId = assignment.idAssignment " +
                    " LEFT JOIN gradedSubmission ON assignment.idAssignment = gradedSubmission.aId" +
                    " WHERE submission.sId = " + userId +
                    " AND assignment.classId = " + classId +
                    " ORDER BY submission.aId";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                AssignmentSubmission assignment = new AssignmentSubmission();
                assignment.setaName(rs.getString("aName"));
                assignment.setaId(rs.getInt("aId"));
                assignment.setsId(rs.getInt("sId"));
                assignment.settPoints(rs.getInt("tPoints"));
                int i;

                String grade = "" + rs.getString("grade");
                if(!grade.equals("null") ){
                    grade = "" + rs.getInt("grade");
                    assignment.setGrade(grade);
                }
                else{assignment.setGrade("Not Graded");}
                assignment.setSubmissionDate(rs.getString("submissionDate"));

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
