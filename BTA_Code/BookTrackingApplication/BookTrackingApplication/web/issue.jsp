<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="activity.JDBC"%>
<%@page import="activity.ActivityHourSettings"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String msg = request.getParameter("msg");
    msg = (msg == null ? "" : msg);

    String idnumber = (String) session.getAttribute("idnumber");
    String usertype = (String) session.getAttribute("usertype");
    String grade = (String) session.getAttribute("grade");

    if (usertype == null) {
        out.println("Session Expired.Please ReLogin");
        return;
    }
    String opt = request.getParameter("opt");

    try {

        /**
         * *******Java Code For Retrieving Parameters*******
         */
        String bookid = request.getParameter("bookid");
        String memid = request.getParameter("memid");

        /**
         * *******SQL Insert Query*******
         */
        String query = "";
        query = "insert into issuebooks(bookid,memid,issuedate,duedate,status) values('" + bookid + "'  ,'" + memid + "'  ,now(),DATE_ADD(now(), INTERVAL " + ActivityHourSettings.dueDateDays + " DAY),false)";

        System.out.println("Insert Query : " + query);

        JDBC obj = new JDBC();
        obj.createConnection();

        obj.updateRecord(query);

        query = "update books set noofcopies=noofcopies-1 where bid='" + bookid + "'";
        System.out.println("Update Query : " + query);

        obj.updateRecord(query);

        obj.closeConnection();

        response.sendRedirect("faculty.jsp?msg=SuccessFully Issued");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("faculty.jsp?msg=E:" + e.toString());
    }
%>