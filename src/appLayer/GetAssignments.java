package appLayer;

import DAO.Entity.Assignment;
import dataLayer.DB_Get_Assignment_By_Student_Id;
import dataLayer.DB_Get_Assignments_By_Class_Id;

import java.util.List;

public class GetAssignments {

    public List<Assignment> getAssignmentsByClassId (int classId) {

        DB_Get_Assignments_By_Class_Id DB_Get_Assignments_By_Class_Id = new DB_Get_Assignments_By_Class_Id();

        return DB_Get_Assignments_By_Class_Id.getAssifnmentsByClassId(classId);

    }

    public List<Assignment> getAssignmentsByStudentId (int studentId) {

        DB_Get_Assignment_By_Student_Id DB_Get_Assignment_By_Student_Id = new DB_Get_Assignment_By_Student_Id();

        return DB_Get_Assignment_By_Student_Id.getAssignmentByStudentId(studentId);
    }

}
