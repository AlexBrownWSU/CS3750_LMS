package webapp;

import DAO.ClassDAO;
import DAO.Entity.Assignment;
import DAO.Entity.AssignmentSubmission;

import DAO.Entity.Averages;
import appLayer.AssignmentAverages;
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
        int sId = Integer.parseInt(request.getAttribute("studentId").toString());
        int cId = Integer.parseInt(request.getAttribute("cId").toString());

        GetAssignments getAssignments = new GetAssignments();
        List<Assignment> assignments = getAssignments.getToDoAssignmentByClassId(cId,sId);
        List<Assignment> allAssignments = getAssignments.getAssignmentsByClassId(cId);

        Averages averagesClass = getAssignments.getClassAverages(sId, cId);
        averagesClass.setStudentScore((double) getAssignments.getStudentClassScore(sId, cId));

        List<AssignmentAverages> assignmentAverages = new ArrayList<>();

        //get averages - assignment
        for (int i = 0; i < allAssignments.size(); i++) {
            Assignment assignment = allAssignments.get(i);

            int aId = assignment.getaId();

            AssignmentAverages averageAssignment = getAssignments.getAssignmentAverages(sId, cId, aId);

            if (averageAssignment.isResults()) {
                averageAssignment.getAverages().setStudentScore(getAssignments.getStudentAssignmentScore(sId, cId, aId));
                assignmentAverages.add(averageAssignment);
            }
        }

        classDAO = getClass.getClassesById("" + cId);

            request.setAttribute("averageAssignment", assignmentAverages);
            request.setAttribute("averages", averagesClass);
            request.setAttribute("cId", String.valueOf(classDAO.getId()));
            request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
            request.setAttribute("cName", classDAO.getcName());
            request.setAttribute("meetingTime", classDAO.getMeetingTime());
            request.setAttribute("fName", request.getAttribute("fName"));
            request.setAttribute("lName", request.getAttribute("lName"));
            request.setAttribute("id", request.getAttribute("studentId"));


            GetAssignments getSubAssignments = new GetAssignments();
            List<AssignmentSubmission> SubmittedAssignmentList = new ArrayList<>();



            SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), sId);


            request.setAttribute("marker", request.getAttribute("marker"));
            request.setAttribute("assignments", assignments);
            request.setAttribute("submitted", SubmittedAssignmentList);

            request.getRequestDispatcher("/studentClass.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int sId = Integer.parseInt(request.getParameter("studentId"));

        int cId = Integer.parseInt(request.getParameter("cId"));

        GetAssignments getAssignments = new GetAssignments();
        List<Assignment> assignments = getAssignments.getToDoAssignmentByClassId(cId,sId);

        List<Assignment> allAssignments = getAssignments.getAssignmentsByClassId(cId);

//        Get averages - class
        Averages averagesClass = getAssignments.getClassAverages(sId, cId);
        averagesClass.setStudentScore((double) getAssignments.getStudentClassScore(sId, cId));

        List<AssignmentAverages> assignmentAverages = new ArrayList<>();

        //get averages - assignment
        for (int i = 0; i < allAssignments.size(); i++) {
            Assignment assignment = allAssignments.get(i);

            int aId = assignment.getaId();

            AssignmentAverages averageAssignment = getAssignments.getAssignmentAverages(sId, cId, aId);

            if (averageAssignment.isResults()) {
                averageAssignment.getAverages().setStudentScore(getAssignments.getStudentAssignmentScore(sId, cId, aId));
                assignmentAverages.add(averageAssignment);
            }
        }



        //Get class from DB
        ClassDAO classDAO;
        GetClass getClass = new GetClass();

        classDAO = getClass.getClassesById(request.getParameter("cId"));

        GetAssignments getSubAssignments = new GetAssignments();
        List<AssignmentSubmission> SubmittedAssignmentList = new ArrayList<>();
        SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), sId);


        request.setAttribute("averageAssignment", assignmentAverages);
        request.setAttribute("averages", averagesClass);
        request.setAttribute("marker", 0);
        request.setAttribute("cId", String.valueOf(classDAO.getId()));
        request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
        request.setAttribute("cName", classDAO.getcName());
        request.setAttribute("meetingTime", classDAO.getMeetingTime());
        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("id", request.getParameter("studentId"));
        request.setAttribute("assignments", assignments);
        request.setAttribute("submitted", SubmittedAssignmentList);


        request.getRequestDispatcher("/studentClass.jsp").forward(request, response);



    }
}
