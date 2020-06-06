<%-- 
    Document   : attendance
    Created on : Aug 8, 2019, 8:02:13 AM
    Author     : Jarvis
--%>

<%@ page import = "java.sql.*"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="index.html" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance</title>
        <style type="text/css">
            .bb1 {
                background-color: green;
                color: black;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 200px;
                border-radius:10px;
                margin-top: 20px;
                margin-left: auto;
                margin-right: auto;
                transition: transform 1s;
                opacity: 0.8;
                position: absolute;
                font-size: 14px;
                top: 600px;
                left: 680px ;
            }

            /* Add a hover effect for buttons */
            .bb1:hover {
                background-color: green;
                transform: scale(1.3);
                cursor: pointer;
                opacity: 0.8;
            }

            .b {
                background-color: green;
                color: black;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 200px;
                border-radius:10px;
                margin-top: 20px;
                margin-left: auto;
                margin-right: auto;
                transition: transform 1s;
                opacity: 0.8;
                position: absolute;
                font-size: 14px;
                top: 400px;
                left: 680px ;
            }

            /* Add a hover effect for buttons */
            .b:hover {
                background-color: green;
                transform: scale(1.3);
                cursor: pointer;
                opacity: 0.8;
            }

            table {
                border-collapse: collapse;
                width: 100px;
                position: absolute;
                top: 200px;
                left: 720px ;
            }

            tr{
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <form method="post" action="mark_attendance_up">
            <%
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
                    String q = "select * from s_atten";
                    PreparedStatement ps = con.prepareStatement(q);
                    ResultSet rs = ps.executeQuery();
                    int i = 0;

                    String[] aa = new String[100];
                    float[] a = new float[100];
                    while (rs.next()) {
                        aa[i] = rs.getString(1);
                        a[i] = rs.getFloat(3);
                        i++;
                    }

                    out.println("<table>");
                    for (int j = 0; j < i; j++) {
                        out.println("<tr><td><input type='checkbox' name ='box' value='" + aa[j] + "'>" + aa[j] + "</td></tr>");
                    }
                    /*
                    for (int j = 0; j < i; j++) {
                        out.println("<br><br>" + a[j]);
                        out.println("<br>" + aa[j]);
                    }
                    
                    for (int j = 0; j < i; j++) {
                        a[j] = (a[j]+(100/6))/2;
                        out.println("<br>   " + a[j]);
                    }*/
                    out.println("</table>");
                    out.println("</body></head>");
                } catch (Exception e) {
                    out.println(e);
                }
            %>
            <button class="b">SUBMIT</button>
        </form>

        <form method="post" action="f_dashboard.jsp">
            <button class="bb1">BACK</button>
        </form>

    </body>
</html>