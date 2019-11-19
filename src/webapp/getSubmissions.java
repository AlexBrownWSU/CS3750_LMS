package webapp;

import appLayer.GetSubmissions;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getSubmissions")
public class getSubmissions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get instance of GetQuestion
        GetSubmissions getSubmissions = new GetSubmissions();

        //Call getQuestionByAId and return response
        String json = new Gson().toJson(getSubmissions.getSubmissionsByAId(request.getParameter("aId")));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
