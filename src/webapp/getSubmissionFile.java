package webapp;

import DAO.Entity.FileSubmission;
import appLayer.GetSubmissions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "getSubmissionFile")
public class getSubmissionFile extends HttpServlet {

    // size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GetSubmissions getSubmission = new GetSubmissions();

        //DownloadFile
        FileSubmission fileSubmission;

        fileSubmission = getSubmission.getSubmissionFile(request.getParameter("aId"), request.getParameter("sId"));
        /*InputStream inputStream = fileSubmission.getFileInput();

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
        String headerValue = String.format("attachment; filename=\"%s\"", fileSubmission.getFilename() + "\"");
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

        //Here

        FileInputStream fileInputStream = null;
        OutputStream responseOutputStream = null;
        try
        {

            String home = System.getProperty("user.home");

            File file = new File(home+"/Downloads/" + fileSubmission.getFilename());

            ServletContext context = getServletContext();

            String mimeType = context.getMimeType(fileSubmission.getFilename());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + fileSubmission.getFilename());
            response.setContentLength((int) file.length());

            fileInputStream = new FileInputStream(file);
            responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fileInputStream.close();
            responseOutputStream.close();
        }

    }
}
