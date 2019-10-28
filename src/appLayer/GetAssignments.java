package appLayer;

import DAO.Entity.Assignment;
import dataLayer.DB_Get_Assignments_By_Class_Id;

import java.util.List;

public class GetAssignments {

    public List<Assignment> getAssignmentsByClassId (int classId) {

        DB_Get_Assignments_By_Class_Id DB_Get_Assignments_By_Class_Id = new DB_Get_Assignments_By_Class_Id();

        return DB_Get_Assignments_By_Class_Id.getAssifnmentsByClassId(classId);

    }

}
