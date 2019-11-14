package DAO.Entity;


import java.io.InputStream;
import java.util.List;

public class SubmitAssignment {
    int sId;
    int aId;
    int cId;
    int uId;
    int grade;
    String submissionDate;
    String answers;
    boolean status;

    //List<AnswerSubmission> answerSubmissionList;

    String fileName;
    InputStream file;

    int tPoints;
    String startDate;
    String dueDate;
    String aName;


    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getAId() {
        return aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }

    public int getcId(){return cId; }

    public void setcId(int cId){this.cId = cId;}

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAnswers(){return answers;}

    public void setAnswers(String answers){this.answers = answers;}

    public boolean isStatus() { return status;    }

    public void setStatus(boolean status) { this.status = status; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public InputStream getFile() { return file; }

    public void setFile(InputStream file) { this.file = file; }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int gettPoints() {
        return tPoints;
    }

    public void settPoints(int tPoints) {
        this.tPoints = tPoints;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
