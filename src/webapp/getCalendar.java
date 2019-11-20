package webapp;

import DAO.Entity.StudentEnrollment;
import appLayer.GetEnrollments;

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
        int studentId = request.getParameter("studentId");
        List<Assignment> assignments = GetStudentAssignments.getAssignmentByStudentId(studentId);
        request.setAttribute("assignments", assignments);
        request.getRequestDispatcher("/fullcalendar.jsp").forward(request, response);
    }
}