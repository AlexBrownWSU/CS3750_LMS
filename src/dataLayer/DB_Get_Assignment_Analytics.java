package dataLayer;
import DAO.Entity.*;

import java.sql.*;

public class DB_Get_Assignment_Analytics {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public Averages getAnalytics(String aId, String cId, String sId){

        Averages assignmentAnalyntics = new Averages();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        String sql2 = "";
        String sql3 = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "select max(grade) as max, min(grade) as min, avg(grade) as avg  from gradedsubmission" +
                    " Join assignment on gradedsubmission.aId = assignment.idassignment" +
                    " where aId =" +  aId + " and classId = "+ cId;
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                assignmentAnalyntics.setHigh(rs.getInt("max"));
                assignmentAnalyntics.setLow(rs.getInt("min"));
                assignmentAnalyntics.setAverage(rs.getDouble("avg"));
            }

//            sql2 = "Select avg(gs.grade) as median_val" +
//                    " from (" +
//                    "SELECT gs.grade, @rownum:=@rownum+1 as `row_number`, @total_rows:=@rownum" +
//                    " from gradedsubmission gs" +
//                    " Join assignment a on gs.aId = a.idassignment" +
//                    ", (SELECT @rownum:=0) r" +
//                    " where gs.aId =" +  aId + " and a.classId = "+ cId +
//                    ") as gs" +
//                    " WHERE gs.row_number IN ( FLOOR((@total_rows+1)/2), FLOOR((@total_rows+2)/2) ) ";
//            System.out.println("sql2");
//
//             rs = stmt.executeQuery(sql2);
//
//            if (rs.next()) {
//                assignmentAnalyntics.setMedian(rs.getDouble("median_val"));
//            }

            sql3 = "select grade from gradedsubmission" +
                    " where aId = " +  aId + " and sId = " +  sId ;
            System.out.println("sql3");

            rs = stmt.executeQuery(sql3);
            if (rs.next()) {
                assignmentAnalyntics.setStudentScore(rs.getDouble("grade"));
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

        return assignmentAnalyntics;
    }
}
