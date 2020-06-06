/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jarvis
 */
public class dashboard_serv extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session != null) {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        } else {
            response.sendRedirect("index.html");
        }

        pr.close();
    }
}
