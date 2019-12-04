package webapp;

import DAO.Entity.Assignment;
import DAO.Entity.StudentEnrollment;
import appLayer.GetAssignments;
import appLayer.GetEnrollments;
import dataLayer.DB_Get_Assignment_By_Student_Id;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getCalendar")
public class getCalendar extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        GetAssignments getStudentAssignments = new GetAssignments();
        List<Assignment> assignments = getStudentAssignments.getAssignmentsByStudentId(studentId);
        request.setAttribute("assignments", assignments);
        request.setAttribute("studentId", studentId);
        request.getRequestDispatcher("/fullcalendar.jsp").forward(request, response);
    }
}