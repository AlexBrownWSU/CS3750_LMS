package appLayer;

import DAO.ClassDAO;
import dataLayer.DB_Get_Class_By_Id;
import dataLayer.DB_Get_Class_By_Instructor;

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
}
