package webapp;

import DAO.ClassDAO;
import DAO.Entity.Assignment;
import DAO.Entity.SubmitAssignment;
import appLayer.GetAssignments;
import appLayer.GetClass;
import appLayer.SetSubmitAssignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MultipartConfig

@WebServlet(name = "submitAssignment")

public class submitAssignment extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String[] questions = request.getParameterValues("question");
        String[] answers = request.getParameterValues("response");


        String joinedAnswers = String.join(", ", answers);


        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        SubmitAssignment assignmentSubmission = new SubmitAssignment();


        assignmentSubmission.setaId(Integer.parseInt(request.getParameter("aId")));
        assignmentSubmission.setcId(Integer.parseInt(request.getParameter("cId")));
        assignmentSubmission.setsId(Integer.parseInt(request.getParameter("sId")));
        assignmentSubmission.setFileName(fileName);
        assignmentSubmission.setFile(fileContent);
        assignmentSubmission.setAnswers(joinedAnswers);



        //Set status as ungraded
        assignmentSubmission.setStatus(false);



        //Set submission date

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();


        assignmentSubmission.setSubmissionDate(dateFormat.format(date));


        SetSubmitAssignment submitAssignment = new SetSubmitAssignment();
        submitAssignment.submitAssignment(assignmentSubmission);



        //TODO: Completion



        ClassDAO classDAO;
        GetClass getClass = new GetClass();

        classDAO = getClass.getClassesById(request.getParameter("cId"));

        //Get assignments from DB
        GetAssignments getAssignments = new GetAssignments();

        List<Assignment> assignmentList = new ArrayList<>();

        request.setAttribute("cId", request.getParameter("cId"));
        request.setAttribute("instructorId", String.valueOf(classDAO.getInstructorId()));
        request.setAttribute("cName", classDAO.getcName());
        request.setAttribute("meetingTime", classDAO.getMeetingTime());

        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("id", request.getParameter("sId"));

        GetAssignments getSubAssignments = new GetAssignments();
        List<SubmitAssignment> SubmittedAssignmentList = new ArrayList<>();

        int uId = Integer.parseInt(request.getParameter("sId"));

        SubmittedAssignmentList = getSubAssignments.getSubmittedAssignments(classDAO.getId(), uId);
        assignmentList = getAssignments.getToDoAssignmentByClassId((classDAO.getId()), uId);

        request.setAttribute("assignments", assignmentList);
        request.setAttribute("submitted", SubmittedAssignmentList);

        request.getRequestDispatcher("/studentClass.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
