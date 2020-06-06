
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register_serv extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        try {
            PrintWriter out = res.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");

            res.setContentType("text/html;charset=UTF-8");

            String fn = req.getParameter("firstname");
            String ln = req.getParameter("lastname");
            String date = req.getParameter("bday");
            String password = req.getParameter("password");
            int en = Integer.parseInt(req.getParameter("enrollmentno"));
            String email = req.getParameter("emailid");
            String gen = req.getParameter("gender");
            String gender = (gen.equals("male") ? "male" : gen.equals("female") ? "female" : "");
            String address = req.getParameter("address");
            String city = req.getParameter("city");
            int pincode = Integer.parseInt(req.getParameter("pincode"));
            String state = req.getParameter("state");
            String typ = req.getParameter("type");
            String type = (typ.equals("student") ? "student" : typ.equals("faculty") ? "faculty" : "");
            String cou = req.getParameter("course");
            String course = (cou.equals("BE") ? "BE" : cou.equals("BBA") ? "BBA" : cou.equals("BSC") ? "BSC" : cou.equals("MBA") ? "MBA" : "");

            /*out.println(fn+"<br>"+ln+"<br>"+date+"<br>"+en+"<br>"+email+"<br>"+gender+"<br>"+
                    address+"<br>"+city+"<br>"+pincode+"<br>"+state+"<br>"+course+"<br>");*/
            //out.println("00");
            String q = "insert into stuinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //String q="SELECT * FROM stuinfo";
            PreparedStatement ps = con.prepareStatement(q);
            //out.println("01");
            ps.setInt(1, en);
            ps.setString(2, fn);
            ps.setString(3, ln);
            ps.setString(4, date);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, type);
            ps.setString(8, gender);
            ps.setString(9, address);
            ps.setString(10, city);
            ps.setInt(11, pincode);
            ps.setString(12, state);
            //out.println("11");
            ps.setString(13, course);
            //out.println("0");
            ps.execute();
            //out.println("1");

            /*while(rs.next()){
                out.println("<table><tr>"+"<td>"+rs.getInt("en")+"</td>"+"<td>"+rs.getString("fn")+"</td>"+
                    "<td>"+rs.getString("ln")+"</td>"+"<td>"+rs.getString("date")+"</td></tr></table>");
            }*/
            if (type.equals("student")) {
                String q2 = "insert into s_atten values(?,?,?)";
                PreparedStatement ps2 = con.prepareStatement(q2);
                ps2.setInt(1, en);
                ps2.setString(2, course);
                ps2.setInt(3, 0);
                ps2.execute();
            }
            out.println("<h2>Record inserted</h2>");
            out.println("</body></html>");
            RequestDispatcher rd = req.getRequestDispatcher("register.html");
            rd.include(req, res);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
