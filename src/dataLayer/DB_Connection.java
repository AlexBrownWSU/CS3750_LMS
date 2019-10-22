package dataLayer;

import java.sql.*;

public class DB_Connection {


    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlserver://cs3750-ffdp-lms.database.windows.net:1433";

    // Database credentials
    static final String USER = "FFDP-Admin71@cs3750-ffdp-lms";
    static final String PASS = "FFDeathPunch71";

    public static void main(String[] args) {

            boolean isValidUser = false;

            Connection conn = null;
            //Statement stmt = null;
            String sql = "";

            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected!!!!!!!!!!!!");
                conn.close();

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Closing DB COnnection");

    }
}