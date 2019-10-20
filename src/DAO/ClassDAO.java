package DAO;

public class ClassDAO {

    int Id;
    String crn;
    String cName;
    String meetingTime;
    int instructorId;
    String iFName;
    String iLName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getiFName() {
        return iFName;
    }

    public void setiFName(String iFName) {
        this.iFName = iFName;
    }

    public String getiLName() {
        return iLName;
    }

    public void setiLName(String iLName) {
        this.iLName = iLName;
    }
}
