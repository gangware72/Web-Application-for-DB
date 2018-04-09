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
                <FORM METHOD="POST" ACTION="saveBooks2.jsp">
                    <fieldset>
                        <legend>
                            <h3>Manual Books Specification</h3>                            
                            <B><a href="faculty.jsp?msg=WelcomeBack">Back</a></B>
                        </legend>
                        <p>                        
                        <TABLE BORDER="0">
                            <TR>
                                <TD><B>Book Title</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="t" SIZE="25">
                                </TD>
                            </TR>
                            <TR>
                                <TD><B>Author</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="a" SIZE="25">
                                </TD>
                            </TR>                            
                            <TR>
                                <TD><B>Published-Year</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="p" SIZE="25">
                                </TD>
                            </TR>
                            <TR>
                                <TD><B>Description</B></TD>
                                <TD>
                                    <textarea name='d' rows="2" cols="20"></textarea>
                                    <INPUT TYPE="hidden" NAME="i" value='none.jpg' SIZE="25">
                                    <INPUT TYPE="hidden" NAME="pre" value="NONE" SIZE="25">
                                </TD>
                            </TR>                            
                        </TABLE>
                        </p></fieldset>
                    <P><INPUT TYPE="SUBMIT" VALUE="Save Book Details" >&nbsp;&nbsp;<INPUT TYPE="Reset" VALUE="ClearDetails" ></P>
                </FORM>
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
