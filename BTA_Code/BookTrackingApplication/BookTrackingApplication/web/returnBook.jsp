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

    String sid = request.getParameter("sid");
    String bid = request.getParameter("id");
    
    
    String opt = request.getParameter("opt");

    try {                
        JDBC obj = new JDBC();
        String query = "update issuebooks set status=1 where bookid="+bid+" and memid="+sid;
        String query2 = "update books set noofcopies=noofcopies+1 where bid="+bid;
        
        System.out.println(query);
        System.out.println(query2);
        
        obj.createConnection();
        obj.updateRecord(query);        
        obj.updateRecord(query2);        
        obj.closeConnection();
        
        response.sendRedirect("vbooksAdmin.jsp?msg=Books Returned In DB&idnumber="+sid);
    } catch (Exception e) {
        e.printStackTrace();        
        response.sendRedirect("vbooksAdmin.jsp?msg="+e.toString()+"&idnumber="+sid);
    }
%>