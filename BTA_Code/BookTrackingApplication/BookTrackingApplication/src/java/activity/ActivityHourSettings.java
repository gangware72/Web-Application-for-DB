/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletContext;

/**
 *
 * @author 108
 */
public class ActivityHourSettings {

    public static String projectTitle = "High School Book Tracking Application";
    public static int dueDateDays = 14;
    public static double fine = 0.50;//cents
    
    public static String getDbDriver() {
        return "com.mysql.jdbc.Driver";
    }

    public static String getDbUser() {
        return "root";
    }

    public static String getDbPassword() {
        return "123456";
    }

    public static String getDbUrl() {
        return "jdbc:mysql://localhost/bta";
    }

    public static String updateTableUsers(String query, String filteredColumns, String keyColumn, String tableHeading, String actionUrl, String actionName) {
        try {
            JDBC dbfunc = new JDBC();
            dbfunc.createConnection();

            ResultSet rs = dbfunc.queryRecord(query);
            ResultSet rset = dbfunc.queryRecord(query);
            ResultSetMetaData rsmd = rset.getMetaData();
            int numColumns = rsmd.getColumnCount();
            String resultHtml = "";
            resultHtml += "<table border=1><caption><h3><font color='red'>" + tableHeading + "</font></h3></caption><thead>";
            resultHtml += "<tr>";
            for (int i = 1; i <= numColumns; i++) {
                String check = "(" + i + ")";
                if (!filteredColumns.contains(check)) {
                    if (i == 4) {
                        resultHtml += "<th>" + rsmd.getColumnName(i).toUpperCase() + "</th>";
                        continue;
                    }
                    if (i == 5) {
                        resultHtml += "<th>" + rsmd.getColumnName(i).toUpperCase() + "</th>";
                        continue;
                    }
                    if (i == 6) {
                        resultHtml += "<th>" + rsmd.getColumnName(i).toUpperCase() + "</th>";
                        continue;
                    }
                    resultHtml += "<th>" + rsmd.getColumnName(i).toUpperCase() + "</th>";
                }
            }
            resultHtml += "<th>Action</th>";
            resultHtml += "</tr></thead><tbody>";
            boolean found = rset.next();
            if (found) {
                rset.last();
                int count = rset.getRow();
                int row = 0;
                rset.beforeFirst();
                while (rset.next()) {
                    row++;
                    resultHtml += "<tr>";
                    String key = "none";
                    for (int i = 1; i <= numColumns; i++) {
                        String check = "(" + i + ")";
                        if (!filteredColumns.contains(check)) {                           
                            resultHtml += "<td>" + rset.getString(i) + "</td>";
                        }

                        if (keyColumn.trim().equals(check)) {
                            key = rset.getString(i).trim();
                        }
                    }
                    resultHtml += "<td><a href='" + actionUrl + "&key=" + key + "'>" + actionName + "</a></td>";
                    resultHtml += "</tr>";

                }
            }
            dbfunc.closeConnection();
            return resultHtml;
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    public static boolean isWeekend(String ts) {
        int year = Integer.parseInt(ts.substring(0, 4));
        int month = Integer.parseInt(ts.substring(4, 6));
        int day = Integer.parseInt(ts.substring(6, 8));
        Calendar cal = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //return (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek);
        return (Calendar.SUNDAY == dayOfWeek);
    }

    public static ArrayList<String> randomization(ArrayList<String> data) {
        Collections.shuffle(data);
        return data;
    }

    public static Date addDateAndReturnDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        Date newDate = cal.getTime();
        System.out.println(newDate);
        return newDate;
    }

    public static String currentDateAndReturnHyphenFormat(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int yearC = cal.get(Calendar.YEAR);
        int monthC = cal.get(Calendar.MONTH) + 1;
        int dayC = cal.get(Calendar.DAY_OF_MONTH);

        String tempYear = Integer.toString(yearC);
        String tempMonth = Integer.toString(monthC);
        String tempDay = Integer.toString(dayC);

        if (tempMonth.length() == 1) {
            tempMonth = "0" + tempMonth;
        }
        if (tempDay.length() == 1) {
            tempDay = "0" + tempDay;
        }

        String dateCheck = tempYear + "-" + tempMonth + "-" + tempDay;
        return dateCheck;
    }

    public static String currentDateAndReturnDateString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int yearC = cal.get(Calendar.YEAR);
        int monthC = cal.get(Calendar.MONTH) + 1;
        int dayC = cal.get(Calendar.DAY_OF_MONTH);

        String tempYear = Integer.toString(yearC);
        String tempMonth = Integer.toString(monthC);
        String tempDay = Integer.toString(dayC);

        if (tempMonth.length() == 1) {
            tempMonth = "0" + tempMonth;
        }
        if (tempDay.length() == 1) {
            tempDay = "0" + tempDay;
        }

        String dateCheck = tempYear + tempMonth + tempDay;
        return dateCheck;
    }

    public static String contextPath = "";

    public static void setContext(ServletContext context) {
        String root = context.getRealPath("");
        File rootDir = new File(root);
        contextPath = rootDir.getAbsolutePath().replace("build\\web", "");
    }
}
