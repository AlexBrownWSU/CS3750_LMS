package appLayer;

import DAO.Entity.Address;
import DAO.UserDAO;
import dataLayer.DB_Edit_User;
import dataLayer.DB_Get_User_By_ID;

public class EditUser {

    public UserDAO getUserById(String id) {
        DB_Get_User_By_ID DB_Get_User_By_Id_Object = new DB_Get_User_By_ID();

        return DB_Get_User_By_Id_Object.getUserbyId(id);
    }

    public void editUserInfo(UserDAO userDAO, Address address) {

        DB_Edit_User DB_Edit_User_Object = new DB_Edit_User();

        DB_Edit_User_Object.editUserInfo(userDAO, address);

    }
}
