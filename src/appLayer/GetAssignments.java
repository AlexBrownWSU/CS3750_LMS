package appLayer;

import DAO.Entity.Assignment;
import DAO.Entity.SubmitAssignment;
import dataLayer.DB_Get_Assignments_By_Class_Id;
import dataLayer.DB_Get_Submitted_Assignments;

import java.util.List;

public class GetAssignments {

    public List<Assignment> getAssignmentsByClassId (int classId) {

        DB_Get_Assignments_By_Class_Id DB_Get_Assignments_By_Class_Id = new DB_Get_Assignments_By_Class_Id();

        return DB_Get_Assignments_By_Class_Id.getAssifnmentsByClassId(classId);

    }

    public Assignment getAssignmentByAId(String aId){
        Assignment assignment = new Assignment();
        return  assignment;
    }

    public List<SubmitAssignment> getSubmittedAssignments(int classId, int userId) {

        DB_Get_Submitted_Assignments DB_Get_Submitted_Assignments = new DB_Get_Submitted_Assignments();

        return DB_Get_Submitted_Assignments.getSubAssignByUserAndClassId(classId , userId);

    }

}
