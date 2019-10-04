package dataLayer;

import DAO.Entity.Address;
import DAO.UserDAO;
import java.sql.*;

public class DB_Edit_User {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public void editUserInfo(UserDAO userDAO, Address address) {

        Connection conn = null;
        Statement stmt = null;
        String sql_update_user = "";
        String sql_update_address = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

           //Update user table
            sql_update_user = "UPDATE user SET user_name = "
                    + "\""  + userDAO.getEmail()
                    + "\", fName = \"" + userDAO.getfName()
                    + "\", lName = \"" + userDAO.getlName()
                    + "\", bDate = \"" + userDAO.getbDate()
                    + "\", phoneNumber = \"" + userDAO.getPhoneNumber()
                    + "\" WHERE id = \"" + userDAO.getId() + "\"";


            /*INSERT INTO address (userId, line_one, line_two, line_three, city, zip, state, country)
            VALUES (2, "q1", "q2", "q3", "q4", 3, "q5", "q6")
            ON DUPLICATE KEY UPDATE ID = 2;*/

            if (address.getAddressId() != 0) {

                //Update or Insert (if not exist) address
                sql_update_address = "INSERT INTO address (userId, line_one, line_two, line_three, city, zip, state, country) "
                        + "VALUES (\"" + address.getUserId()
                        + "\", \"" + address.getLineOne()
                        + "\", \"" + address.getLineTwo()
                        + "\", \"" + address.getLineThree()
                        + "\", \"" + address.getZip()
                        + "\", \"" + address.getCity()
                        + "\", \"" + address.getState()
                        + "\", \"" + address.getCountry() + "\")"
                        + " ON DUPLICATE KEY UPDATE ID = \"" + address.getAddressId() + "\"";

            } else {

                sql_update_address = "INSERT INTO address (userId, line_one, line_two, line_three, city, zip, state, country) "
                        + "VALUES (\"" + address.getUserId()
                        + "\", \"" + address.getLineOne()
                        + "\", \"" + address.getLineTwo()
                        + "\", \"" + address.getLineThree()
                        + "\", \"" + address.getCity()
                        + "\", \"" + address.getZip()
                        + "\", \"" + address.getState()
                        + "\", \"" + address.getCountry() + "\")";
            }

            stmt.executeUpdate(sql_update_user);
            stmt.executeUpdate(sql_update_address);

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

    }
}
