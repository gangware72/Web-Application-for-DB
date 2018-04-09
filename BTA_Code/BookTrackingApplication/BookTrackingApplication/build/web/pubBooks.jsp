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
    
    String opt = request.getParameter("opt");
    String id = request.getParameter("id");

    try {        
        JDBC obj = new JDBC();
        String q = "update books set status="+opt+" where bid="+id+" and grade="+grade;        
        System.out.println(q);
        
        obj.createConnection();
        obj.updateRecord(q);        
        obj.closeConnection();
        
        response.sendRedirect("head.jsp?msg=Published Books Record In DB");
    } catch (Exception e) {
        e.printStackTrace();        
        response.sendRedirect("head.jsp?msg=E:"+e.toString());
    }
%>