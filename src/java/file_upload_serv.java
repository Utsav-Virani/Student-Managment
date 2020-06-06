
import java.io.*;
import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class file_upload_serv extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        try {
            out.println("<html><body>");
            MultipartRequest m = new MultipartRequest(req, "D:\\study\\A_Java\\student_manage\\e_content");
            String f_name = m.getOriginalFileName("file");
            //String f_path = "D:\\study\\A_Java\\student_manage\\e_content" + m.getOriginalFileName("file");
            //out.println(f1);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
            PreparedStatement ps = con.prepareStatement("INSERT INTO e_cont(f_name) VALUES(?)");
            ps.setString(1,f_name);
            ps.executeUpdate();
            
            out.print("<h3>successfully uploaded</h3>");
            out.println("</body></head>");
            RequestDispatcher rd = req.getRequestDispatcher("e_content.html");
            rd.include(req, res);

        } catch (Exception e) {
            res.sendRedirect("index.html");
        }
    }
}
