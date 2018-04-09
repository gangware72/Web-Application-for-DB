<%-- 
    Document   : dataStore
    Created on : Jan 8, 2015, 3:04:25 PM
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

    if (usertype.equals("faculty")) {

        String opt = request.getParameter("opt");
%>      


<html lang="en">
    <head>
        <meta charset="utf-8" />

        <link rel="stylesheet" media="all" type="text/css" href="datetime/jquery-ui.css" />
        <link rel="stylesheet" media="all" type="text/css" href="datetime/jquery-ui-timepicker-addon.css" />

        <script type="text/javascript" src="datetime/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="datetime/jquery-ui.min.js"></script>
        <script type="text/javascript" src="datetime/jquery-ui-timepicker-addon.js"></script>
        <script type="text/javascript" src="datetime/jquery-ui-timepicker-addon-i18n.min.js"></script>
        <script type="text/javascript" src="datetime/jquery-ui-sliderAccess.js"></script>


        <script type="text/javascript" src="AjaxFramework.js"></script>        

    </head>
    <body>
        <div class="container">
            <h1><%=ActivityHourSettings.projectTitle%></h1>
            <h2><font face="Comic Sans MS" color="pink"><%=msg%></font></h2><br>
            <a href='faculty.jsp'>Back</a><br />            
            <%
                if (opt.equals("1")) {
            %>
            <div class="other">
                <FORM METHOD="POST" ACTION="DataStoreServlet">
                    <fieldset>
                        <legend>
                            <h3>Subject Details Specification</h3>                            

                        </legend>
                        <p>                        
                        <TABLE BORDER="0">
                            <TR>
                                <TD><B>Department</B></TD>
                                <TD>
                                    <select id="dept_id" name="dept_id" onKeyUp="getDeptDetails(this)"  onChange="getDeptDetails(this)" >
                                        <option value='none'>Select A Department</option>
                                        <%
                                            try {

                                                JDBC obj = new JDBC();
                                                String query = "SELECT name,dept_id FROM department";
                                                obj.createConnection();
                                                ResultSet rset = obj.queryRecord(query);

                                                ResultSetMetaData rsmd = rset.getMetaData();
                                                int numColumns = rsmd.getColumnCount();

                                                String resultHtml = "";

                                                boolean found = rset.next();
                                                //out.println("<br><b>Sql Result</b>+"+query+"==>"+found);
                                                if (found) {
                                                    rset.last();
                                                    int count = rset.getRow();
                                                    int row = 0;
                                                    String line = "";
                                                    rset.beforeFirst();
                                                    while (rset.next()) {
                                                        resultHtml += "<option value='" + rset.getString(2) + "'>" + rset.getString(1) + "</option>";
                                                    }
                                                }
                                                out.println(resultHtml);
                                                obj.closeConnection();
                                            } catch (Exception e) {
                                                out.println("<br /><b>Exception : " + e.toString() + "</b>");
                                            }
                                        %>
                                    </select>
                                </TD>
                            </TR>
                            <TR>
                                <TD><B>Section</B></TD>
                                <TD>
                                    <select id="sec_id" name="sec_id" >
                                        <option value='none'>Select A Section</option>
                                        <%
                                            try {

                                                JDBC obj = new JDBC();
                                                String query = "SELECT sid,sname FROM sections";
                                                obj.createConnection();
                                                ResultSet rset = obj.queryRecord(query);

                                                ResultSetMetaData rsmd = rset.getMetaData();
                                                int numColumns = rsmd.getColumnCount();

                                                String resultHtml = "";

                                                boolean found = rset.next();
                                                //out.println("<br><b>Sql Result</b>+"+query+"==>"+found);
                                                if (found) {
                                                    rset.last();
                                                    int count = rset.getRow();
                                                    int row = 0;
                                                    String line = "";
                                                    rset.beforeFirst();
                                                    while (rset.next()) {
                                                        resultHtml += "<option value='" + rset.getString(1) + "'>" + rset.getString(2) + "</option>";
                                                    }
                                                }
                                                out.println(resultHtml);
                                                obj.closeConnection();
                                            } catch (Exception e) {
                                                out.println("<br /><b>Exception : " + e.toString() + "</b>");
                                            }
                                        %>
                                    </select>
                                </TD>
                            </TR>
                            <TR>
                                <TD><B>Subject Name</B></TD>
                                <TD>
                                    <INPUT TYPE="TEXT" NAME="subjectName" SIZE="25">
                                </TD>
                            </TR>                                                     
                            <TR>
                                <TD><B>Year</B></TD>
                                <TD><%=ActivityHourSettings.getYearOfStudy()%></TD>
                            </TR>
                            <TR>
                                <TD><B>Semester</B></TD>
                                <TD><%=ActivityHourSettings.getSemesterOfStudy()%><INPUT TYPE="hidden" NAME="option" value="1" SIZE="25"><INPUT TYPE="hidden" NAME="redirect" value="dataStore.jsp?msg=" SIZE="25"></TD>
                            </TR>                           
                        </TABLE>
                        </p></fieldset>
                    <P><INPUT TYPE="SUBMIT" VALUE="Save Subject Details" >&nbsp;&nbsp;<INPUT TYPE="Reset" VALUE="ClearDetails" ></P>
                </FORM>
            </div>
                            
            <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
            $.backstretch(["images/2.jpg"]);
        </script>
        
                            
            <%
                }
            %>

            <%
                if (opt.equals("2")) {
            %>

            <div>
                <FORM METHOD="POST" ACTION="DataStoreServlet">
                    <fieldset>
                        <legend>
                            <h3>Book Room</h3>                            

                        </legend>
                        <p>  

                        <TABLE BORDER="0">                            
                            <TR>
                                <TD><B>Building</B></TD>
                                <TD>
                                    <select id="bid" name="bid" onKeyUp="getRoomDetails(this)"  onChange="getRoomDetails(this)">
                                        <option value='none'>Select A Building</option>
                                        <%
                                            try {

                                                JDBC obj = new JDBC();
                                                String query = "SELECT bid,bname FROM buildings";
                                                obj.createConnection();
                                                ResultSet rset = obj.queryRecord(query);

                                                ResultSetMetaData rsmd = rset.getMetaData();
                                                int numColumns = rsmd.getColumnCount();

                                                String resultHtml = "";

                                                boolean found = rset.next();
                                                //out.println("<br><b>Sql Result</b>+"+query+"==>"+found);
                                                if (found) {
                                                    rset.last();
                                                    int count = rset.getRow();
                                                    int row = 0;
                                                    String line = "";
                                                    rset.beforeFirst();
                                                    while (rset.next()) {
                                                        resultHtml += "<option value='" + rset.getString(1) + "'>" + rset.getString(2) + "</option>";
                                                    }
                                                }
                                                out.println(resultHtml);
                                                obj.closeConnection();
                                            } catch (Exception e) {
                                                out.println("<br /><b>Exception : " + e.toString() + "</b>");
                                            }
                                        %>
                                    </select>
                                </TD>
                            </TR>                                                                                 
                            <TR id='bid_r'>                                
                            </TR>
                            <TR>
                                <TD><B>Year</B></TD>
                                <TD><%=ActivityHourSettings.getYearOfStudy()%></TD>
                            </TR>
                            <TR>
                                <TD><B>Semester</B></TD>
                                <TD><%=ActivityHourSettings.getSemesterOfStudy()%><INPUT TYPE="hidden" NAME="option" value="2" SIZE="25"><INPUT TYPE="hidden" NAME="redirect" value="dataStore.jsp?msg=" SIZE="25"></TD>
                            </TR>
                            <TR>
                                <TD><B>Department</B></TD>
                                <TD>
                                    <select id="dept_id" name="dept_id" onKeyUp="getSubDet('dept_id', 'sec_id', 'year', 'semester')"  onChange="getSubDet('dept_id', 'sec_id', 'year', 'semester')" >
                                        <option value='none'>Select A Department</option>
                                        <%
                                            try {

                                                JDBC obj = new JDBC();
                                                String query = "SELECT name,dept_id FROM department";
                                                obj.createConnection();
                                                ResultSet rset = obj.queryRecord(query);

                                                ResultSetMetaData rsmd = rset.getMetaData();
                                                int numColumns = rsmd.getColumnCount();

                                                String resultHtml = "";

                                                boolean found = rset.next();
                                                //out.println("<br><b>Sql Result</b>+"+query+"==>"+found);
                                                if (found) {
                                                    rset.last();
                                                    int count = rset.getRow();
                                                    int row = 0;
                                                    String line = "";
                                                    rset.beforeFirst();
                                                    while (rset.next()) {
                                                        resultHtml += "<option value='" + rset.getString(2) + "'>" + rset.getString(1) + "</option>";
                                                    }
                                                }
                                                out.println(resultHtml);
                                                obj.closeConnection();
                                            } catch (Exception e) {
                                                out.println("<br /><b>Exception : " + e.toString() + "</b>");
                                            }
                                        %>
                                    </select>
                                </TD>
                            </TR> 
                            <TR>
                                <TD><B>Section</B></TD>
                                <TD>
                                    <select id="sec_id" name="sec_id" onKeyUp="getSubDet('dept_id', 'sec_id', 'year', 'semester')"  onChange="getSubDet('dept_id', 'sec_id', 'year', 'semester')" >
                                        <option value='none'>Select A Section</option>
                                        <%
                                            try {

                                                JDBC obj = new JDBC();
                                                String query = "SELECT sid,sname FROM sections";
                                                obj.createConnection();
                                                ResultSet rset = obj.queryRecord(query);

                                                ResultSetMetaData rsmd = rset.getMetaData();
                                                int numColumns = rsmd.getColumnCount();

                                                String resultHtml = "";

                                                boolean found = rset.next();
                                                //out.println("<br><b>Sql Result</b>+"+query+"==>"+found);
                                                if (found) {
                                                    rset.last();
                                                    int count = rset.getRow();
                                                    int row = 0;
                                                    String line = "";
                                                    rset.beforeFirst();
                                                    while (rset.next()) {
                                                        resultHtml += "<option value='" + rset.getString(1) + "'>" + rset.getString(2) + "</option>";
                                                    }
                                                }
                                                out.println(resultHtml);
                                                obj.closeConnection();
                                            } catch (Exception e) {
                                                out.println("<br /><b>Exception : " + e.toString() + "</b>");
                                            }
                                        %>
                                    </select>
                                </TD>
                            </TR>
                            <TR id='sub_dyn'>                                
                            </TR>   
                            <TR>
                                <TD><B>Choose Start Date Time</B></TD>
                                <TD><div class="example-container"><input type="text" name="don1" id="don1" value="" /><pre></pre></div></TD>
                            </TR>
                            <TR>
                                <TD><B>Choose End Date Time</B></TD>
                                <TD><div class="example-container2"><input type="text" name="don2" id="don2" value="" /><pre></pre></div></TD>
                            </TR>
                        </TABLE>                        
                        </p></fieldset>

                          

                    <P><input type="button" onclick="checkRoom('dept_id', 'sec_id', 'year', 'semester', 'don1', 'don2', 'rid')" value="Check Availability">&nbsp;&nbsp;<INPUT TYPE="SUBMIT" VALUE="Save Room Details" >&nbsp;&nbsp;<INPUT TYPE="Reset" VALUE="ClearDetails" ></P>                    
                </FORM>



            </div>      
                                    
                    <script type="text/javascript">

                        $(function () {
                            $('.example-container > pre').each(function (i) {
                                eval("$('#don1').datetimepicker();");
                            });

                            $('.example-container2 > pre').each(function (i) {
                                eval("$('#don2').datetimepicker();");
                            });
                        });
            </script>     
                                    
                   <script src="js/jquery.js"></script>
        <script src="js/jquery.backstretch.js"></script>
        <script>
                        $.backstretch(["images/1.JPG"]);
            </script>
                                    
            <%
                }
            %>

        </div>
        <div id='dept_id_r' style="width: 600px; height: 500px; overflow-y: auto;"></div>        
        
        
        
    </body>
</html>

<%
    }
%>