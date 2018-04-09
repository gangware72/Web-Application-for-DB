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
        String title = request.getParameter("t");
        String authors = request.getParameter("a");
        String pubDate = request.getParameter("p");
        String desc = request.getParameter("d");        
        String image = request.getParameter("i");;
        String preview = request.getParameter("pre");
        
        JDBC obj = new JDBC();
        String query = "insert into books(`title`,`author`,`yrpublished`,`desc`,`image`,`preview`,`grade`)";
        query += " values('"+title+"','"+authors+"','"+pubDate+"','"+desc+"','"+image+"','"+preview+"',"+grade+")";
        System.out.println(query);
        
        obj.createConnection();
        obj.updateRecord(query);        
        obj.closeConnection();
        
        response.sendRedirect("faculty.jsp?msg=Saved Books Record In DB");
    } catch (Exception e) {
        e.printStackTrace();        
        response.sendRedirect("faculty.jsp?msg=E:"+e.toString());
    }
%>