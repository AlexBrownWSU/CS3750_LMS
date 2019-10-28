package appLayer;

import DAO.Entity.Question;
import dataLayer.DB_New_Question;

public class NewQuestion {

    public void writeQuestionToDB (Question question) {

        DB_New_Question DB_New_Question = new DB_New_Question();

        DB_New_Question.writeNewQuestion(question);
    }

}
