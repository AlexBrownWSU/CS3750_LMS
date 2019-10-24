package appLayer;

import DAO.Entity.StudentEnrollment;
import dataLayer.DB_Get_Students_By_Class_Id;
import dataLayer.DB_New_Enrollment;

import java.util.List;

public class GetEnrollments {

    public List<StudentEnrollment> getEnrollmentsByClassId (int classId) {

        DB_Get_Students_By_Class_Id DB_Get_Students_By_Class_Id = new DB_Get_Students_By_Class_Id();

        return DB_Get_Students_By_Class_Id.getStudentClassById(classId);
    }

    public void setStudentEnrollment (StudentEnrollment studentEnrollment) {

        DB_New_Enrollment DB_New_Enrollment = new DB_New_Enrollment();

        DB_New_Enrollment.writeNewEnrollment(studentEnrollment);

    }
}
