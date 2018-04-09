<%-- 
    Document   : Login
    Created on : Jan 8, 2015, 12:31:28 PM
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

        <style type="text/css">
            .box{
                padding: 20px;
                display: none;
                margin-top: 20px;
                border: 1px solid #000;
            }
            .student{ background: greenyellow; }
            .faculty{ background: olive; }
            .admin{ background: gray; }
        </style>
        <script type="text/javascript" src="js/jquery.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('input[type="radio"]').click(function() {
                    if ($(this).attr("value") == "student") {
                        $(".box").hide();
                        $(".student").show();
                    }
                    if ($(this).attr("value") == "faculty") {
                        $(".box").hide();
                        $(".faculty").show();
                    }
                    if ($(this).attr("value") == "admin") {
                        $(".box").hide();
                        $(".admin").show();
                    }
                });
            });
        </script>

    </head>
    <body>
        <div class="container">
            <h1><%=ActivityHourSettings.projectTitle%></h1>&nbsp;<B><a href="index.jsp?msg=WelcomeBack">Home</a></B><br>            
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2><br>            
            <div>                
                <label><input type="radio" name="colorRadio" value="student">Student</label>                            
                <label><input type="radio" name="colorRadio" value="faculty">Faculty</label>                            
                <label><input type="radio" name="colorRadio" value="admin">Admin</label>                            
            </div>
          
            <div class="student box">
                <FORM METHOD="POST" ACTION="UserValidationServlet">
                    <fieldset>
                        <legend>
                            <h3>Student Login Form</h3>                            
                            <B><a href="index.jsp?msg=WelcomeBack">Home</a></B>
                        </legend>
                        <p>                        
                        <TABLE BORDER="0">
                            <TR>
                                <TD><B>ID Number</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="idnumber" SIZE="25">
                                </TD>
                            </TR>                                                       
                            <TR>
                                <TD><B>Password</B></TD>
                                <TD><INPUT TYPE="password" NAME="password" SIZE="25"></TD>
                            </TR>
                            <TR>
                                <TD><B></B></TD>
                                <TD><INPUT TYPE="hidden" NAME="usertype" value="student" SIZE="25"><INPUT TYPE="hidden" NAME="redirect" value="Login.jsp?msg=" SIZE="25"></TD>
                            </TR>
                        </TABLE>
                        </p></fieldset>
                    <P><INPUT TYPE="SUBMIT" VALUE="Student-Login" >&nbsp;&nbsp;<INPUT TYPE="Reset" VALUE="ClearDetails" ></P>
                </FORM>
            </div>
            
            <div class="faculty box">
                <FORM METHOD="POST" ACTION="UserValidationServlet">
                    <fieldset>
                        <legend>
                            <h3>Faculty Login Form</h3>                            
                            <B><a href="index.jsp?msg=WelcomeBack">Home</a></B>
                        </legend>
                        <p>                        
                        <TABLE BORDER="0">
                            <TR>
                                <TD><B>ID Number</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="idnumber" SIZE="25">
                                </TD>
                            </TR>                                                       
                            <TR>
                                <TD><B>Password</B></TD>
                                <TD><INPUT TYPE="password" NAME="password" SIZE="25"></TD>
                            </TR>
                            <TR>
                                <TD><B></B></TD>
                                <TD><INPUT TYPE="hidden" NAME="usertype" value="faculty" SIZE="25"><INPUT TYPE="hidden" NAME="redirect" value="Login.jsp?msg=" SIZE="25"></TD>
                            </TR>
                        </TABLE>
                        </p></fieldset>
                    <P><INPUT TYPE="SUBMIT" VALUE="Faculty-Login" >&nbsp;&nbsp;<INPUT TYPE="Reset" VALUE="ClearDetails" ></P>
                </FORM>
            </div>
            
            <div class="admin box">
                <FORM METHOD="POST" ACTION="UserValidationServlet">
                    <fieldset>
                        <legend>
                            <h3>Admin Login Form</h3>                            
                            <B><a href="index.jsp?msg=WelcomeBack">Home</a></B>
                        </legend>
                        <p>                        
                        <TABLE BORDER="0">
                            <TR>
                                <TD><B>Username</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="idnumber" SIZE="25">
                                </TD>
                            </TR>                                                       
                            <TR>
                                <TD><B>Password</B></TD>
                                <TD><INPUT TYPE="password" NAME="password" SIZE="25"></TD>
                            </TR>
                            <TR>
                                <TD><B></B></TD>
                                <TD><INPUT TYPE="hidden" NAME="usertype" value="admin" SIZE="25"><INPUT TYPE="hidden" NAME="redirect" value="Login.jsp?msg=" SIZE="25"></TD>
                            </TR>
                        </TABLE>
                        </p></fieldset>
                    <P><INPUT TYPE="SUBMIT" VALUE="Admin-Login" >&nbsp;&nbsp;<INPUT TYPE="Reset" VALUE="ClearDetails" ></P>
                </FORM>
            </div>

        </div>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
            $.backstretch(["images/wall2.jpg"]);
            $(".other").backstretch("images/db.jpg");
        </script>
    </body>
</html>