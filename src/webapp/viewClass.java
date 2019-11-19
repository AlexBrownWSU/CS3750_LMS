package webapp;

import DAO.ClassDAO;
import DAO.Entity.Assignment;
import DAO.Entity.Question;
import DAO.Entity.StudentEnrollment;
import DAO.Entity.SubmitAssignment;
import appLayer.GetAssignments;
import appLayer.GetClass;
import appLayer.GetEnrollments;
import appLayer.GetQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "viewClass")
public class viewClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get class from DB
        ClassDAO classDAO;
        GetClass getClass = new GetClass();

        classDAO = getClass.getClassesById(request.getAttribute("id").toString());

        //Get assignments from DB
        GetAssignments getAssignments = new GetAssignments();

        List<Assignment> assignmentList = new ArrayList<>();

        request.setAttribute("cId", String.valueOf(classDAO.getId()));
        request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
        request.setAttribute("cName", classDAO.getcName());
        request.setAttribute("meetingTime", classDAO.getMeetingTime());

        request.setAttribute("fName", request.getAttribute("fName"));
        request.setAttribute("lName", request.getAttribute("lName"));
        request.setAttribute("id", request.getAttribute("userId"));

        //Go to class.jsp

        if(request.getAttribute("userId").toString().equals(String.valueOf(classDAO.getInstructorId()))){

            //Get students from DB
            GetEnrollments getEnrollments = new GetEnrollments();

            List<StudentEnrollment> enrollments = new ArrayList<>();
            enrollments = getEnrollments.getEnrollmentsByClassId(classDAO.getId());


            assignmentList = getAssignments.getAssignmentsByClassId((classDAO.getId()));


            //Set attributes
            request.setAttribute("assignments", assignmentList);
            request.setAttribute("enrollments", enrollments);
            request.getRequestDispatcher("/class.jsp").forward(request, response);
        }

        else{


            GetAssignments getSubAssignments = new GetAssignments();
            List<SubmitAssignment> SubmittedAssignmentList = new ArrayList<>();

            int uId = Integer.parseInt(request.getAttribute("userId").toString());

            SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), uId);
            assignmentList = getAssignments.getToDoAssignmentByClassId((classDAO.getId()), uId);

            request.setAttribute("marker", 1);
            request.setAttribute("assignments", assignmentList);
            request.setAttribute("submitted", SubmittedAssignmentList);


            request.getRequestDispatcher("/studentClass.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get class from DB
        ClassDAO classDAO;
        GetClass getClass = new GetClass();

        classDAO = getClass.getClassesById(request.getParameter("id"));

        //Get assignments from DB
        GetAssignments getAssignments = new GetAssignments();

        List<Assignment> assignmentList = new ArrayList<>();

        request.setAttribute("cId", String.valueOf(classDAO.getId()));
        request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
        request.setAttribute("cName", classDAO.getcName());
        request.setAttribute("meetingTime", classDAO.getMeetingTime());

        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("id", request.getParameter("userId"));

        //Go to class.jsp

        if(request.getParameter("userId").equals(String.valueOf(classDAO.getInstructorId()))){

            //Get students from DB
            GetEnrollments getEnrollments = new GetEnrollments();

            List<StudentEnrollment> enrollments = new ArrayList<>();
            enrollments = getEnrollments.getEnrollmentsByClassId(classDAO.getId());


            assignmentList = getAssignments.getAssignmentsByClassId((classDAO.getId()));


            //Set attributes
            request.setAttribute("assignments", assignmentList);
            request.setAttribute("enrollments", enrollments);
        request.getRequestDispatcher("/class.jsp").forward(request, response);
    }

        else{


            GetAssignments getSubAssignments = new GetAssignments();
            List<SubmitAssignment> SubmittedAssignmentList = new ArrayList<>();

            int uId = Integer.parseInt(request.getParameter("userId"));

            SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), uId);
            assignmentList = getAssignments.getToDoAssignmentByClassId((classDAO.getId()), uId);

            request.setAttribute("marker", 0);
            request.setAttribute("assignments", assignmentList);
            request.setAttribute("submitted", SubmittedAssignmentList);


            request.getRequestDispatcher("/studentClass.jsp").forward(request, response);
        }
    }

}
