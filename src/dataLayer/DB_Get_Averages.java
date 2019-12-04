package dataLayer;

import DAO.Entity.Averages;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DB_Get_Averages {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public Averages getClassAverages(int sId, int cId) {



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

            /*sql = "SELECT grade, "
                + "FROM gradedSubmission g "
                + "INNER JOIN assignment a ON a.idassignment=g.aId "
                + " WHERE a.classid = " + cId;*/

            sql = "SELECT grade, a.aName, a.tPoints "
                    + "FROM gradedSubmission g "
                    + "INNER JOIN assignment a ON a.idassignment=g.aId "
                    + " WHERE a.classid = 1";

            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //TODO: Count the return set
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

        return setAverages(totalRows, gradeList);

    }

    public Averages setAverages (int totalRows,  List<Integer> gradeList) {

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
