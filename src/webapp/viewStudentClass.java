package webapp;

import DAO.Entity.Assignment;
import DAO.Entity.Averages;
import appLayer.AssignmentAverages;
import appLayer.GetAssignments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "viewStudentClass")
public class viewStudentClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int sId = Integer.parseInt(request.getParameter("studentId"));
        int cId = Integer.parseInt(request.getParameter("id"));

        //Create a getAssignments object and get a list of assignments by student ID
        GetAssignments getAssignments = new GetAssignments();
        List<Assignment> assignments = getAssignments.getAssignmentsByStudentId(sId);

        //Get averages - class
        Averages averagesClass = getAssignments.getClassAverages(sId, cId);
        averagesClass.setStudentScore((double) getAssignments.getStudentClassScore(sId, cId));

        List<AssignmentAverages> assignmentAverages = new ArrayList<>();

        //get averages - assignment
        for (int i = 0; i < assignments.size(); i++) {
            Assignment assignment = assignments.get(i);

            int aId = assignment.getaId();

            AssignmentAverages averageAssignment = getAssignments.getAssignmentAverages(sId, cId, aId);

            if (averageAssignment.isResults()) {
                averageAssignment.getAverages().setStudentScore(getAssignments.getStudentAssignmentScore(sId, cId, aId));
                assignmentAverages.add(averageAssignment);
            }
        }

        request.setAttribute("averageAssignment", assignmentAverages);
        request.setAttribute("averages", averagesClass);
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
