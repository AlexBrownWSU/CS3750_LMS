package DAO.Entity;

import DAO.UserDAO;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AssignmentSubmission {

    int aId;
    int cId;
    int sId;
    int grade;
    int tPoints;
    String submissionDate;
    List<AnswerSubmission> answerSubmissionList;
    String answers;
    boolean status;
    String fName;
    String lName;
    String aName;
    String fileName;
    InputStream file;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public List<AnswerSubmission> getAnswerSubmissionList() {
        return answerSubmissionList;
    }

    public void setAnswerSubmissionList(List<AnswerSubmission> answerSubmissionList) {
        this.answerSubmissionList = answerSubmissionList;
    }

    public int gettPoints() {
        return tPoints;
    }

    public void settPoints(int tPoints) {
        this.tPoints = tPoints;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
