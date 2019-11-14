package appLayer;

import DAO.Entity.Question;
import dataLayer.DB_Get_Questions_By_AId;
import dataLayer.DB_Get_Questions_By_CId;

import java.util.List;

public class GetQuestion {

    public List<Question> getQuestionsByAId(String aId){

        DB_Get_Questions_By_AId DB_Get_Quesions_By_AId = new DB_Get_Questions_By_AId();

        return DB_Get_Quesions_By_AId.getQuestionByAId(aId);
    }

    public List<Question> getQuestionByCId(String cId){

        DB_Get_Questions_By_CId DB_Get_Questions_By_CId = new DB_Get_Questions_By_CId();

        return DB_Get_Questions_By_CId.getQuestionByCId(cId);
    }

}
