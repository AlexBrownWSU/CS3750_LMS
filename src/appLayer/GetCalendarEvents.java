package appLayer;

import DAO.Entity.CalendarEvent;
import dataLayer.DB_Get_Calendar_Events_By_SID;

import java.util.List;

public class GetCalendarEvents {

    public List<CalendarEvent> getCalendarEvents (int studentId) {

        DB_Get_Calendar_Events_By_SID DB_Get_Calendar_Events_By_SID = new DB_Get_Calendar_Events_By_SID();

        return DB_Get_Calendar_Events_By_SID.getCalendarEvents(studentId);

    }
}
