package dataLayer;

import DAO.Entity.Assignment;
import DAO.Entity.Averages;
import appLayer.AssignmentAverages;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DB_Get_Assignment_Averages {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public AssignmentAverages getAssignmentAverages(int sId, int cId, int aId) {

        Averages averages = new Averages();

        AssignmentAverages assignmentAverage = new AssignmentAverages();
        assignmentAverage.setcId(cId);
        assignmentAverage.setaId(aId);

        List<Integer> gradeList = new ArrayList<>();
        int totalRows = 0;

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statement...");
            stmt = conn.createStatement();

            sql = "SELECT grade, idassignment, classid "
                    + "FROM gradedSubmission g "
                    + "INNER JOIN assignment a on a.idassignment=g.aId "
                    + "WHERE a.classid = " + cId + " "
                    + "AND a.idassignment = " + aId;
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                averages.setStudentScore(0.0);
                averages.settPoints(0);
                averages.setAverage(0.0);
                averages.setHigh(0);
                averages.setHigh(0);

                assignmentAverage.setResults(false);
                assignmentAverage.setaId(0);
                assignmentAverage.setcId(0);
                assignmentAverage.setAverages(averages);

                return assignmentAverage;
            }

            assignmentAverage.setResults(true);

            while (rs.next()) {

                int grade = rs.getInt("grade");

                //Add grade to list
                gradeList.add(grade);

                //Increment rows
                totalRows++;

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

        assignmentAverage.setAverages(setAverages(totalRows, gradeList));
        return assignmentAverage;

    }

    public Averages setAverages (int totalRows, List<Integer> gradeList) {

        Averages averages = new Averages();

        averages.setHigh(Collections.max(gradeList));
        averages.setLow(Collections.min(gradeList));

        double classAverage = 0;

        for (int grade: gradeList) {
            classAverage += grade;
        }

        averages.settPoints((int)classAverage);

        averages.setAverage(classAverage / totalRows);

        return averages;
    }
}
