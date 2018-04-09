<%-- 
    Document   : admin
    Created on : Jan 8, 2015, 12:50:40 PM
    Author     : 108
--%>

<%@page import="activity.ActivityHourSettings"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    String msg = request.getParameter("msg");
    msg = (msg == null ? "" : msg);

    String idnumber = (String) session.getAttribute("idnumber");
    String usertype = (String) session.getAttribute("usertype");

    if(usertype==null)
    {
        response.sendRedirect("index.jsp?msg=Session Expired.Please ReLogin");
        return;
    }
    
    if (usertype.equals("admin")) {

%>      


<html lang="en">
    <head>
        <meta charset="utf-8" />
        <style>
            body { font-family: Helvetica, Arial, sans-serif; line-height: 1.3em; -webkit-font-smoothing: antialiased; }
            .container {
                width: 90%;
                margin: 20px auto;
                background-color: #FFF;
                padding: 20px;
            }

            pre, code {
                font-family: Monaco, Menlo, Consolas, "Courier New", monospace;
                font-size: 12px;
                color: #333;
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                border-radius: 3px;
            }
            pre { border: 1px solid #CCC; background-color: #EEE; color: #333; padding: 10px; overflow: scroll; }
            code { padding: 2px 4px; background-color: #F7F7F9; border: 1px solid #E1E1E8; color: #D14; }

            .other { height: 300px; color: #FFF; }
            .other div {
                position: absolute;
                bottom: 0;
                width: 100%;
                background: #000;
                background: rgba(0,0,0,0.7);
            }
            .other div p { padding: 10px; }
        </style>
    </head>
    <body>
        <div class="container">
            <h1><%=ActivityHourSettings.projectTitle%></h1>
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2><br>
            <a href='Register.jsp'>Register Members</a><br />                       
            <a href='rBook.jsp'>Return Book</a><br />                       
            <a href='adminDataStore.jsp?opt=1'>Delete Students</a><br />                       
            <a href='adminDataStore.jsp?opt=2'>Delete Faculty</a><br />                       
            <a href='logout.jsp'>LogOut</a><br />           

            <div class="other">

            </div>

        </div>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
            $.backstretch(["images/wall1.jpg"]);
            $(".other").backstretch("images/db.jpg");
        </script>
    </body>
</html>

<%
    }
%>