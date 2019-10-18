package dataLayer;

import java.sql.*;

public class DB_Connection {

    // JDBC driver name and database URL
                                        //.database.windows.net
                                        //com.mysql.jdbc.Driver
                                        //com.mysql.cj.jdbc.Driver
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlserver://cs3750-ffdp.database.windows.net:1433";

    // Database credentials
    static final String USER = "FFDP-Admin71@cs3750-ffdp";
    static final String PASS = "FFDeathPunch71";

    public static void main(String[] args) {
        //original try DON'T TOUCH
        // Connect to database
        //String hostName = "cs3750-ffdp.database.windows.net"; // update me
        //String dbName = "FFDP_LMS"; // update me
        //String user = "FFDP-Admin71"; // update me
        //String password = "FFDeathPunch71"; // update me
        ///String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
        //        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        //Connection connection = null;

    /*jdbc:sqlserver://cs3750-ffdp.database.windows.net:1433;
    database=FFDP_LMS;
    user=FFDP-Admin71@cs3750-ffdp;
    password={your_password_here};
    encrypt=true;
    trustServerCertificate=false;
    hostNameInCertificate=*.database.windows.net;
    loginTimeout=30;*/



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



















        /*try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);*/

            /*System.out.println("Query data example:");
            System.out.println("=========================================");

            Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName "
                  + "FROM [SalesLT].[ProductCategory] pc "
                  + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {

                Print results from select statement
                System.out.println("Top 20 categories:");
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString(1) + " "
                            + resultSet.getString(2));
                }
                connection.close();
            }*/
        /*    connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}