package webapp;

import DAO.Entity.Assignment;
import DAO.Entity.Question;
import appLayer.GetAssignments;
import appLayer.GetQuestion;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "viewAssignment")
public class viewAssignment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
