import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

class DB_Test_Connection {
    public void testConnection() {
        Connection conn = null;

        try
        {

            String url = "jdbc:mysql://18.191.104.66:3306/lms";
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (url,"ubuntu","cs3750lms");
            System.out.println ("Database connection established");
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
}