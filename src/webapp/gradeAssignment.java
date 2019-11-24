package webapp;

import DAO.Entity.GradedSubmission;
import appLayer.GradeAssignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "gradeAssignment")
public class gradeAssignment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int gradeTotal = 0;
        String[] grades = request.getParameterValues("grade");
        String fileGrade = request.getParameter("fileGrade");

        int submissionId = Integer.parseInt(request.getParameter("submissionId"));

        for(int i = 0; i < grades.length; i++) {
            gradeTotal += Integer.parseInt(grades[i]);
        }

        gradeTotal += Integer.parseInt(fileGrade);

        int x = Integer.parseInt(request.getParameter("aId"));
        int y = Integer.parseInt(request.getParameter("sId"));

        GradedSubmission gradedSubmission = new GradedSubmission();
        gradedSubmission.setGrade(Integer.parseInt(request.getParameter("aId")),
                Integer.parseInt(request.getParameter("sId")),
                submissionId,
                gradeTotal);

        GradeAssignment gradeAssignment = new GradeAssignment();
        gradeAssignment.gradeAssignment(gradedSubmission);

        gradeAssignment.updateSubmissionStatus(submissionId);

        //TODO: Update status
        //TODO: Stop hiding modal div after submit

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
