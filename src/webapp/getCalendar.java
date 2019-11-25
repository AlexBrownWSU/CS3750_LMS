package webapp;

import DAO.Entity.CalendarEvent;
import appLayer.GetCalendarEvents;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getCalendar")
public class getCalendar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get .jsp parameters
        String studentId = request.getParameter("studentId");

        //Calendar events
        GetCalendarEvents getCalendarEvents = new GetCalendarEvents();
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        calendarEvents = getCalendarEvents.getCalendarEvents(Integer.parseInt(studentId));
        String json = new Gson().toJson(calendarEvents);

        //Set .jsp attributes
        request.setAttribute("calendarEvents", json);
        request.setAttribute("studentId", studentId);
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("fName", request.getParameter("fName"));
        request.getRequestDispatcher("/calendar.jsp").forward(request, response);


    }
}
