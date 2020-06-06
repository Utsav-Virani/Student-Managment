/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jarvis
 */
public class mark_attendance_serv extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        try {
            out.println("<html><body>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
            /*String q = "select * from s_atten";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            String[] aa = new String[1000];
            float[] a = new float[1000];
            //-float[] at ;//= new float[100];
            while (rs.next()) {
                aa[i] = rs.getString(1);
                a[i] = rs.getFloat(3);
                i++;
            }*/

            String att[] = req.getParameterValues("box");
            for (int j = 0; j < att.length; j++) {
                String q2=("select * from s_atten where en ="+att[j]);
                PreparedStatement ps2 = con.prepareStatement(q2);
                ResultSet rs1 = ps2.executeQuery();
                rs1.next();
                float at=rs1.getFloat(3);
                at = (at+100/6)/2;
                String q1 = ("UPDATE s_atten SET attendance= " + at + " WHERE en=" + att[j]);
                PreparedStatement ps1 = con.prepareStatement(q1);
                ps1.executeUpdate();
                ps1.close();
            }
            out.println("Attendance marked...");
            RequestDispatcher rd = req.getRequestDispatcher("f_dashboard.jsp");
            rd.include(req, res);
            /*for (int j = 0; j < i; j++) {
                if (att[j].equals(aa[j])) {
                    a[j] = (a[j] + (100)) / 2;
                    String q1=("UPDATE s_atten SET attendance= "+a[j]+" WHERE en="+aa[j]);
                    PreparedStatement ps1 = con.prepareStatement(q1);
                    ps1.executeUpdate();
                    ps1.close();
                }
                else{
                    continue;
                }
            }*/
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
