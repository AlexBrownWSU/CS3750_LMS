package dataLayer;

import DAO.Entity.CalendarEvent;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DB_Get_Calendar_Events_By_SID {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test3750db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "FastStaff2020";

    public List<CalendarEvent> getCalendarEvents (int studentId) {

        List<CalendarEvent> calendarEvents = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating statement...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statment...");
            stmt = conn.createStatement();

            sql = "SELECT aName, dueDate  " +
                    "FROM assignment a " +
                    "INNER JOIN enrollment e ON a.classId=e.class_id " +
                    "INNER JOIN user u ON u.id=e.student_id " +
                    "WHERE u.id = " + studentId;
            System.out.println("sql");

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                CalendarEvent calendarEvent = new CalendarEvent();

                calendarEvent.setTitle(rs.getString("aName"));
                calendarEvent.setAllDay(false);
                calendarEvent.setClassName("important");

                String dateStr = rs.getString("dueDate");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(dateStr);
                String parsedEvent = new SimpleDateFormat("MMMM dd, yyyy HH:mm").format(date);

                calendarEvent.setEvent(parsedEvent);

                calendarEvents.add(calendarEvent);

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

        return calendarEvents;

    }
}
