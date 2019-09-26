package appLayer;

import dataLayer.DB_New_User;

public class NewUser {

    public void writeUserToDB(String fName, String lName, String bDate, String email, String password, String userType) {

        int type = 1;

        if (null == userType) {
            type = 0;
        } /*else if (userType == null) {
            type = 0;
        }*/

        DB_New_User DB_New_User = new DB_New_User();

        DB_New_User.writeNewUser(fName, lName, bDate, email, password, type);


    }


}
