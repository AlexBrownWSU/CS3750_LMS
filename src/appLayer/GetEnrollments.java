package appLayer;

import DAO.ClassDAO;
import DAO.Entity.StudentEnrollment;
import dataLayer.DB_Check_If_Already_Enrolled;
import dataLayer.DB_Get_Enrollments_By_Student_Id;
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

    public List<ClassDAO> getEnrollmentsByStudentId (int studentId) {

        DB_Get_Enrollments_By_Student_Id DB_Get_Enrollments_By_Student_Id = new DB_Get_Enrollments_By_Student_Id();

        return DB_Get_Enrollments_By_Student_Id.getEnrollmentsByStudentId(studentId);

    }

    public boolean checkIfEnrolled(int cId, int sId){

        DB_Check_If_Already_Enrolled DB_Check_If_Already_Enrolled = new DB_Check_If_Already_Enrolled();

        return DB_Check_If_Already_Enrolled.checkIfAlreadyEnrolled(cId , sId);
    }
}
