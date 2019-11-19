package appLayer;

import DAO.Entity.Assignment;
import dataLayer.DB_New_Assignment;
import dataLayer.DB_New_Class;

public class NewAssignment {

    public void writeAssignmentToDB (Assignment assignment) {

        DB_New_Assignment DB_New_Assignment = new DB_New_Assignment();

        DB_New_Assignment.writeNewAssignment(assignment);

    }

}
