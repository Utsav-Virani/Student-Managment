<%-- 
    Document   : f_dashboard
    Created on : Aug 4, 2019, 11:00:53 PM
    Author     : Jarvis
--%>

<%@ page import = "java.io.*,java.util.*,java.sql.*,java.sql.DriverManager;"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page errorPage="index.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dashboard</title>
        <style type="text/css">
            body{
                background: white url('andrew-neel-cckf4TsHAuw-unsplash.jpg') center/cover fixed;
                padding-top: 50px;
                height: auto;
                display: block;
                margin-left: auto;
                margin-right: auto;
            }
            h1 {
                font-weight: bold;
                background-color: #333;
                padding: 20px;
                text-align: center;
                opacity: 0.6;
                color: #F4F6F7;
            }
            h3 {
                font-weight: bold;
                padding: 20px;
                text-align: center;
                opacity: 0.6;
                font-size: 25px;
                color: #F4F6F7;
            }

            button {
                background-color: #A0A4A5;
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
                font-size: 14px;
            }

            /* Add a hover effect for buttons */
            button:hover {
                background-color: #A0A4A5;
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
        %>
        <h1 align="center">Welcome to Dashboard : <%= name%></h1>
        <div align="center">
            <form action="register.html" method="post">
                <button>Insert Record</button>
            </form>
            <form action="delete_record.html" method="post">
                <button>Delete Record</button>
            </form>
            <form action="e_content.html" method="post">
                <button>E-Content</button>
            </form>
            <form action="attendance.jsp" method="post">
                <button>Attendance</button>
            </form>
            <form action="logout_up">
                <button>logout</button>
            </form>
        </div>
    </body>

</html>
