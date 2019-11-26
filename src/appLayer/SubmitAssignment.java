package appLayer;

import DAO.Entity.Assignment;
import DAO.Entity.AssignmentSubmission;
import dataLayer.DB_Check_If_Already_Submitted;
import dataLayer.DB_Submit_Assignment;

public class SubmitAssignment {

    public boolean submitAssignment(AssignmentSubmission submission) {

        DB_Submit_Assignment DB_Submit_Assignment = new DB_Submit_Assignment();

        return DB_Submit_Assignment.submitAssignment(submission);

    }

    public boolean alreadySubmittedCheck(String aId, String sId){

        DB_Check_If_Already_Submitted DB_Check_If_Already_Submitted = new DB_Check_If_Already_Submitted();

        return DB_Check_If_Already_Submitted.checkIfAlreadySubmitted(aId,sId);
    }

}
