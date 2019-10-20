package appLayer;

import DAO.Entity.StudentEnrollment;
import dataLayer.DB_Get_Students_By_Class_Id;

import java.util.List;

public class GetEnrollments {

    public List<StudentEnrollment> getEnrollmentsByClassId (int classId) {

        DB_Get_Students_By_Class_Id DB_Get_Students_By_Class_Id = new DB_Get_Students_By_Class_Id();

        return DB_Get_Students_By_Class_Id.getStudentClassById(classId);
    }
}
