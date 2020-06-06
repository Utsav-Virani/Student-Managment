<%-- 
    Document   : s_e_content
    Created on : Aug 8, 2019, 8:04:27 AM
    Author     : Jarvis
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="index.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-content</title>
        <style>
            body{
                background: lightgray center/cover fixed;
                padding-top: 50px;
                height: auto;
                display: block;
                margin-left: auto;
                margin-right: auto;
            }
            button {
                background-color: #333;
                color: #ddd;
                font-size: 15px;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 3300px;
                border-radius:10px;
                margin-top: 20px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                left: 650px;
                transition: transform 1s;
            }

            /* Add a hover effect for buttons */
            button:hover {
                background-color: #333;
                transform: scale(1);
                cursor: pointer;
                opacity: 0.9;
            }
            
            .b{
                background-color: green;
                color: #ddd;
                font-size: 15px;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 200px;
                border-radius:10px;
                margin-top: 20px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top: 600px;
                left: 650px;
                transition: transform 1s;
            }

            /* Add a hover effect for buttons */
            .b:hover {
                background-color: #333;
                transform: scale(1);
                cursor: pointer;
                opacity: 0.9;
            }
            
        </style>
    </head>
    <body>
        <form action="DownloadServlet" method="post">
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanage", "root", "toor");
                PreparedStatement ps = con.prepareStatement("SELECT * FROM e_cont");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    //String fn = rs.getString(2).split("\\.")[0];
%>

            <br><br><br><button name="filename" value="<%= rs.getString(2)%>" > <%= rs.getString(2)%> </button>

            <%
                }
            %>
        </form>
        <form action="dashboard.jsp" method="post">
            <button class="b">BACK</button>
        </form>
    </body>
</html>
