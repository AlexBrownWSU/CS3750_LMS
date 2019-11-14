package webapp;

import DAO.Entity.Assignment;
import appLayer.GetAssignments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewStudentClass")
public class viewStudentClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //Create a getAssignments object and get a list of assignments by student ID
        GetAssignments getAssignments = new GetAssignments();
        List<Assignment> assignments = getAssignments.getAssignmentsByStudentId(Integer.parseInt(request.getParameter("studentId")));

        request.setAttribute("assignments", assignments);
        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("studentId", request.getParameter("studentId"));
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("cName", request.getParameter("cName"));

        //Go to class.jsp
        request.getRequestDispatcher("/studentClass.jsp").forward(request, response);

    }
}
