package appLayer;

import DAO.ClassDAO;
import dataLayer.DB_Get_Class_By_Id;
import dataLayer.DB_Get_Class_By_Instructor;
import dataLayer.DB_Get_Classes_All;
import dataLayer.DB_Get_Classes_by_student;

import java.util.List;

public class GetClass {

    public List<ClassDAO> getClasses(String instructorId) {

        DB_Get_Class_By_Instructor DB_Get_Class_By_Instructor =  new DB_Get_Class_By_Instructor();

        return DB_Get_Class_By_Instructor.getClasses(instructorId);
    }

    public ClassDAO getClassesById(String classId) {

        DB_Get_Class_By_Id DB_Get_Class_By_Id_Object = new DB_Get_Class_By_Id();


        return DB_Get_Class_By_Id_Object.getClassById(classId);
    }


    public List<ClassDAO> getAllClasses(String sId) {

        DB_Get_Classes_All DB_Get_Classes = new DB_Get_Classes_All();

        return DB_Get_Classes.getClasses(sId);
    }

    public List<ClassDAO> getClassesForStudent(String studentId) {

        DB_Get_Classes_by_student DB_Get_Classes_by_student = new DB_Get_Classes_by_student();

        return DB_Get_Classes_by_student.getClassesByStudent(studentId);
    }


}
