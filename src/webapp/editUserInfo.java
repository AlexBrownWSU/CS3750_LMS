package webapp;

import DAO.Entity.Address;
import DAO.UserDAO;
import appLayer.EditUser;
import appLayer.GetAddress;
import appLayer.User;
import org.w3c.dom.UserDataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editUserInfo")
public class editUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get user personal data
        UserDAO userDAO;
        EditUser editUser = new EditUser();

        userDAO = editUser.getUserById(request.getParameter("userId"));

        request.setAttribute("lName", userDAO.getlName().toUpperCase());
        request.setAttribute("fName", userDAO.getfName().toUpperCase());
        request.setAttribute("instructorId", String.valueOf(userDAO.getId()));
        request.setAttribute("bDate", userDAO.getbDate());
        request.setAttribute("email", userDAO.getEmail());
        request.setAttribute("password", userDAO.getPassword());
        request.setAttribute("id", userDAO.getId());
        request.setAttribute("bio", userDAO.getBio());

       if (userDAO.getPhoneNumber() != null) {
            request.setAttribute("phoneNumber", userDAO.getPhoneNumber());
        } else {
            request.setAttribute("phoneNumber", "NO NUMBER GIVEN");
        }

        //Get user address info
        Address address;
        GetAddress getAddress = new GetAddress();

        address = getAddress.getAddressByUserId(request.getParameter("userId"));

        request.setAttribute("addressId", address.getAddressId());
        request.setAttribute("lineOne", address.getLineOne());
        request.setAttribute("lineTwo", address.getLineTwo());
        request.setAttribute("lineThree", address.getLineThree());
        request.setAttribute("zip", address.getZip());
        request.setAttribute("city", address.getCity());
        request.setAttribute("state", address.getState());
        request.setAttribute("country", address.getCountry());

        //Send request and response
        request.getRequestDispatcher("/editUser.jsp").forward(request, response);

    }
}
