package dataLayer;

import DAO.UserDAO;

import java.sql.*;

public class DB_Get_User_By_ID {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public UserDAO getUserbyId(String id) {

        UserDAO userDAO = new UserDAO();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT * FROM user WHERE id = \"" + id + "\"";
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                userDAO.setId(rs.getInt("id"));
                userDAO.setlName(rs.getString("lName"));
                userDAO.setfName(rs.getString("fName"));
                userDAO.setPassword(rs.getString("password"));
                userDAO.setType(rs.getString("type"));
                userDAO.setEmail(rs.getString("user_name"));
                userDAO.setbDate(rs.getString("bDate"));
                userDAO.setBio(rs.getString("bio"));
                userDAO.setPhoneNumber(rs.getString("phoneNumber"));
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

        return userDAO;
    }

}
