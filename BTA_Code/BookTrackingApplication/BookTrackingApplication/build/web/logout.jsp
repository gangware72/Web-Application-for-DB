<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    session = request.getSession(false);
    
    if (session != null) {
        session.invalidate();        
        response.sendRedirect("index.jsp?msg=Succesfully Logged Out");
    }
    else
    {
        response.sendRedirect("index.jsp?msg=Already Logged Out");
    }
    


%>
