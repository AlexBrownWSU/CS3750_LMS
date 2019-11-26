package webapp;

import DAO.ClassDAO;
import DAO.Entity.Assignment;
import DAO.Entity.AssignmentSubmission;

import appLayer.GetAssignments;
import appLayer.GetClass;


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
        //Get class from DB
             ClassDAO classDAO;
             GetClass getClass = new GetClass();

             classDAO = getClass.getClassesById(request.getAttribute("cId").toString());

        //Get assignments from DB
            GetAssignments getAssignments = new GetAssignments();

            List<Assignment> assignmentList = new ArrayList<>();

            request.setAttribute("cId", String.valueOf(classDAO.getId()));
            request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
            request.setAttribute("cName", classDAO.getcName());
            request.setAttribute("meetingTime", classDAO.getMeetingTime());

            request.setAttribute("fName", request.getAttribute("fName"));
            request.setAttribute("lName", request.getAttribute("lName"));
            request.setAttribute("id", request.getAttribute("studentId"));


            GetAssignments getSubAssignments = new GetAssignments();
            List<AssignmentSubmission> SubmittedAssignmentList = new ArrayList<>();

            int uId = Integer.parseInt(request.getAttribute("studentId").toString());

            SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), uId);
            assignmentList = getAssignments.getToDoAssignmentByClassId((classDAO.getId()), uId);

            request.setAttribute("marker", request.getAttribute("marker"));
            request.setAttribute("assignments", assignmentList);
            request.setAttribute("submitted", SubmittedAssignmentList);

            request.getRequestDispatcher("/studentClass.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        //Get class from DB
        ClassDAO classDAO;
        GetClass getClass = new GetClass();

        classDAO = getClass.getClassesById(request.getParameter("cId"));

        //Get assignments from DB
        GetAssignments getAssignments = new GetAssignments();

        List<Assignment> assignmentList = new ArrayList<>();

        request.setAttribute("cId", String.valueOf(classDAO.getId()));
        request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
        request.setAttribute("cName", classDAO.getcName());
        request.setAttribute("meetingTime", classDAO.getMeetingTime());

        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("id", request.getParameter("studentId"));

        GetAssignments getSubAssignments = new GetAssignments();
        List<AssignmentSubmission> SubmittedAssignmentList = new ArrayList<>();

        int uId = Integer.parseInt(request.getParameter("studentId"));

        SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), uId);
        assignmentList = getAssignments.getToDoAssignmentByClassId((classDAO.getId()), uId);

        request.setAttribute("marker", 0);
        request.setAttribute("assignments", assignmentList);
        request.setAttribute("submitted", SubmittedAssignmentList);


        request.getRequestDispatcher("/studentClass.jsp").forward(request, response);



    }
}
