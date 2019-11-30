package appLayer;

import DAO.Entity.Assignment;
import DAO.Entity.Averages;
import dataLayer.*;

import java.util.List;

public class GetAssignments {

    public List<Assignment> getAssignmentsByClassId (int classId) {

        DB_Get_Assignments_By_Class_Id DB_Get_Assignments_By_Class_Id = new DB_Get_Assignments_By_Class_Id();

        return DB_Get_Assignments_By_Class_Id.getAssignmentsByClassId(classId);

    }

    public List<Assignment> getAssignmentsByStudentId (int studentId) {

        DB_Get_Assignment_By_Student_Id DB_Get_Assignment_By_Student_Id = new DB_Get_Assignment_By_Student_Id();

        return DB_Get_Assignment_By_Student_Id.getAssignmentByStudentId(studentId);
    }

    public AssignmentAverages getAssignmentAverages (int sId, int cId, int aId) {

        DB_Get_Assignment_Averages DB_Get_Assignment_Averages = new DB_Get_Assignment_Averages();

        return DB_Get_Assignment_Averages.getAssignmentAverages(sId, cId, aId);
    }

    public Averages getClassAverages (int sId, int cId) {

        DB_Get_Averages DB_Get_Averages = new DB_Get_Averages();

        return DB_Get_Averages.getClassAverages(sId, cId);

    }

    public int getStudentClassScore (int sId, int cId) {

        DB_Get_Student_Score_Class DB_Get_Student_Score_Class = new DB_Get_Student_Score_Class();

        return DB_Get_Student_Score_Class.getStudentClassScore(sId, cId);

    }

    public double getStudentAssignmentScore (int sId, int cId, int aId) {

        DB_Get_Student_Score_Assignment DB_Get_Student_Score_Assignment = new DB_Get_Student_Score_Assignment();

        return DB_Get_Student_Score_Assignment.getStudentAssignmentScore(sId, cId, aId);
    }

}
