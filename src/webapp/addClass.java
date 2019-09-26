package webapp;

import appLayer.NewClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addClass")
public class addClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NewClass newClass = new NewClass();

        //Set Parameters
        request.setAttribute("cName", request.getParameter("cName"));
        request.setAttribute("dateTime", request.getParameter("dateTime"));
        request.setAttribute("instructorId", request.getParameter("instructorId"));

        newClass.writeClassToDB(
                request.getParameter("cName"),
                request.getParameter("dateTime"),
                request.getParameter("instructorId")
        );

        request.getRequestDispatcher("/userLandingPage.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
