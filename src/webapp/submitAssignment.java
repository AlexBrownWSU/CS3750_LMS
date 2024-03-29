package webapp;

import DAO.Entity.AssignmentSubmission;
import appLayer.SubmitAssignment;

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
import java.util.Date;


@MultipartConfig
@WebServlet(name = "submitAssignment")
public class submitAssignment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO: Error / null checking

        String[] answers = request.getParameterValues("response");
        String joinedAnswers = "";

        if (null != answers) {
            joinedAnswers = String.join(", ", answers);
        }

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission();

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

        //Params to call page


        SubmitAssignment submitAssignment = new SubmitAssignment();
        submitAssignment.submitAssignment(assignmentSubmission);

        //TODO: Completion reload page to update tables
        //request.getRequestDispatcher("/studentClass.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
