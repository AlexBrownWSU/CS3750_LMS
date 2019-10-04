package appLayer;

import DAO.Entity.Address;
import dataLayer.DB_Get_AddressId_By_UserId;

public class GetAddress {

    public Address getAddressByUserId(String userId) {

        DB_Get_AddressId_By_UserId DB_Get_AddressId_By_UserID_Object = new DB_Get_AddressId_By_UserId();

        return DB_Get_AddressId_By_UserID_Object.getAddressByUserId(userId);
    }
}
