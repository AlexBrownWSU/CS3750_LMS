package appLayer;
import DAO.Entity.Averages;
import dataLayer.DB_Get_Assignment_Analytics;

public class getAssignmentAnalytics {

    public Averages getAnalytics(String aId, String cId, String sId){
        DB_Get_Assignment_Analytics DB_Get_Assignment_Analytics = new DB_Get_Assignment_Analytics();

        return DB_Get_Assignment_Analytics.getAnalytics(aId, cId, sId);
    }

}
