/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jarvis
 */
public class del_rec_serv extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            res.setContentType("text/html;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<html><body>");
            String email = req.getParameter("en");
            //out.println("0");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
            //out.println("1");
            String q = ("DELETE FROM stuinfo WHERE email = '" + email + "'");
            //out.println(q);
            PreparedStatement ps = con.prepareStatement(q);
            //out.println("3");
            int i = ps.executeUpdate();
            //out.println(email);

            out.println("<h3>Record deleted....</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("f_dashboard.jsp");
            rd.include(req, res);

            out.println("</body></html>");
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("f_dashboard.jsp");
            rd.include(req, res);
        }
    }
}
