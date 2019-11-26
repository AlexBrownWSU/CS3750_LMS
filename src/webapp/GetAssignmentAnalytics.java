package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import appLayer.getAssignmentAnalytics;
import com.google.gson.Gson;

@WebServlet(name = "GetAssignmentAnalytics")
public class GetAssignmentAnalytics extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getAssignmentAnalytics getAssignmentAnalytics = new getAssignmentAnalytics();

        String json = new Gson().toJson(getAssignmentAnalytics.getAnalytics(request.getParameter("aId"),request.getParameter("cId"),request.getParameter("sId")));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
