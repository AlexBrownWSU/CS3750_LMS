package DAO.Entity;

public class AnswerSubmission {

    String answer;
    String question;
    int qPoints;

    public void setAnswerSubmission(String answer, String question, int qPoints) {
        this.answer = answer;
        this.question = question;
        this.qPoints = qPoints;
    }

}
