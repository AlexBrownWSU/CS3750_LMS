package webapp;

import DAO.Entity.AnswerSubmission;
import DAO.Entity.FileSubmission;
import DAO.Entity.Question;
import appLayer.GetSubmissions;
import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getSubmission")
public class getSubmission extends HttpServlet {

    // size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get instance of GetQuestion
        GetSubmissions getSubmission = new GetSubmissions();

        //Create list of type AnswerSubmission
        List<AnswerSubmission> answerSubmissions = new ArrayList<>();

        //Lists of answers & questions
        List<String> answers = getSubmission.getAs(request.getParameter("aId"), request.getParameter("sId"));
        List<Question> questions = getSubmission.getQs(request.getParameter("aId"));

        //Build an AnswerSubmission
        for (int i = 0; i < questions.size(); i++) {

            AnswerSubmission answerSubmission = new AnswerSubmission();
            answerSubmission.setAnswerSubmission(answers.get(i), questions.get(i).getQuestion(), questions.get(i).getqPoints());

            answerSubmissions.add(answerSubmission);
        }

        //getSubmission.getSubmissionFile(request.getParameter("aId"), request.getParameter("sId"));

        //DownloadFile
        /*FileSubmission fileSubmission;

        fileSubmission = getSubmission.getSubmissionFile(request.getParameter("aId"), request.getParameter("sId"));
        InputStream inputStream = fileSubmission.getFileInput();

        ServletContext context = getServletContext();

        // sets MIME type for the file download
        String mimeType = context.getMimeType(fileSubmission.getFilename());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        // set content properties and header attributes for the response
        response.setContentType(mimeType);
        response.setContentLength(fileSubmission.getFileLength());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileSubmission.getFilename());
        response.setHeader(headerKey, headerValue);

        // writes the file to the client
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        fileSubmission.getFileInput().close();
        outStream.close();*/

        //Call getQuestionByAId and return response
        //String json = new Gson().toJson(getSubmission.getSubmissionByAIdSId(request.getParameter("aId"), request.getParameter("sId")));

        String json = new Gson().toJson(answerSubmissions);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
