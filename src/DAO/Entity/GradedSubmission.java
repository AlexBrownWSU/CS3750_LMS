package DAO.Entity;

public class GradedSubmission {

    int aId;
    int sId;
    int grade;
    int submissionId;

    public void setGrade(int aId, int sId, int submissionId, int grade) {
        this.aId = aId;
        this.sId = sId;
        this.submissionId = submissionId;
        this.grade = grade;
    }

    public int getaId() {
        return aId;
    }

    public int getsId() {
        return sId;
    }

    public int getGrade() {
        return grade;
    }

    public int getSubmissionId() {
        return submissionId;
    }
}
