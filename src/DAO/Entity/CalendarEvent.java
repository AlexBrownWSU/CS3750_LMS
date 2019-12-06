package DAO.Entity;

public class CalendarEvent {

    boolean allDay;
    String title;
    String className;
    String event;

    public boolean getAllDay(){return allDay;}
    public void setAllDay(boolean AllDay){this.allDay = AllDay;}

    public String getTitle(){return title;}
    public void setTitle(String Title){this.title = Title;}

    public String getClassName(){return className;}
    public void setClassName(String ClassName){this.className = ClassName;}

    public String getEvent(){return event;}
    public void setEvent(String Event){this.event = Event;}



}
