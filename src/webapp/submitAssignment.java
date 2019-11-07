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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;



@MultipartConfig
@WebServlet(name = "submitAssignment")
public class submitAssignment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String test = request.getParameter("test");

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission();

        //assignmentSubmission.setaId(Integer.parseInt(request.getParameter("aId")));
        assignmentSubmission.setcId(Integer.parseInt(request.getParameter("cId")));
        assignmentSubmission.setsId(Integer.parseInt(request.getParameter("sId")));
        assignmentSubmission.setFileName(fileName);
        assignmentSubmission.setFile(fileContent);

        SubmitAssignment submitAssignment = new SubmitAssignment();

        submitAssignment.submitAssignment(assignmentSubmission);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
