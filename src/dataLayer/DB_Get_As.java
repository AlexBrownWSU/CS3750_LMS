package dataLayer;

import DAO.Entity.AnswerSubmission;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB_Get_As {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public List<String> getAs (String aId, String sId) {

        List<String> answers = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT answer " +
                    "FROM submission " +
                    "WHERE aId = " + Integer.parseInt(aId) + " " +
                    "AND " + Integer.parseInt(sId);
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                    AnswerSubmission answerSubmission = new AnswerSubmission();

                    String [] answerArray = rs.getString("answer").split("\\s*,\\s*");
                    answers = Arrays.asList(answerArray);

                    //assignmentSubmission.setFile(rs.getBlob("file").getBinaryStream());
                    //assignmentSubmission.setFileName("filename");
                    //assignmentSubmission.setAnswers(rs.getString("answer"));

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

            return answers;
        }


    }
