package appLayer;

import DAO.UserDAO;
import dataLayer.DB_Get_User;
import dataLayer.DB_Get_User_By_ID;
import dataLayer.DB_Instructor_Check;
import dataLayer.DB_User;

public class User {



    public boolean isValidUser(String username, String password) {

        DB_User DB_user_object = new DB_User();

        return DB_user_object.isValidUserLogin(username, password);
    }

    public boolean isInstructor(String username) {

        DB_Instructor_Check DB_instructor_check_object = new DB_Instructor_Check();

        return DB_instructor_check_object.isInstructorCheck(username);
    }

    public UserDAO getUser(String username, String password) {

        DB_Get_User DB_get_user_object = new DB_Get_User();

        return DB_get_user_object.getUser(username, password);
    }




}
