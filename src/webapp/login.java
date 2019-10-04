package webapp;

import DAO.ClassDAO;
import DAO.UserDAO;
import appLayer.GetClass;
import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   /*PrintWriter out = response.getWriter();
   out.print("userName: " + request.getParameter("username") + "Password: " + request.getParameter("password"));*/

        User user = new User();
        GetClass getClass = new GetClass();

        //Set Parameters
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("password", request.getParameter("password"));

        if (user.isValidUser(request.getParameter("username"), request.getParameter("password"))) {

            if (user.isInstructor(request.getParameter("username"))){ //Go to instructor page

                //UserDAO
                UserDAO userDAO = new UserDAO();
                userDAO = user.getUser(request.getParameter("username"), request.getParameter("password"));

                //ClassDAO
                List<ClassDAO> classes = new ArrayList<ClassDAO>();
                classes = getClass.getClasses(String.valueOf(userDAO.getId()));


                //Set attributes
                request.setAttribute("classes", classes);
                request.setAttribute("lName", userDAO.getlName().toUpperCase());
                request.setAttribute("fName", userDAO.getfName().toUpperCase());
                request.setAttribute("instructorId", String.valueOf(userDAO.getId()));
                request.getRequestDispatcher("/userLandingPage.jsp").forward(request, response);


            } else { //Go to student page

                UserDAO userDAO = new UserDAO();
                userDAO = user.getUser(request.getParameter("username"), request.getParameter("password"));

                request.setAttribute("lName", userDAO.getlName().toUpperCase());
                request.setAttribute("fName", userDAO.getfName().toUpperCase());
                request.setAttribute("studentId", String.valueOf(userDAO.getId()));
                request.getRequestDispatcher("/studentLandingPage.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("errorMessage", "Invalid Login: Please Try again or Sign up");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
