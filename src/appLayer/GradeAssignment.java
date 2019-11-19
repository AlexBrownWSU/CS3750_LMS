package appLayer;

import DAO.Entity.GradedSubmission;
import dataLayer.DB_Grade_Submission;

public class GradeAssignment {

    public void gradeAssignment(GradedSubmission gradedSubmission) {

        DB_Grade_Submission DB_Grade_Submission = new DB_Grade_Submission();

        DB_Grade_Submission.grade(gradedSubmission);

    }

}
