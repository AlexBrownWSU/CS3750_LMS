package appLayer;

import DAO.Entity.AssignmentSubmission;
import dataLayer.DB_Get_Submissions_By_AId;

import java.util.List;

public class GetSubmissions {

    public List<AssignmentSubmission> getSubmissionsByAId(String aId){

        DB_Get_Submissions_By_AId DB_Get_Submissions_By_AId = new DB_Get_Submissions_By_AId();

        return DB_Get_Submissions_By_AId.getSubmissionsByAId(aId);
    }
}
