package dataLayer;

import java.sql.*;

public class DB_Get_Student_Score_Assignment {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public double getStudentAssignmentScore (int sId, int cId, int aId) {

        double studentScore = 0.0;

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
                    + "INNER JOIN assignment a on a.idassignment=g.aId "
                    + "WHERE a.classid = " + cId + " "
                    + "AND a.idassignment = " + aId + " "
                    + "AND g.sId = " + sId;
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                //TODO: Count the return set
                studentScore = rs.getInt("grade");
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

        return studentScore;

    }
}
