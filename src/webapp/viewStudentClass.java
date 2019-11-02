package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "viewStudentClass")
public class viewStudentClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s1 = request.getParameter("fName");
        String s2 = request.getParameter("lName");
        String s3 = request.getParameter("studentId");
        String s4 = request.getParameter("id");
        String s5 = request.getParameter("cName");


        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("studentId", request.getParameter("studentId"));
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("cName", request.getParameter("cName"));


        //Go to class.jsp
        request.getRequestDispatcher("/studentClass.jsp").forward(request, response);

    }
}
