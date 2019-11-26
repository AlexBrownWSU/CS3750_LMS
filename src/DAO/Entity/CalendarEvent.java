package DAO.Entity;

public class CalendarEvent {

    boolean AllDay;
    String Title;
    String ClassName;
    String Event;

    public boolean getAllDay(){return AllDay;}
    public void setAllDay(boolean AllDay){this.AllDay = AllDay;}

    public String getTitle(){return Title;}
    public void setTitle(String Title){this.Title = Title;}

    public String getClassName(){return ClassName;}
    public void setClassName(String ClassName){this.ClassName = ClassName;}

    public String getEvent(){return Event;}
    public void setEvent(String Event){this.Event = Event;}



}
