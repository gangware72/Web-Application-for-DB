<%-- 
    Document   : index
    Created on : Jan 8, 2015, 9:15:39 AM
    Author     : svuzzini
--%>

<%@page import="activity.ActivityHourSettings"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
     // contextPath
    ServletContext context = session.getServletContext();
    ActivityHourSettings.setContext(context);
    /////////////
    
    String msg = request.getParameter("msg");
    msg = (msg == null ? "" : msg);
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
        
        <h1><%=ActivityHourSettings.projectTitle%></h1>
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2><br>
            <a href='Login.jsp'>Login</a><br />           

        <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
            $.backstretch(["images/wall1.jpg"]);
            $(".other").backstretch("images/db.jpg");
        </script>
    </body>
</html>