package webapp;

import appLayer.NewClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addClass")
public class addClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NewClass newClass = new NewClass();

        //Set Parameters
        /*request.setAttribute("cName", request.getParameter("cName"));
        request.setAttribute("dateTime", request.getParameter("dateTime"));
        request.setAttribute("instructorId", request.getParameter("instructorId"));*/

        String dateTime = buildDateTime(
                request.getParameter("sunday"),
                request.getParameter("monday"),
                request.getParameter("tuesday"),
                request.getParameter("wednesday"),
                request.getParameter("thursday"),
                request.getParameter("friday"),
                request.getParameter("saturday"),
                request.getParameter("time"),
                request.getParameter("ampm")
                );

        newClass.writeClassToDB(
                request.getParameter("cName"),
                //request.getParameter("dateTime"),
                dateTime,
                request.getParameter("instructorId")
        );

        //request.getRequestDispatcher("/userLandingPage.jsp").forward(request, response);

        //Set request data
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("password", request.getParameter("password"));

        String u = request.getParameter("username");
        String p = request.getParameter("password");


        //Send request and response
        request.getRequestDispatcher("/login").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String buildDateTime(String sun, String mon, String tue, String wed, String thu, String fri, String sat, String time, String ampm) {

        String ss = "";
        String m = "";
        String t = "";
        String w = "";
        String th = "";
        String f = "";
        String s = "";

        if (sun != null) {
            ss = sun;
        }

        if (mon != null) {
            m = mon;
        }

        if (tue != null) {
            t = tue;
        }

        if (wed != null) {
            w = wed;
        }

        if (thu != null) {
            th = thu;
        }

        if (fri != null) {
            f = fri;
        }

        if (sat != null) {
            s = sat;
        }

        return ss + m + t + w + th + f + s + " " + time + " " + ampm;
    }
}
