package dataLayer;

import DAO.Entity.AnswerSubmission;
import DAO.Entity.AssignmentSubmission;
import DAO.Entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB_Get_Qs {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public List<Question> getQs (String aId) {

        List<Question> questions = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT question, qPoints " +
                    "FROM question " +
                    "WHERE aId = " + Integer.parseInt(aId);

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                Question question = new Question();

                question.setQuestion(rs.getString("question"));
                question.setqPoints(rs.getInt("qPoints"));

                questions.add(question);

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

        return questions;
    }

}
