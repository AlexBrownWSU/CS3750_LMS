package appLayer;

import dataLayer.DB_New_Class;

public class NewClass {

    public void writeClassToDB(String cName, String dateTime, String instructorId) {

        DB_New_Class DB_New_Class = new DB_New_Class();

        DB_New_Class.writeNewClass(cName, dateTime, instructorId);

    }

}
