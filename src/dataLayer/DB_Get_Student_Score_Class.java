package dataLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Student_Score_Class {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public int getStudentClassScore (int sId, int cId) {

        int studentClassScore = 0;
        List<Integer> gradeList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statement...");
            stmt = conn.createStatement();

            sql = "SELECT grade, idassignment "
                    + "FROM gradedSubmission g "
                    + "INNER JOIN Assignment a on a.idassignment=g.aId "
                    + "WHERE a.classid = " + cId + " "
                    + "AND g.sId = " + sId;
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //TODO: Count the return set
                int grade = rs.getInt("grade");

                //Add grade to list
                gradeList.add(grade);

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

        return addStudentScores(gradeList);

    }

    public int addStudentScores (List<Integer> grades) {
        int sum = 0;
        for (int i: grades) {
            sum += i;
        }
        return sum;
    }
}
