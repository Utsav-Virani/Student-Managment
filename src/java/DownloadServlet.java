import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class DownloadServlet extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
    try (PrintWriter out = response.getWriter()) {
        
        String filename = request.getParameter("filename");
        String filepath = "D:\\study\\A_Java\\student_manage\\e_content\\";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
        FileInputStream fileInputStream = new FileInputStream(filepath + filename);
        
        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
    }   
}  
  
}  