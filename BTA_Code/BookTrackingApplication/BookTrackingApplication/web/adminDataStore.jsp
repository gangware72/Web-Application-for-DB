<%-- 
    Document   : adminDataStore
    Created on : Jan 9, 2015, 12:02:52 PM
    Author     : 108
--%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="activity.JDBC"%>
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

    if (usertype == null) {
        response.sendRedirect("index.jsp?msg=Session Expired.Please ReLogin");
        return;
    }

    if (usertype.equals("admin")) {

        String opt = request.getParameter("opt");
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

        <script type="text/javascript" src="AjaxFramework.js"></script>
    </head>
    <body>
        <div class="container">
            <h1><%=ActivityHourSettings.projectTitle%></h1>
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2><br>
            <a href='admin.jsp'>Back</a><br />            
            <%
                if (opt.equals("1")) {
                    String query = "select * from users where usertype='student' order by grade asc";
                    String filteredColumns = "(3),(7)";
                    String keyColumn = "(1)";
                    String tableHeading = "Students Information To Update";
                    String actionUrl = "adminActions.jsp?opt=1&redirect=adminDataStore.jsp&redirectOpt=1";
                    String actionName = "Delete Student";
                    String result = ActivityHourSettings.updateTableUsers(query, filteredColumns, keyColumn, tableHeading, actionUrl, actionName);

                    out.println(result);

                }
            %>
            <%
                if (opt.equals("2")) {
                    String query = "select * from users where usertype='faculty' order by grade asc";
                    String filteredColumns = "(3),(7)";
                    String keyColumn = "(1)";
                    String tableHeading = "Faculty Information To Update";
                    String actionUrl = "adminActions.jsp?opt=1&redirect=adminDataStore.jsp&redirectOpt=1";
                    String actionName = "Delete Faculty";
                    String result = ActivityHourSettings.updateTableUsers(query, filteredColumns, keyColumn, tableHeading, actionUrl, actionName);

                    out.println(result);

                }
            %>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
            $.backstretch(["images/wall1.jpg"]);            
        </script>
    </body>
</html>

<%
    }
%>