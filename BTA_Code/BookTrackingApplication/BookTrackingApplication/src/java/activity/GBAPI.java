/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author Sandeep
 */
@WebServlet(name = "GBAPI", urlPatterns = {"/GBAPI"})
public class GBAPI extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuffer output = new StringBuffer();
        try {
            String mykey = "AIzaSyDfMDtpA724ATwfZX3eRLWQZOQlPfKtW60";
            String book_name = request.getParameter("book_name");
            String author_name = request.getParameter("author_name");
            String isbn_number = request.getParameter("isbn_number");
            String lccn = request.getParameter("lccn");
            String ocln = request.getParameter("ocln");
            String filter_type = request.getParameter("filter_type");
            String book_name_url = book_name.replace(' ', '+');
            String author_name_url = author_name.replace(' ', '+');

            String isbn_number_url = isbn_number.replace(' ', '+');
            String filter_type_url = filter_type.replace(' ', '+');
            String query = "";
            if (author_name_url.isEmpty() == false && isbn_number_url.isEmpty() == false) {

                query = "https://www.googleapis.com/books/v1/volumes?q=" + book_name_url + "+iauthor:" + author_name_url + "+isbn:"
                        + isbn_number_url + "&key=" + mykey + "&prettyPrint=true&filter=" + filter_type_url;
            } else if (author_name_url.isEmpty() == true && isbn_number_url.isEmpty() == false) {
                query = "https://www.googleapis.com/books/v1/volumes?q=" + book_name_url + "+isbn:"
                        + isbn_number_url + "&key=" + mykey + "&prettyPrint=true&filter=" + filter_type_url;
            } else if (author_name_url.isEmpty() == false && isbn_number_url.isEmpty() == true) {
                query = "https://www.googleapis.com/books/v1/volumes?q=" + book_name_url + "+iauthor:"
                        + author_name_url + "&key=" + mykey + "&prettyPrint=true&filter=" + filter_type_url;
            } else {
                query = "https://www.googleapis.com/books/v1/volumes?q=" + book_name_url + "&key=" + mykey + "&prettyPrint=true&filter=" + filter_type_url;
            }

            out.println(query + "\n");
            URL url = new URL(query);

            // Get the response
            InputStream inst = url.openStream();
            InputStreamReader isr = new InputStreamReader(inst);
            BufferedReader rd = new BufferedReader(isr);

            String line = "";
            while ((line = rd.readLine()) != null) {
                output.append(line);
            }
            // out.println(output.toString());
            String jsonline = output.toString();
            System.out.println("before try");
            //out.println(jsonline);
            try {
                System.out.println("start");
                JSONObject jsonObj = new JSONObject(jsonline);
                int totalItems = jsonObj.getInt("totalItems");

                System.out.println(totalItems);
                out.println("<h3>Here is the result of your search</h3>");
                //out.println(totalItems+" books have been found!");
                String[] keyAttributes = new String[totalItems];

                JSONArray jsonArray = jsonObj.getJSONArray("items");
                int json_size = jsonArray.length();
                for (int i = 0; i < json_size; i++) {
                    JSONObject jsonItem = jsonArray.getJSONObject(i);
                    JSONObject volumeInfo = jsonItem.getJSONObject("volumeInfo");
                    JSONObject imgLinks = volumeInfo.getJSONObject("imageLinks");

                    String title = volumeInfo.getString("title");
                    String authors = "";
                    String pubDate = volumeInfo.getString("publishedDate");
                    String desc = "There is no description";
                    if (volumeInfo.has("description")) {
                        desc =  volumeInfo.getString("description");
                    }
                    String image = imgLinks.getString("thumbnail");
                    String preview = volumeInfo.getString("previewLink");
                    
                    
                    out.println("<br />");
                    out.println("<table border='1'><tr><td class='headertd'> No. </td><td class='headertd'> Title </td><td class='headertd'> author </td>"
                            + "<td class='headertd'> Published Date </td>");
                    out.println("<tr><td>[" + (i + 1) + "]</td><td>" + title + "</td>");
                    JSONArray authorArray = volumeInfo.getJSONArray("authors");
                    int authors_size = authorArray.length();
                    out.println("<td>");
                    for (int j = 0; j < authors_size; j++) {
                        out.println(authorArray.getString(j) + "\n");
                        authors += authorArray.getString(j)+",";
                    }
                    if(authors.trim().endsWith(",")){                        
                        authors = authors.trim().substring(0, authors.trim().length()-1);
                    }
                    out.println("</td>");
                    out.println("<td>" + pubDate + "</td></tr>");
                    if (volumeInfo.has("description")) {
                        out.println("<tr><td colSpan=3>" + desc + "</td>");
                    } else {
                        out.println("<tr><td colSpan=3>There is no description</td>");
                    }

                    out.println("<td style='width:128px'><img src='" + image + "'/>");
                    out.println("<p><a href='" + preview + "' class='links'>Preview</a></p>");
                    out.println("<p><input type='button' onclick='UpdateBook(this)' id='"+i+"' name='"+i+"' value='Update This Book Details' /></p>");
                    out.println("<p><div id='"+i+"_r'></div></p>");
                    out.println("</td></tr></table>");
                    
                    out.println("<input type='hidden' id='t-"+i+"' value='"+title+"' />");
                    out.println("<input type='hidden' id='a-"+i+"' value='"+authors+"' />");
                    out.println("<input type='hidden' id='p-"+i+"' value='"+pubDate+"' />");
                    out.println("<input type='hidden' id='d-"+i+"' value='"+desc+"' width='500' />");
                    out.println("<input type='hidden' id='i-"+i+"' value='"+image+"' />");
                    out.println("<input type='hidden' id='pre-"+i+"' value='"+preview+"' />");
                    // out.println("[" + i + "]=" + jsonItem.getString(""));
                }

            } catch (JSONException ex) {
                Logger.getLogger(GBAPI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (MalformedURLException mue) {
            output.append("error in URL");
        } catch (IOException ie) {
            output.append("error in IO");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
