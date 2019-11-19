package webapp;

import DAO.Entity.Question;
import appLayer.GetQuestion;
import appLayer.NewQuestion;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "addQuestion")
public class addQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> map = new HashMap<String, Object>();

        //Construct question object
        Question question = new Question();

        question.setQuestion(request.getParameter("question"));
        question.setqPoints(Integer.parseInt(request.getParameter("qPoints")));
        question.setaId(Integer.parseInt(request.getParameter("aId")));

        //Get a newQuestion instance and write question to db
        NewQuestion newQuestion = new NewQuestion();
        newQuestion.writeQuestionToDB(question);

        //Get questions
        //List<Question> questionList = new ArrayList<>();

        /*
        //Set request data
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("instructorId", request.getParameter("instructorId"));
        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));

        //Send request and response
        request.getRequestDispatcher("/viewClass").forward(request, response);
        */

        String json = new Gson().toJson(question);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get instance of GetQuestion
        GetQuestion getQuestion = new GetQuestion();

        //Call getQuestionByAId and return response
        String json = new Gson().toJson(getQuestion.getQuestionsByAId(request.getParameter("aId")));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
