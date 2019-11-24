package appLayer;

import DAO.Entity.GradedSubmission;
import dataLayer.DB_Grade_Submission;
import dataLayer.DB_Update_Submission_Status;

public class GradeAssignment {

    public void gradeAssignment(GradedSubmission gradedSubmission) {

        DB_Grade_Submission DB_Grade_Submission = new DB_Grade_Submission();

        DB_Grade_Submission.grade(gradedSubmission);

    }

    public void updateSubmissionStatus (int submissionId) {

        DB_Update_Submission_Status DB_Update_Submission_Status = new DB_Update_Submission_Status();

        DB_Update_Submission_Status.updateSubmissionStatus(submissionId);
    }

}
