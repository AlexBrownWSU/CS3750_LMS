package webapp;

import appLayer.NewUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signUp")
public class signUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NewUser newUser = new NewUser();

        //Set Parameters
        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("bDate", request.getParameter("bDate"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("password", request.getParameter("password"));
        request.setAttribute("userType", request.getParameter("userType"));

        //Write data to file
        newUser.writeUserToDB(
                request.getParameter("fName"),
                request.getParameter("lName"),
                request.getParameter("bDate"),
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("userType"));

        //Go back to login page
        request.getRequestDispatcher("/login.jsp").forward(request, response);



   /*if (newUser.isValidUser(request.getParameter("username"), request.getParameter("password"))) {

       request.getRequestDispatcher("/home.jsp").forward(request, response);

   } else {
       request.setAttribute("errorMessage", "Invalid Login: Please Try again or Sign up");
       request.getRequestDispatcher("/login.jsp").forward(request, response);
   }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
