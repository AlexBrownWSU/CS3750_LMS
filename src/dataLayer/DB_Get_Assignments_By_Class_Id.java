package dataLayer;

import DAO.Entity.Address;
import DAO.Entity.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Get_Assignments_By_Class_Id {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public List<Assignment> getAssifnmentsByClassId (int classId) {

        List<Assignment> assignmentsList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT * FROM assignment WHERE classId = " + classId;
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                Assignment assignment = new Assignment();

                assignment.setcId(rs.getInt("classId"));
                assignment.setaId(rs.getInt("idassignment"));
                assignment.setaName(rs.getString("aName"));
                assignment.setcId(rs.getInt("tPoints"));
                assignment.setStartDate(rs.getString("openDate"));
                assignment.setDueDate(rs.getString("dueDate"));

                assignmentsList.add(assignment);

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

        return assignmentsList;
    }

}
