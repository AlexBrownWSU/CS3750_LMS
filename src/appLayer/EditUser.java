package appLayer;

import DAO.UserDAO;
import dataLayer.DB_Get_User_By_ID;

public class EditUser {

    public UserDAO getUserById(String id) {
        DB_Get_User_By_ID DB_Get_User_By_Id_Object = new DB_Get_User_By_ID();

        return DB_Get_User_By_Id_Object.getUserbyId(id);
    }
}
