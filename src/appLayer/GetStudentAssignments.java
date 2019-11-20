package appLayer;

import DAO.Entity.Assignment;
import dataLayer.DB_Get_Assignments_By_Class_Id;

import java.util.List;

public class GetStudentAssignments {

    public List<Assignment> getAssignmentsByStudentId (int studentId) {

        DB_Get_Student_Assignments_By_ID studentAssignments = new DB_Get_Student_Assignments_By_ID();

        return studentAssignments.getAssignmentByStudentId(studentId);

    }

}