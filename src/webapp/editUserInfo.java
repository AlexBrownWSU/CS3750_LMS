package webapp;

import DAO.UserDAO;
import appLayer.EditUser;
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

        UserDAO userDAO = new UserDAO();
        EditUser editUser = new EditUser();

        userDAO = editUser.getUserById(request.getParameter("userId"));

        request.setAttribute("lName", userDAO.getlName().toUpperCase());
        request.setAttribute("fName", userDAO.getfName().toUpperCase());
        request.setAttribute("instructorId", String.valueOf(userDAO.getId()));
        request.setAttribute("bDade", userDAO.getbDate());
        request.setAttribute("email", userDAO.getEmail());
        request.setAttribute("password", userDAO.getPassword());

        request.getRequestDispatcher("/editUser.jsp").forward(request, response);

    }
}
