package DAO.Entity;

import java.util.Calendar;
import java.util.Date;

public class CalendarEvent {

    String title;
    Boolean allDay;
    String className;
    String event;

    //public void setStart(Calendar start) {
        //this.start = start;
    //}

    //November 26, 2019 04:04:00
    public void setEvent (String event) {
        this.event = event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
