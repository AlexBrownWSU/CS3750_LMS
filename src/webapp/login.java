package webapp;

import DAO.ClassDAO;
import DAO.Entity.StudentEnrollment;
import DAO.UserDAO;
import appLayer.GetClass;
import appLayer.GetEnrollments;
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

                //Get User
                UserDAO userDAO = new UserDAO();
                userDAO = user.getUser(request.getParameter("username"), request.getParameter("password"));

                //Get list of all classes
                List<ClassDAO> allclasses = new ArrayList<>();
                allclasses = getClass.getAllClasses(String.valueOf(userDAO.getId()));

                List<ClassDAO> classes = new ArrayList<>();
                classes = getClass.getClassesForStudent(String.valueOf(userDAO.getId()));

                request.setAttribute("allclasses", allclasses);
                request.setAttribute("classes", classes);
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
        User user = new User();
        GetClass getClass = new GetClass();


        UserDAO userDAO = new UserDAO();
        userDAO = user.getUserById(request.getParameter("userId"));

            if (user.isInstructor(userDAO.getEmail())){ //Go to instructor page



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

                //Get list of all classes
                List<ClassDAO> allclasses = new ArrayList<>();
                allclasses = getClass.getAllClasses(String.valueOf(userDAO.getId()));

                List<ClassDAO> classes = new ArrayList<>();
                classes = getClass.getClassesForStudent(String.valueOf(userDAO.getId()));

                request.setAttribute("allclasses", allclasses);
                request.setAttribute("classes", classes);
                request.setAttribute("lName", userDAO.getlName().toUpperCase());
                request.setAttribute("fName", userDAO.getfName().toUpperCase());
                request.setAttribute("studentId", String.valueOf(userDAO.getId()));
                request.getRequestDispatcher("/studentLandingPage.jsp").forward(request, response);
            }


    }

}
