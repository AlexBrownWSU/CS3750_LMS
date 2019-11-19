package webapp;

import DAO.Entity.AnswerSubmission;
import DAO.Entity.Question;
import appLayer.GetSubmissions;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getSubmission")
public class getSubmission extends HttpServlet {
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

        //Call getQuestionByAId and return response
        //String json = new Gson().toJson(getSubmission.getSubmissionByAIdSId(request.getParameter("aId"), request.getParameter("sId")));

        String json = new Gson().toJson(answerSubmissions);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
