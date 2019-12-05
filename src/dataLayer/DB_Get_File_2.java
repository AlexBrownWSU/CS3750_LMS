package dataLayer;

import DAO.Entity.FileSubmission;

import java.io.*;
import java.sql.*;

public class DB_Get_File_2 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://18.191.104.66:3306/lms";

    // Database credentials
    static final String USER = "ubuntu";
    static final String PASS = "cs3750lms";

    public FileSubmission getSubmissionFile (String aId, String sId) {

        FileSubmission fileSubmission = new FileSubmission();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT filename, file " +
                    "FROM Submission " +
                    "WHERE aId = " + Integer.parseInt(aId) + " " +
                    "AND sId = " + Integer.parseInt(sId);

            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                String home = System.getProperty("user.home");
                Blob blob = rs.getBlob("file");
                InputStream in = blob.getBinaryStream();
                File file = new File(home+"/Downloads/" + rs.getString("filename"));
                OutputStream out = new FileOutputStream(file);
                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                int len = 0;

                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
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

        return fileSubmission;
    }

    private static String convert(InputStream is) {
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result;
        String str = null;
        try {
            result = bis.read();

            while (result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }
            str = buf.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
