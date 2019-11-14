package dataLayer;
import DAO.Entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DB_Get_Questions_By_CId {

    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public List<Question> getQuestionByCId(String cId){
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

            sql = "SELECT question.* FROM question " +
                    "JOIN assignment " +
                    "ON question.aId = assignment.idassignment " +
                    "WHERE assignment.classId = " + Integer.parseInt(cId);

            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                Question question = new Question();

                question.setqId(rs.getInt("qId"));
                question.setaId(rs.getInt("aId"));
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


