package webapp;

import DAO.Entity.StudentEnrollment;
import appLayer.GetEnrollments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "enrollStudent")
public class enrollStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Set enrollment
        StudentEnrollment studentEnrollment = new StudentEnrollment();

        studentEnrollment.setsId(Integer.parseInt(request.getParameter("studentId")));
        studentEnrollment.setcId(Integer.parseInt(request.getParameter("cId")));

        GetEnrollments getEnrollments = new GetEnrollments();

        getEnrollments.setStudentEnrollment(studentEnrollment);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
