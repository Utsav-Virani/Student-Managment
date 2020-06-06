
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login_serv extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.setContentType("text/html;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<html><body>");
            String en = req.getParameter("en");
            String pwd = req.getParameter("pw");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
            String q = ("select * from stuinfo where en = " + en);
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if ((en.equals(rs.getString("en"))) & (pwd.equals(rs.getString("password"))) & (rs.getString("type")).equals("faculty")) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("en", en);
                    res.sendRedirect("f_dashboard_up");
                } else if ((en.equals(rs.getString("en"))) & (pwd.equals(rs.getString("password"))) & (rs.getString("type")).equals("student")) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("en", en);
                    res.sendRedirect("dashboard_up");
                } else {
                    out.println("you enterd incorrect detail ");
                    RequestDispatcher rd = req.getRequestDispatcher("index.html");
                    rd.include(req, res);
                }
            }
            out.println("</body></html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
