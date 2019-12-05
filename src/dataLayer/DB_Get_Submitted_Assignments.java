package dataLayer;


import DAO.Entity.AssignmentSubmission;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Submitted_Assignments {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public List<AssignmentSubmission> getSubAssignByUserAndClassId(int classId, int userId){
        List<AssignmentSubmission> SubmittedAssignmentsList = new ArrayList<>();

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

            sql = "SELECT submission.*, assignment.* FROM submission " +
                    " JOIN assignment ON submission.aId = assignment.idAssignment " +
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

                assignment.setSubmissionDate(rs.getString("submissionDate"));

                SubmittedAssignmentsList.add(assignment);

            }
            sql2 = "SELECT grade " +
                    "from gradedsubmission " +
                    "join assignment on gradedsubmission.aId = assignment.idassignment " +
                    "where assignment.classId = " + classId +
                    " And gradedsubmission.sId = " + userId;
            System.out.println("sql2");

            rs = stmt.executeQuery(sql2);

          for(int i = 0; i < SubmittedAssignmentsList.size(); i++) {
              String grade = "";
                if(rs.next()){
                    grade = "" + rs.getInt("grade");
                   SubmittedAssignmentsList.get(i).setGrade(grade);
                }
                else{SubmittedAssignmentsList.get(i).setGrade("NG");}

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
