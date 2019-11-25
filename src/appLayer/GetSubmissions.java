package appLayer;

import DAO.Entity.AssignmentSubmission;
import DAO.Entity.FileSubmission;
import DAO.Entity.Question;
import dataLayer.*;

import java.sql.Blob;
import java.util.List;

public class GetSubmissions {

    public List<AssignmentSubmission> getSubmissionsByAId(String aId){

        DB_Get_Submissions_By_AId DB_Get_Submissions_By_AId = new DB_Get_Submissions_By_AId();

        return DB_Get_Submissions_By_AId.getSubmissionsByAId(aId);
    }

    public AssignmentSubmission getSubmissionByAIdSId(String aId, String sId) {

        DB_Get_Submissions_By_AId_SId DB_Get_Submissions_By_AId_SId = new DB_Get_Submissions_By_AId_SId();

        return DB_Get_Submissions_By_AId_SId.getSubmission(aId, sId);
    }

    public List<String> getAs (String aId, String sId) {

        DB_Get_As DB_Get_As = new DB_Get_As();

        return DB_Get_As.getAs(aId, sId);

    }

    public List<Question> getQs (String aId) {

        DB_Get_Qs DB_Get_Qs = new DB_Get_Qs();

        return DB_Get_Qs.getQs(aId);

    }

    public FileSubmission getSubmissionFile (String aId, String sId) {

        DB_Get_File_2 DB_Get_File = new DB_Get_File_2();

        return DB_Get_File.getSubmissionFile(aId, sId);

    }
}
