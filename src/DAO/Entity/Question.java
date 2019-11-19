package DAO.Entity;

public class Question {

    String question;
    int qPoints;
    int qId;
    int aId;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getqPoints() {
        return qPoints;
    }

    public void setqPoints(int qPoints) {
        this.qPoints = qPoints;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }
}
