package webapp;

import DAO.ClassDAO;
import appLayer.GetClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "viewClass")
public class viewClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClassDAO classDAO;
        GetClass getClass = new GetClass();

        classDAO = getClass.getClassesById(request.getParameter("id"));

        request.setAttribute("cId", String.valueOf(classDAO.getId()));
        request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
        request.setAttribute("cName", classDAO.getcName());
        request.setAttribute("meetingTime", classDAO.getMeetingTime());

        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("id", request.getParameter("instructorsId"));

        request.getRequestDispatcher("/class.jsp").forward(request, response);

    }
}
