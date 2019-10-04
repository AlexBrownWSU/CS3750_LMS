package dataLayer;

import DAO.Entity.Address;

import java.sql.*;

public class DB_Get_AddressId_By_UserId {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lms";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Ryu12ryu!";

    public Address getAddressByUserId(String userId) {

        Address address = new Address();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT * FROM address WHERE userId = " + Integer.parseInt(userId);
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                address.setAddressId(rs.getInt("id"));
                address.setUserId(rs.getInt("userId"));
                address.setLineOne(rs.getString("line_one"));
                address.setCity(rs.getString("city"));
                address.setZip(rs.getInt("zip"));
                address.setState(rs.getString("state"));
                address.setCountry(rs.getString("country"));

                if (rs.getString("line_two") != null) {
                    address.setLineTwo(rs.getString("line_two"));
                }

                if (rs.getString("line_three") != null) {
                    address.setLineThree(rs.getString("line_three"));
                }

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

        return address;
    }

}
