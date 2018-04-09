<%-- 
    Document   : Register
    Created on : Jan 8, 2015, 9:45:11 AM
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
    String grade = (String) session.getAttribute("grade");

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
    <body>
        <div class="container">
            <h1><%=ActivityHourSettings.projectTitle%></h1>
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2>&nbsp;<B><a href="index.jsp?msg=WelcomeBack">Home</a>&nbsp;&nbsp;&nbsp;<a href='Login.jsp'>Login</a><br /></B><br>                        
            <div id='other'>
                <form name="form4" method="post" action="issue.jsp"><br/>
                    <h2 align="center"><font color="blue"><br/>Issue Book</font></h2><h4 align="center"><font color="red"><%=msg%></font></h4>
                    <h3 align="right"><%=idnumber%><a href="logout.jsp">(logout)</a></h3>
                    <input type="hidden" id="usertype" name="usertype" value="" />
                    <table border="1" align="center" width="70%" height="80%">  
                        <tr>                            
                            <td>
                                <table border="0">
                                    <tr>
                                        <td><h2 align="center"><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BorrowerDetails</font></h2></td><td></td>
                                    </tr>

                                    <tr>
                                        <td>Students of Grade(<%=grade%>):</td>
                                        <td>
                                            <select name="memid">
                                                <%{
                                                        JDBC jdbc = new JDBC();
                                                        jdbc.createConnection();

                                                        String tableName = "users";

                                                        String query = "select idnumber,fullname from " + tableName.trim() + " where grade=" + grade.trim()+" and usertype='student'";
                                                        System.out.println(query);
                                                        ResultSet rsett = jdbc.queryRecord(query);
                                                        System.out.println(usertype);

                                                        while (rsett.next()) {
                                                            out.println("<option value='" + rsett.getString(1) + "'>" + rsett.getString(2) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h2 align="center"><font color="blue">BookDetails</h2></font>
                                        </td>
                                    <tr>
                                        <td>Books of Grade(<%=grade%>):</td>
                                        <td>

                                            <select name="bookid">
                                                <%{
                                                        JDBC jdbc = new JDBC();
                                                        jdbc.createConnection();

                                                        String tableName = "books";

                                                        String query = "select bid,title from " + tableName.trim() + " where grade=" + grade.trim() + " and noofcopies>0 and status=1";
                                                        System.out.println(query);
                                                        ResultSet rsett = jdbc.queryRecord(query);
                                                        System.out.println(usertype);

                                                        while (rsett.next()) {
                                                            out.println("<option value='" + rsett.getString(1) + "'>" + rsett.getString(2) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>

                                        </td>        
                                    </tr>                       
                                    <tr>
                                        <td></td><td><input type="submit" style="width:70px;" value="Issue" />
                                            <input type="reset" style="width:70px;" value="Reset"/>
                                        </td>
                                    </tr>
                                </table>
                                <div id="wrapper"> <div id="response"></div></div>
                            </td></tr></table>

                </form>
            </div>


        </div>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
            $.backstretch(["images/wall1.jpg"]);
            $(".other").backstretch("images/wall2.jpg");
        </script>
    </body>
</html>
