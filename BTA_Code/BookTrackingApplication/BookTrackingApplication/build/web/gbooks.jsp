<%-- 
    Document   : faculty
    Created on : Jan 8, 2015, 12:50:50 PM
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

    if (usertype == null) {
        response.sendRedirect("index.jsp?msg=Session Expired.Please ReLogin");
        return;
    }

    if (usertype.equals("faculty")) {

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
        <script src="AjaxFramework.js"></script>
        
        <script type="text/javascript">
            function show_books() {

                var book_name = document.getElementById('book_name').value;

                var author_name = document.getElementById('author_name').value;
                var isbn_number = document.getElementById('isbn_number').value;
                var filter_type = document.getElementById('filter_type').value;
                if (book_name == "") {
                    alert("Please enter the name of the book you are looking for");
                }
                else {
                    if (window.XMLHttpRequest)
                    {// code for IE7+, Firefox, Chrome, Opera, Safari
                        xmlhttp = new XMLHttpRequest();
                    }
                    else
                    {// code for IE6, IE5
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    xmlhttp.onreadystatechange = function ()
                    {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                        {
                            document.getElementById("content").innerHTML = xmlhttp.responseText;
                        }
                    }
                    xmlhttp.open("POST", "GBAPI", true);
                    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xmlhttp.send("book_name=" + book_name + "&author_name=" + author_name + "&isbn_number=" + isbn_number + "&filter_type=" + filter_type);
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1><%=ActivityHourSettings.projectTitle%></h1>
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2><br>                       
            <a href='logout.jsp'>LogOut</a><br />           

            
                <div id="bar">
                    <h3>Find a book through Google Books API:</h3>
                    <label>The name of the book: </label>
                    <input type="text" name="book_name" id="book_name" maxlength="50"/><br>
                    <!--label>The author of the book: </label-->
                    <input type="hidden" name="author" maxlength="50" id="author_name"/><br>
                    <!--label>ISBN number if you know: </label-->
                    <input type="hidden" name="isbn" maxlength="50" id="isbn_number"/><br>
                    <!--label>Filter the result by the type of book:</label-->
                    <!--select size="1" name="filter_type" id="filter_type">
                        <option value="partial">partial</option>
                        <option value="full">full</option>
                        <option value="free-ebooks">free-ebooks</option>
                        <option value="paid-ebooks">paid-ebooks</option>
                        <option value="ebooks">ebooks</option>
                    </select><br-->
                    <input type="hidden" name="filter_type" maxlength="50" id="filter_type" value='partial' /><br>
                    <input type="button" name="submit" value="SUBMIT" style="cursor:pointer" onclick="show_books()" />

                </div>
                <div id="content">
                </div>
            

        </div>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        
    </body>
</html>

<%
    }
%>