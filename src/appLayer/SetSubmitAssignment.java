package appLayer;

import DAO.Entity.SubmitAssignment;
import dataLayer.DB_Submit_Assignment;

public class SetSubmitAssignment {
    public boolean submitAssignment(SubmitAssignment submission) {
        DB_Submit_Assignment DB_Submit_Assignment = new DB_Submit_Assignment();
        return DB_Submit_Assignment.submitAssignment(submission);
    }


}
