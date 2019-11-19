package DAO.Entity;

public class GradedSubmission {

    int aId;
    int sId;
    int grade;

    public void setGrade(int aId, int sId, int grade) {
        this.aId = aId;
        this.sId = sId;
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
}
