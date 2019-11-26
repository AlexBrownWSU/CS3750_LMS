package dataLayer;

import DAO.Entity.AssignmentSubmission;
import DAO.Entity.Question;
import DAO.UserDAO;
import appLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Submissions_By_AId {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public List<AssignmentSubmission> getSubmissionsByAId (String aId) {

        List<AssignmentSubmission> assignmentSubmissions = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT submission.submissionId, " +
                    "submission.aId, " +
                    "submission.answer, " +
                    "submission.sId, " +
                    "submission.filename, " +
                    "submission.file, " +
                    "submission.submissionDate, " +
                    "submission.status, " +
                    "submission.answer, " +
                    "user.lName, " +
                    "user.fName " +
                    "FROM submission " +
                    "INNER JOIN user ON user.id=submission.sId " +
                    "WHERE submission.aId = " + Integer.parseInt(aId) + " " +
                    "ORDER BY submission.submissionDate";

            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                AssignmentSubmission assignmentSubmission = new AssignmentSubmission();

                assignmentSubmission.setSubmissionId(rs.getInt("submission.submissionId"));
                assignmentSubmission.setsId(rs.getInt("submission.sId"));
                assignmentSubmission.setaId(rs.getInt("submission.aId"));
                assignmentSubmission.setSubmissionDate(rs.getString("submission.submissionDate"));
                assignmentSubmission.setFile(rs.getBlob("submission.file").getBinaryStream());
                assignmentSubmission.setFileName("submission.filename");
                assignmentSubmission.setAnswers(rs.getString("submission.answer"));
                assignmentSubmission.setfName(rs.getString("user.lName"));
                assignmentSubmission.setlName(rs.getString("user.fName"));


                if (rs.getInt("submission.status") == 0) {
                    assignmentSubmission.setStatus(false);
                } else {
                    assignmentSubmission.setStatus(true);
                }

                assignmentSubmissions.add(assignmentSubmission);

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

        return assignmentSubmissions;
    }
}
