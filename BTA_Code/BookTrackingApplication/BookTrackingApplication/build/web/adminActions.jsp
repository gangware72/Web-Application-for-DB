<%-- 
    Document   : adminActions
    Created on : Jan 9, 2015, 12:36:50 PM
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
        if(opt.equals("1"))
        {
            String redirect = request.getParameter("redirect");
            String redirectOpt = request.getParameter("redirectOpt");
            String key = request.getParameter("key");
            
            String query = "delete from users where idnumber='"+key+"'";
            JDBC obj = new JDBC();
            obj.createConnection();
            obj.updateRecord(query);
            obj.closeConnection();
            response.sendRedirect(redirect+"?opt="+redirectOpt+"&msg=Successfully Deleted.");            
            return;
        }
        
    }
        
%>      
