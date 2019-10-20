package webapp;

import DAO.Entity.Assignment;
import DAO.Entity.Question;
import appLayer.NewAssignment;
import appLayer.NewClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "addAssignment")
public class addAssignment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NewAssignment newAssignment = new NewAssignment();

        //Create instance of assignment
        Assignment assignment = new Assignment();

        //Get assignment from class page
        assignment.setaName(request.getParameter("aName"));
        assignment.settPoints(Integer.parseInt(request.getParameter("tPoints")));
        assignment.setStartDate(request.getParameter("startDate"));
        assignment.setDueDate(request.getParameter("dueDate"));
        assignment.setcId(Integer.parseInt(request.getParameter("cId")));

        //Add assignment to DB
        newAssignment.writeAssignmentToDB(assignment);

        String s1 = request.getParameter("id");
        String s2 = request.getParameter("instructorId");
        String s3 = request.getParameter("fName");
        String s4 = request.getParameter("lName");

        //Set request data
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("instructorId", request.getParameter("instructorId"));
        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));

        //Send request and response
        request.getRequestDispatcher("/viewClass").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
