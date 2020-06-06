<%-- 
    Document   : deshbord
    Created on : Jul 31, 2019, 9:31:55 PM
    Author     : Jarvis
--%>

<%@ page import = "java.io.*,java.util.*,java.sql.*,java.sql.DriverManager;"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="index.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dashboard</title>
        <style type="text/css">
            body{
                background: white url('priscilla-du-preez-XkKCui44iM0-unsplash.jpg') center/cover fixed;
                padding-top: 50px;
                height: auto;
                display: block;
                margin-left: auto;
                margin-right: auto;
                width: 100%;
                height: auto;
            }

            .link {
                color: #D6130A; 
                background-color: transparent; 
                text-decoration: none;
                cursor: pointer;
                margin-top: 20px;
                margin-left: auto;
                margin-right: auto;
            }

            /* Style the top navigation bar */
            .link {
                overflow: hidden;
                background-color: #333;
            }

            /* Style the topnav links */
            .link a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            /* Change color on hover */
            .link a:hover {
                background-color: #ddd;
                color: black;
            }

            h1 {
                font-weight: bold;
                background-color: #333;
                padding: 20px;
                text-align: center;
                opacity: 0.6;
                color: #F4F6F7;
            }

            button {
                background-color: green;
                color: white;
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
                top: 159px;
                right: 50px;
                font-size: 14px;
            }

            /* Add a hover effect for buttons */
            button:hover {
                background-color: green;
                transform: scale(1.5);
                cursor: pointer;
                opacity: 0.9;
            }
        </style>
    </head>
    <body>
        <%
            int en = Integer.parseInt(session.getAttribute("en").toString());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
            String q = "select * from stuinfo where en = " + en;
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            rs.next();

            String name = rs.getString("fn");
            name = name.toUpperCase();

            String q1 = "select * from s_atten where en = " + en;
            PreparedStatement ps1 = con.prepareStatement(q1);
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            int a = rs1.getInt("attendance");
            //out.print(a);
        %>
        <h1 align="center">Welcome to Dashboard : <%= name%></h1>
        <form method="post">
            <div class="link">
                <!--<a href="s_attendance.html" >Attendance</a>-->
                <a href="IMG-20190817-WA0000.jpg" >Time Table</a>
                <a href="s_e_cont.jsp" >E-content</a>
                <a href="s_exam_details.jsp" >Exam Details</a>
                <a href="fees.jpg" >Fees</a>
            </div>
        </form>
        <div>
            <h2>Attendance : <%= a%></h2>
        </div>

        <form action="logout_up">
            <button>logout</button>
        </form>        
    </body>
</html>
