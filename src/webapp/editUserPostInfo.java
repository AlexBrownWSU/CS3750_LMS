package webapp;

import DAO.Entity.Address;
import DAO.UserDAO;
import appLayer.EditUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editUserPostInfo")
public class editUserPostInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Set an instance of UserDao
        UserDAO userDAO = new UserDAO();
        userDAO.setEmail(request.getParameter("username"));
        userDAO.setfName(request.getParameter("fName"));
        userDAO.setlName(request.getParameter("lName"));
        userDAO.setbDate(request.getParameter("bDate"));
        userDAO.setPhoneNumber(request.getParameter("phoneNumber"));
        userDAO.setId(Integer.parseInt(request.getParameter("userId")));

        //Set an instance of Address
        Address address = new Address();
        address.setAddressId(Integer.parseInt(request.getParameter("addressId")));
        address.setUserId(Integer.parseInt(request.getParameter("userId")));
        address.setLineOne(request.getParameter("address1"));
        address.setLineTwo(request.getParameter("address2"));
        address.setLineThree(request.getParameter("address3"));
        address.setCity(request.getParameter("city"));
        address.setZip(Integer.parseInt(request.getParameter("zip")));
        address.setState(request.getParameter("state"));
        address.setCountry(request.getParameter("country"));

        //Call editUser passing in params from .jsp
        EditUser editUser = new EditUser();
        editUser.editUserInfo(userDAO, address);

        //Send request and response
        request.getRequestDispatcher("/editUser.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
