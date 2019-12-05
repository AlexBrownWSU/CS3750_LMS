package dataLayer;

import java.sql.*;

public class DB_User {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";


//        // JDBC driver name and database URL
//        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        static final String DB_URL = "jdbc:mysql://localhost/test3750db";
//
//        // Database credentials
//        static final String USER = "root";
//        static final String PASS = "FastStaff2020";

        public boolean isValidUserLogin(String username, String password) {

            boolean isValidUser = false;

            Connection conn = null;
            Statement stmt = null;
            String sql = "";

            try {
                Class.forName(JDBC_DRIVER);

                System.out.println("Creating statement...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                System.out.println("Creating Statment...");
                stmt = conn.createStatement();

                sql = "SELECT * FROM User WHERE user_name = \"" + username + "\" AND password = \"" + password + "\"";
                System.out.println("sql");

                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    isValidUser = true;
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

            System.out.println("Closing DB COnnection");

            //return isValidUser;
            return isValidUser;
        }
}
