<%@page import="activity.JDBC"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<center>

    <%
        String msg = request.getParameter("msg");
        msg = (msg == null ? "" : msg);

        if (true) {

            try {

                JDBC jdbc = new JDBC();
                jdbc.createConnection();

                String sql1 = "select * from books where status=0";
                ResultSet rset = jdbc.queryRecord(sql1);

                ResultSetMetaData rsmd = rset.getMetaData();
                int numColumns = rsmd.getColumnCount();

                String resultHtml = "";

                resultHtml += "<table border=1><caption><h3><font color='red'>All Results</font></h3></caption><thead>";
                resultHtml += "<tr>";

                for (int i = 1; i <= numColumns; i++) {
                    // uncomment the following three lines and define bool least to initiate blocking those columns
                    //boolean notDisplay = false;
                    //notDisplay = (i == 1);
                    //resultHtml += "<div align=\"center\"><th scope=\"row\" abbr=\"Mode 1\" class=\"specalt\">" + rsmd.getColumnName(i).toUpperCase() + "</th></div>";
                    String stylus = "";
                    if (i % 2 == 0) {
                        stylus = "specalt";
                    } else {
                        stylus = "spec";
                    }
                    //if (!notDisplay) {
                    resultHtml += "<div align=\"center\"><th scope=\"row\" class=\"" + stylus + "\">" + rsmd.getColumnName(i).toUpperCase()+ "</th></div>";
                    //}
                }
                resultHtml += "<div align=\"center\"><th scope=\"row\">Action</th></div>";
                resultHtml += "</tr></thead><tbody>";

                boolean found = rset.next();
                //out.println("<br><b>Sql Result</b>+"+query+"==>"+found);
                if (found) {
                    rset.last();
                    int count = rset.getRow();
                    int row = 0;
                    rset.beforeFirst();
                    while (rset.next()) {
                        row++;
                        resultHtml += "<tr>";                        
                        for (int i = 1; i <= numColumns; i++) {
                                // uncomment the following three lines and define bool least to initiate blocking those columns
                            //boolean notDisplay = false;
                            //notDisplay = (i == 1);
                            //if (!notDisplay) {
                            if (i == 6) {                                
                                if(rset.getString(i).equals("none.jpg")){
                                    resultHtml += "<div align=\"center\"><td scope=\"row\" class=\"specalt\"><img src='" + rset.getString(i) + "' width='64' height='64' /></td></div>";
                                }else{
                                    resultHtml += "<div align=\"center\"><td scope=\"row\" class=\"specalt\"><a href='" + rset.getString(i).replace("/content", "") + "&printsec=frontcover'>Image</a></td></div>";
                                }
                                
                            }
                            else if (i == 7) {                                
                                if(rset.getString(i).equals("NONE")){
                                    resultHtml += "<div align=\"center\"><td scope=\"row\" class=\"specalt\">NOTHING TO PREVIEW</td></div>";
                                }else{
                                    resultHtml += "<div align=\"center\"><td scope=\"row\" class=\"specalt\"><a href='" + rset.getString(i) + "'>Preview</a></td></div>";
                                }
                            } else {
                                resultHtml += "<div align=\"center\"><td scope=\"row\" class=\"specalt\">" + rset.getString(i) + "</td></div>";
                            }                            
                        }
                        resultHtml += "<div align=\"center\"><td scope=\"row\" class=\"specalt\"><a href='pubBooks.jsp?id=" + rset.getString(1)+"&opt=1'>Publish Book</a></td></div>";
                        resultHtml += "</tr>";

                    }
                }
                out.println(resultHtml);
            } catch (Exception e) {
                out.println("<br /><b>Exception : " + e.toString() + "</b>");
            }

        }
    %>
</center>
